package com.hatmani.CQRS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hatmani.CQRS.entity.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
