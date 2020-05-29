package com.vikramlc.springpetclinic.bootstrap;

import com.vikramlc.springpetclinic.model.Owner;
import com.vikramlc.springpetclinic.model.PetType;
import com.vikramlc.springpetclinic.model.Vet;
import com.vikramlc.springpetclinic.services.OwnerService;
import com.vikramlc.springpetclinic.services.PetTypeService;
import com.vikramlc.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Max");
        owner1.setLastName("Miller");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mary");
        owner2.setLastName("Jane");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Billy");
        vet1.setLastName("Mayor");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sheldon");
        vet2.setLastName("Cooper");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
