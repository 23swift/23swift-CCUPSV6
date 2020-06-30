package com.bdo.ccups.repo;

import javax.annotation.Resources;

import com.bdo.ccups.model.Application;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "apps")
public interface ApplicationRestRepo extends CrudRepository<Application,Long> {}