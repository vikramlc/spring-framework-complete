package com.vikramlc.springpetclinic.bootstrap;

import com.vikramlc.springpetclinic.model.Owner;
import com.vikramlc.springpetclinic.model.Pet;
import com.vikramlc.springpetclinic.model.PetType;
import com.vikramlc.springpetclinic.model.Vet;
import com.vikramlc.springpetclinic.services.OwnerService;
import com.vikramlc.springpetclinic.services.PetTypeService;
import com.vikramlc.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("123 Baker street");
        owner1.setCity("Miami");
        owner1.setTelephone("12324323");

        Pet mikesPet = new Pet();
        mikesPet.setName("Rosco");
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setOwner(owner1);

        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mary");
        owner2.setLastName("Jane");
        owner2.setAddress("456 Blaker Street");
        owner2.setCity("Florida");
        owner2.setTelephone("23432432");

        Pet fionasCat = new Pet();
        fionasCat.setName("Kitty");
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setOwner(owner2);

        owner2.getPets().add(fionasCat);

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
