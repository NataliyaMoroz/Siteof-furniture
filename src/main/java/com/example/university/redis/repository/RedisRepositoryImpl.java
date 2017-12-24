package com.example.university.redis.repository;

import com.example.university.redis.user.UserSettings;
import com.example.university.redis.user.UserSettingsEvelope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class RedisRepositoryImpl implements RedisRepository {
	private static final String KEY = "UserSettingsEvelope";

	private RedisTemplate<String, Object> redisTemplate;
	private HashOperations hashOperations;

	@Autowired
	public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public Map<Object, Object> findAllUserSettings() {
		return hashOperations.entries(KEY);
	}

	public void add(final UserSettingsEvelope userSettingsEvelope) {
		hashOperations.put(KEY, userSettingsEvelope.getUserId(), userSettingsEvelope.getInfo());
	}

	public void delete(final Long id) {
		hashOperations.delete(KEY, id);
	}

	public UserSettings findUserSettings(final Long id) {
		return (UserSettings) hashOperations.get(KEY, id);
	}
}
