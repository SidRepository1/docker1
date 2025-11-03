package com.in.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
}
