package com.vikramlc.springpetclinic.repositories;

import com.vikramlc.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
