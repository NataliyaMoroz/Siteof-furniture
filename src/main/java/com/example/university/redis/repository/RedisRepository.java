package com.example.university.redis.repository;

import com.example.university.redis.user.UserSettings;
import com.example.university.redis.user.UserSettingsEvelope;

import java.util.Map;

public interface RedisRepository  {

	Map findAllUserSettings();

	void add(UserSettingsEvelope userSettingsEvelope);

	void delete(Long id);

	UserSettings findUserSettings(Long id);
}
