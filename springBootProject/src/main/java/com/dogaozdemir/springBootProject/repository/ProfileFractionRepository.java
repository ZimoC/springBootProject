package com.dogaozdemir.springBootProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.dogaozdemir.springBootProject.model.ProfileFraction;
import com.dogaozdemir.springBootProject.model.comp.ProfileFractionId;

public interface ProfileFractionRepository extends CrudRepository<ProfileFraction, ProfileFractionId>{

}
