package com.app.schoolparent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.schoolparent.entity.ParentDetails;

public interface ParentRepository extends JpaRepository<ParentDetails , Integer>{
}
