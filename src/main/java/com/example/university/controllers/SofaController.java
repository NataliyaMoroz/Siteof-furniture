package com.example.university.controllers;

import com.example.university.dao.Sofa;
import com.example.university.mongo.dto.SofaCustomerRate;
import com.example.university.mongo.repositories.SofaCustomerRateRepository;
import com.example.university.mongo.dto.SofaFeedback;
import com.example.university.mongo.repositories.SofaFeedbackRepository;
import com.example.university.repositories.SofaRepository;
import com.example.university.services.SofaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/be/sofa")
@Slf4j
public class SofaController {

    @Autowired
    SofaRepository sofaRepository;
    @Autowired
    SofaService sofaService;
    @Autowired
	SofaFeedbackRepository sofaFeedbackRepository;
    @Autowired
	SofaCustomerRateRepository sofaCustomerRateRepository;

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

    @GetMapping(value = "/feedback/{id}")
	public List<SofaFeedback> sofaFeedbacks(@PathVariable Integer id) {
    	return sofaFeedbackRepository.findBySofaId(id);
	}

    @GetMapping(value = "/feedback/all")
	public List<SofaFeedback> sofaAllFeedbacks() {
    	return sofaFeedbackRepository.findAll();
	}

	@PostMapping(value = "/feedback/insert")
	public ResponseEntity addFeedback(@Valid @RequestBody SofaFeedback sofaFeedback) {
		sofaFeedbackRepository.insert(sofaFeedback);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/rate/{id}")
	public double getAverageRate(@PathVariable Integer id) {
		List<SofaCustomerRate> rates = sofaCustomerRateRepository.findBySofaId(id);
		return rates.stream()
				.mapToInt(SofaCustomerRate::getRate)
				.average()
				.orElse(-1);
	}

	@PostMapping(value = "/rate/submit")
	public ResponseEntity submitRate(@Valid @RequestBody SofaCustomerRate sofaCustomerRate){
    	sofaCustomerRateRepository.insert(sofaCustomerRate);
    	return ResponseEntity.ok().build();
	}

    @DeleteMapping(value = "/delete")
    public ResponseEntity deleteSofa(@RequestBody int id) {
        sofaRepository.delete(id);
        return ResponseEntity.ok().build();
    }
}
