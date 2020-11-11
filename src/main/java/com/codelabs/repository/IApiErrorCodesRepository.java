package com.codelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codelabs.model.ApiErrorCodes;

@Repository
public interface IApiErrorCodesRepository extends JpaRepository<ApiErrorCodes, Long>{
	ApiErrorCodes findByCode(String code);
}
