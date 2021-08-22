package com.hatmani.CQRS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hatmani.CQRS.entity.*;
@Repository
public interface OperationRepository extends JpaRepository<Operation, String> {
public List<Operation> findAllByAcountId(String AccountId);
					   
}
