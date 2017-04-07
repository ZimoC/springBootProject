package com.dogaozdemir.springBootProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.dogaozdemir.springBootProject.model.Meter;
import com.dogaozdemir.springBootProject.model.comp.MeterId;

public interface MeterRepository extends CrudRepository<Meter, MeterId>{

}
