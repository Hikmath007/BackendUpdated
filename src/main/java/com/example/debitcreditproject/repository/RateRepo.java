
package com.example.debitcreditproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.debitcreditproject.entity.RateEntity;

@Repository
public interface RateRepo extends JpaRepository<RateEntity, Long> {

}
