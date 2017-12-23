package com.example.university.mongo.dto;

import com.example.university.mongo.dto.feedbacks.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class SofaCustomerRate {
	@Id
	private String id;
	@NotNull
	private Integer sofaId;
	@NotNull
	private CustomerFeedback generalProductQuality;
	@NotNull
	private CustomerFeedback expectedAndRealQuality;
	@NotNull
	private CustomerFeedback recommendThisProduct;
	@NotNull
	private CustomerFeedback deliverySpeed;
}
