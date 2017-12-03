package com.example.university.repositories;

import com.example.university.dao.Bed;
import com.example.university.dao.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Наталия on 03.12.2017.
 */
public interface BedRepository extends CrudRepository<User, Long> {

    List<Bed> findBySize(String size);

    List<Bed> findByWoodVariety(String woodVariety);
}
