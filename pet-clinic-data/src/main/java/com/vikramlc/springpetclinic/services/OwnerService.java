package com.vikramlc.springpetclinic.services;

import com.vikramlc.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
