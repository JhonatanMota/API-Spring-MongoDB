package br.com.siad.infra_e_could;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {
    @Autowired
    private HeroRepository heroRepository;

    public List<Hero> findAll(){
        return heroRepository.findAll();
    }

    public Hero save(Hero hero){
        return heroRepository.save(hero);
    }

    public void remove(String id){
        heroRepository.deleteById(id);
    }

    public List<Hero> findByName(String name){
        return heroRepository.findHeroByName(name);
    }
}
