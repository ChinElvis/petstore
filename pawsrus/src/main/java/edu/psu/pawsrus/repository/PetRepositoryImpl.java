package edu.psu.pawsrus.repository;


import edu.psu.pawsrus.model.Pet;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PetRepositoryImpl implements PetRepository{

    private List<Pet> petList = new ArrayList<>();

    @Override
    public List<Pet> getPets(){
        return petList;
    }

    @Override
    public void addPet(Pet pet) {
        if(pet.id() == null) {
            var largestPetId = petList.stream().map(Pet::id).mapToInt(Long::intValue).max();
            if(largestPetId.isEmpty()){
                pet = new Pet((long) 1, pet.name(), pet.type(), pet.weight(), pet.age());
            } else {
                pet = new Pet((long) (largestPetId.getAsInt() + 1),pet.name(), pet.type(), pet.weight(), pet.age());
            }
        }
        petList.add(pet);
    }

    @Override
    public List<Pet> getFilteredPets(String search) {
        return null;
    }

    @Override
    public void deletePet(Long petId) {

    }

    @Override
    public Pet getPetById(Long petId) {
        return petList.stream().filter(p -> Objects.equals(p.id(), petId)).findFirst().orElse(null);
    }

    @Override
    public void editPet(String name, String type, Double weight, Integer age, Long petId) {
        var newPet = new Pet(petId, name, type, weight, age);
        for(int i =0; i < petList.size(); i++){
            if(Objects.equals(petList.get(i).id(), petId)){
                petList.set(i, newPet);
            }
        }
    }
}
