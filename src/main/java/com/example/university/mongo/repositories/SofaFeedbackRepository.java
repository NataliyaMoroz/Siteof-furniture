package com.example.university.mongo.repositories;

import com.example.university.mongo.dto.SofaFeedback;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SofaFeedbackRepository extends MongoRepository<SofaFeedback, String> {

	List<SofaFeedback> findBySofaId(Integer sofaId);
}
