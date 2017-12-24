package com.example.university;

import com.example.university.redis.repository.RedisRepository;
import com.example.university.redis.user.UserSettings;
import com.example.university.redis.user.UserSettingsEvelope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping(value = "/redis")
public class TestController {


	@Autowired
	private RedisRepository redisRepository;

	@GetMapping(value = "/values")
	public ResponseEntity testAuthenticated() {
		Map allUserSettings = redisRepository.findAllUserSettings();
		return ResponseEntity.ok(allUserSettings);
	}

	@GetMapping(value = "/add/{id}/{text}")
	public ResponseEntity add(@PathVariable Long id, @PathVariable String text){
		UserSettingsEvelope userSettingsEvelope = new UserSettingsEvelope( id, UserSettings.builder()
				.armrest("armrest")
				.brands(Arrays.asList("IKEA, CHECK"))
				.furnitureCategory(text)
				.build());
		redisRepository.add(userSettingsEvelope);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "{id}")
	public ResponseEntity get(@PathVariable Long id){
		UserSettings userSettings = redisRepository.findUserSettings(id);
		return ResponseEntity.ok(userSettings);
	}

}
