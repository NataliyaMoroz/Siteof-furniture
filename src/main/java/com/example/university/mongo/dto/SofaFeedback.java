package com.example.university.mongo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class SofaFeedback {
	@Id
	private String id;
	@NotNull
	private Integer sofaId;
	@NotNull
	private String description;
}
