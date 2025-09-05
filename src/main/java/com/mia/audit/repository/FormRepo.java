package com.mia.audit.repository;

import com.mia.audit.model.entity.Form;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FormRepo extends JpaRepository<Form, Long> {

}
