package com.example.university.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor@Wither
public class Booking {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	Integer id;

	Long idUser;

	@NotNull
	Integer idFurniture;

	@NotNull
	String category;
}
