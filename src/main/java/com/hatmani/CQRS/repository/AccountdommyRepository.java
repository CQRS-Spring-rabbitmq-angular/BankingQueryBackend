package com.hatmani.CQRS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hatmani.CQRS.entity.Accountdommy;


@Repository
public interface AccountdommyRepository extends JpaRepository<Accountdommy, String> {

}
