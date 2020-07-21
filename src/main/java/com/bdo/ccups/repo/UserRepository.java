package com.bdo.ccups.repo;

import com.bdo.ccups.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User,Long>{}