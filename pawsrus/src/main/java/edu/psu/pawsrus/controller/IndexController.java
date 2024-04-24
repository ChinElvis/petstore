package edu.psu.pawsrus.controller;


import edu.psu.pawsrus.model.Pet;
import edu.psu.pawsrus.service.PetService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Stream;

@Controller
public class IndexController {

    @Autowired
    private PetService petService;

    @GetMapping(value = "/")
    public String layout(Model model){
        List<Pet> pets = petService.getPets();
        model.addAttribute("pets", pets);
        return "layout";
    }

    @GetMapping("/add-pet")
    public String addPetPage(Model model){
        return "addPet";
    }

    @PostMapping("/add-pet")
    public String submitAddPet(Model model, @RequestParam String name, @RequestParam String type, @RequestParam Double weight, @RequestParam Integer age){
        petService.addPet(name, type, weight,age);
        List<Pet> pets = petService.getPets();
        model.addAttribute("pets", pets);
        return "layout";
    }

    @GetMapping("/delete-pet/{petId}")
    public String deletePet(Model model, @PathVariable Long petId){
        petService.deletePet(petId);
        List<Pet> pets = petService.getPets();
        model.addAttribute("pets", pets);
        return "layout";
    }

    @GetMapping("/edit-pet")
    public String editPetPage(){
        return "editPet";
    }

    @GetMapping("/edit-pet/{petId}")
    public String editPet(Model model, @PathVariable Long petId){
        Pet pet = petService.getPetById(petId);
        model.addAttribute("pet", pet);
        return "editPet";
    }

    @PostMapping("/edit-pet")
    public String submitEditPet(Model model, @RequestParam String name,  @RequestParam String type, @RequestParam Double weight, @RequestParam Integer age, @RequestParam Long petId){
        petService.editPet(name, type, weight, age, petId);
        List<Pet> pets = petService.getPets();
        model.addAttribute("pets", pets);
        return "layout";
    }


}
