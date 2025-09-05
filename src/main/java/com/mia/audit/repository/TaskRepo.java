package com.mia.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mia.audit.model.entity.Task;
@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

}
