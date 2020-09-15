package com.shubhi.smartreceipt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shubhi.smartreceipt.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
