package com.example.university.mongo.repositories;

import com.example.university.mongo.dto.SofaCustomerRate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SofaCustomerRateRepository extends MongoRepository<SofaCustomerRate, String> {

	List<SofaCustomerRate> findBySofaId(Integer sofaId);
}
