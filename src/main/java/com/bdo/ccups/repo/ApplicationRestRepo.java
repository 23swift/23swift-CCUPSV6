package com.bdo.ccups.repo;

import com.bdo.ccups.model.Application;

import org.springframework.data.repository.CrudRepository;

public interface ApplicationRestRepo extends CrudRepository<Application,Long> {}