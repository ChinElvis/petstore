package edu.psu.pawsrus.repository;

import edu.psu.pawsrus.model.Pet;

import java.util.List;

public interface PetRepository {

    List<Pet> getPets();

    void addPet(Pet pet);

    List<Pet> getFilteredPets(String search);

    void deletePet(Long petId);

    Pet getPetById(Long petID);

    void editPet(String name, String type, Double weight, Integer age, Long petId);
}
