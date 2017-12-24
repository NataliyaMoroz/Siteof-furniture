package com.example.university.redis.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Wither
@Builder
public class UserSettings implements Serializable {
	String currentPage;
	String furnitureCategory;
	Integer priceFrom;
	Integer priceTo;
	String armrest;
	List<String> brands;
}
