package com.vikramlc.springpetclinic.repositories;

import com.vikramlc.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
