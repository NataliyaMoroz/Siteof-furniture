package com.example.university.services;

import com.example.university.dao.Sofa;
import com.example.university.repositories.SofaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Наталия on 09.12.2017.
 */

@Service
public class SofaService {

    @Autowired
    private SofaRepository sofaRepository;

    public Iterable<Sofa> findAllByPriceMoreThanEqualBrandAndArmrest(int price1, List<String> brand, String armrest) {
        return findAllByPriceBetweenAndBrandAndArmrest(price1, Integer.MAX_VALUE, brand, armrest);
    }

    public Iterable<Sofa> findAllByPriceLessThanEqualBrandAndArmrest(int price2, List<String> brand, String armrest) {
        return findAllByPriceBetweenAndBrandAndArmrest(0, price2, brand, armrest);
    }

    public Iterable<Sofa> findAllByPriceAndBrandAndArmrest(List<String> brand, String armrest) {
        return findAllByPriceBetweenAndBrandAndArmrest(0, Integer.MAX_VALUE, brand, armrest);
    }

    public Iterable<Sofa> findAllByPriceBetweenAndBrandAndArmrest(int price1, int price2, List<String> brand, String armrest) {
        if (brand== null && armrest == null) {
            return sofaRepository.findAllByPriceBetween(price1, price2);
        }
        else if(brand == null) {
            return sofaRepository.findAllByPriceBetweenAndArmrest(price1, price2, armrest);
        }
        else if(armrest == null) {
            return sofaRepository.findAllByPriceBetweenAndBrandIn(price1, price2, brand);
        }
        return sofaRepository.findAllByPriceBetweenAndBrandInAndArmrest(price1, price2, brand, armrest);
    }
}
