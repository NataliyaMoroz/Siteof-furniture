package com.example.university.repositories;

import com.example.university.dao.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
	List<Booking> findByCategoryAndAndIdFurnitureAndIdUser(String category, Integer furnitureId, Long userId);
}
