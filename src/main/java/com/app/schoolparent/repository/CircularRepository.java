package com.app.schoolparent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.schoolparent.entity.CircularDetails;

public interface CircularRepository extends JpaRepository<CircularDetails , Integer>{
}
