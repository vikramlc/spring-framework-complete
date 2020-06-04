package com.vikramlc.springpetclinic.repositories;

import com.vikramlc.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
