package com.example.university.controllers;

import com.example.university.dao.Sofa;
import com.example.university.repositories.SofaRepository;
import com.example.university.services.SofaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Наталия on 03.12.2017.
 */
@RestController
@RequestMapping(value = "/be/sofa")
public class SofaController {

    @Autowired
    SofaRepository sofaRepository;
    @Autowired
    SofaService sofaService;

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody Sofa sofa) {
        sofaRepository.save(sofa);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/all")
    public Iterable<Sofa> getByBrandAndArmrest(@RequestParam(value = "priceFrom", required = false) Integer price1,
                                               @RequestParam(value = "priceTo", required = false) Integer price2,
                                               @RequestParam(value = "brand", required = false) String brand,
                                           @RequestParam(value = "armrest", required = false) String armrest) {
        if (price1 == null && price2 != null) {
            return sofaService.findAllByPriceLessThanEqualBrandAndArmrest(price2, brand, armrest);
        }
        else if (price1 != null && price2 == null) {
            return sofaService.findAllByPriceMoreThanEqualBrandAndArmrest(price1, brand, armrest);
        }
        else if (price1 == null && price2 == null) {
            return sofaService.findAllByPriceAndBrandAndArmrest(brand, armrest);
        }
        return sofaService.findAllByPriceBetweenAndBrandAndArmrest(price1, price2, brand, armrest);
    }


    @DeleteMapping(value = "/delete")
    public ResponseEntity deleteSofa(@RequestBody int id) {
        sofaRepository.delete(id);
        return ResponseEntity.ok().build();
    }
}
