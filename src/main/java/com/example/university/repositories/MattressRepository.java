package com.example.university.repositories;

import com.example.university.dao.Mattress;
import com.example.university.dao.Sofa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Наталия on 03.12.2017.
 */

public interface MattressRepository extends CrudRepository<Mattress, Integer> {

    List<Mattress> findByMaxWeight(int weight);
}
