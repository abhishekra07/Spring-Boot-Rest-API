package com.codelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codelabs.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

}