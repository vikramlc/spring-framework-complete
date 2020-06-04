package com.vikramlc.springpetclinic.repositories;

import com.vikramlc.springpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
