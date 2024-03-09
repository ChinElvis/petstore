package edu.psu.pawsrus.bootstrap;

import edu.psu.pawsrus.model.Pet;
import edu.psu.pawsrus.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PetRepository petRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        petRepository.addPet(new Pet(null, "Snoopy", "Cat", 20.0, 10));
        petRepository.addPet(new Pet(null, "Little Squid", "Cat", 6.0, 5));
        petRepository.addPet(new Pet(null, "Dog", "Dog", 6.0, 5));


    }

}
