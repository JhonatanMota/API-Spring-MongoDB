package br.com.siad.infra_e_could;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/herois")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @CrossOrigin(origins = {"http://localhost:63342", "null", "http://13.59.26.95:8080", "http://app-pos-uft.s3-website.us-east-2.amazonaws.com"})
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity saveHero(@RequestBody Hero hero) {
        return ResponseEntity.ok(heroService.save(hero));
    }

    @CrossOrigin(origins = {"http://localhost:63342", "null", "http://13.59.26.95:8080", "http://app-pos-uft.s3-website.us-east-2.amazonaws.com"})
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity deleteHero(@RequestBody String id) {
        try {
            heroService.remove(id);
            return ResponseEntity.ok("Sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @CrossOrigin(origins = {"http://localhost:63342", "null", "http://13.59.26.95:8080", "http://app-pos-uft.s3-website.us-east-2.amazonaws.com"})
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity findByName(@Param("name") String name) {
        return ResponseEntity.ok(heroService.findByName(name));
    }

    @CrossOrigin(origins = {"http://localhost:63342", "null", "http://13.59.26.95:8080", "http://app-pos-uft.s3-website.us-east-2.amazonaws.com"})
    @RequestMapping(value="/All", method=  RequestMethod.GET)
    public ResponseEntity getAll(){
        return ResponseEntity.ok(heroService.findAll());
    }
}
