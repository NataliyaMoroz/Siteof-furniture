package com.example.university.repositories;

import com.example.university.dao.Sofa;
import com.example.university.dao.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Наталия on 03.12.2017.
 */
public interface SofaRepository extends CrudRepository<Sofa, Integer> {

    List<Sofa> findAllByPriceBetween(int price1, int price2);

    List<Sofa> findAllByPriceBetweenAndBrandIn(int price1, int price2, List<String> brand);

    List<Sofa> findAllByPriceBetweenAndArmrest(int price1, int price2, String armrest);

    List<Sofa> findAllByPriceBetweenAndBrandInAndArmrest(int price1, int price2, List<String> brand, String armrest);
}
