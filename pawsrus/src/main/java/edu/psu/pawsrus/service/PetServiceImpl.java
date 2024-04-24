package edu.psu.pawsrus.service;

import edu.psu.pawsrus.model.Pet;
import edu.psu.pawsrus.repository.PetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    private PetRepository petRepository;
    @Override
    public List<Pet> getPets() {
        return petRepository.getPets();
    }

    @Override
    public void addPet(String name, String type, Double weight, Integer age) {
        var newPet = new Pet(null, name, type, weight, age);
        petRepository.addPet(newPet);
    }

    @Override
    public List<Pet> getFilteredPets(String search) {
        if(!StringUtils.hasText(search)){
            throw new IllegalArgumentException("search required");
        }
        return petRepository.getFilteredPets(search);
    }

    @Override
    public void deletePet(Long petId) {
        if (petId == null || petId<=0){
            throw new IllegalArgumentException("Pet ID is required");
        }
        petRepository.deletePet((petId));
    }

    @Override
    public Pet getPetById(Long petID) {
        return petRepository.getPetById(petID);
    }

    @Override
    public void editPet(String name, String type, Double weight, Integer age, Long petId) {
        petRepository.editPet(name, type, weight, age, petId);
    }
}
