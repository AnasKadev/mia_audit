package com.mia.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mia.audit.model.entity.ActionPlan;
@Repository
public interface ActionPlanRepo extends JpaRepository<ActionPlan, Long> {

}
