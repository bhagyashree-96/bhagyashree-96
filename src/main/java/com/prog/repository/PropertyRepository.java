package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prog.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer>{



	Property findByName(String em);

}
