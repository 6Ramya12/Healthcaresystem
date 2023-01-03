package com.cg.hcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hcs.dto.TestResult;

public interface ITestResultRepository extends JpaRepository<TestResult,Integer> {

}
