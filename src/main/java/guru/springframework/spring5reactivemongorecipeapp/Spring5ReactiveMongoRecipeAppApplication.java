package guru.springframework.spring5reactivemongorecipeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class Spring5ReactiveMongoRecipeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring5ReactiveMongoRecipeAppApplication.class, args);
    }
}
