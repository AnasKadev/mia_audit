package com.mia.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mia.audit.model.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
