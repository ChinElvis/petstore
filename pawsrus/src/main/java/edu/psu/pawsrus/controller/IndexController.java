package edu.psu.pawsrus.controller;


import edu.psu.pawsrus.model.Pet;
import edu.psu.pawsrus.service.PetService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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


}
