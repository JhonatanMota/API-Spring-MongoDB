package br.com.siad.infra_e_could;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "heroi", path = "hero")
public interface HeroRepository extends MongoRepository<Hero, String> {

    List<Hero> findHeroByName(String name);
}
