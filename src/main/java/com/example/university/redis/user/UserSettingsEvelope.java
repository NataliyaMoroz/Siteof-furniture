package com.example.university.redis.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSettingsEvelope {
	private Long userId;
	private UserSettings info;
}
