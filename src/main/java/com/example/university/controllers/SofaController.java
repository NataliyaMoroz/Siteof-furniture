package com.example.university.controllers;

import com.example.university.dao.Sofa;
import com.example.university.dao.User;
import com.example.university.repositories.SofaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Наталия on 03.12.2017.
 */
@RestController
@RequestMapping(value = "/be/sofa")
public class SofaController {

    @Autowired
    SofaRepository sofaRepository;

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody Sofa sofa) {
        sofaRepository.save(sofa);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/get-brand")
    public List<Sofa> getByBrand(@RequestBody String brand) {
        return sofaRepository.findByBrand(brand);
    }

    @GetMapping(value = "/get-armrest")
    public List<Sofa> getByArmrest(@RequestBody String armrest) {
        return sofaRepository.findByArmrest(armrest);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity deleteSofa(@RequestBody int id) {
        sofaRepository.delete(id);
        return ResponseEntity.ok().build();
    }
}