package com.example.university.repositories;

import com.example.university.dao.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
