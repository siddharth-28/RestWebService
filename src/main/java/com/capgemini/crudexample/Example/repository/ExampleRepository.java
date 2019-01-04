package com.capgemini.crudexample.Example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.crudexample.Example.domain.ExampleDomain;

@Repository
//ExampleDomain is the entity and Long is the type of ID
public interface ExampleRepository extends JpaRepository<ExampleDomain, Long> {

}
