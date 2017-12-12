package com.example.university.dao;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum FurnitureType {
	BED("bed", Bed.class),
	MATTRESS("mattress", Mattress.class),
	SOFA("sofa", Sofa.class);


	String name;
	Class clazz;

	@Override
	public String toString() {
		return this.name;
	}
}
