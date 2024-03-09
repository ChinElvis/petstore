package edu.psu.pawsrus.service;

import edu.psu.pawsrus.model.Pet;

import java.util.List;

public interface PetService {
    List<Pet> getPets();

    void addPet(String name, String type, Double weight, Integer age);

    List<Pet> getFilteredPets(String search);

    void deletePet(Long petId);

    Pet getPetById(Long petID);

    void editPet(String name, String type, Double weight, Integer age, Long petId);

}
