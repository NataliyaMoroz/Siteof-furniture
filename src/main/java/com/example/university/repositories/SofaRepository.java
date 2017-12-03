package com.example.university.repositories;

import com.example.university.dao.Sofa;
import com.example.university.dao.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Наталия on 03.12.2017.
 */
public interface SofaRepository extends CrudRepository<Sofa, Integer> {

    List<Sofa> findByBrand(String brand);

    List<Sofa> findByArmrest(String armrest);
}
