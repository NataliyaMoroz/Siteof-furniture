package com.example.university.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Наталия on 03.12.2017.
 */
@Entity
@Data
@Wither
@NoArgsConstructor
@AllArgsConstructor
public class Sofa {

    @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
    private int price;
    private String brand;
    private String armrest;
    private int numOfSeats;
    private String description;

}
