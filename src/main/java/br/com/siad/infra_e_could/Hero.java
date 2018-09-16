package br.com.siad.infra_e_could;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "heroi")
public class Hero {

    @Id
    private String id;
    private String name;

    public Hero(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Hero() {
    }

    public Hero(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
