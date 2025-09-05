package com.mia.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mia.audit.model.entity.DefaultForm;

public interface DefaultFormRepo extends JpaRepository<DefaultForm, Long> {

}
