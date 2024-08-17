package com.example.backendex.config;
import com.example.backendex.model.Place;
import com.example.backendex.repository.PlaceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(PlaceRepository repository) {
        return args -> {
//            if (repository.count() == 0) {
                repository.save(new Place("Paris", "The city of lights", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/La_Tour_Eiffel_vue_de_la_Tour_Saint-Jacques%2C_Paris_ao%C3%BBt_2014_%282%29.jpg/640px-La_Tour_Eiffel_vue_de_la_Tour_Saint-Jacques%2C_Paris_ao%C3%BBt_2014_%282%29.jpg"));
                repository.save(new Place("New York", "The big apple", "https://i.natgeofe.com/k/5b396b5e-59e7-43a6-9448-708125549aa1/new-york-statue-of-liberty.jpg"));
                repository.save(new Place("Tokyo", "The capital of Japan", "https://media.nomadicmatt.com/2024/tokyothings.jpeg"));
                repository.save(new Place("Paris", "The city of lights", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/La_Tour_Eiffel_vue_de_la_Tour_Saint-Jacques%2C_Paris_ao%C3%BBt_2014_%282%29.jpg/640px-La_Tour_Eiffel_vue_de_la_Tour_Saint-Jacques%2C_Paris_ao%C3%BBt_2014_%282%29.jpg"));
                repository.save(new Place("New York", "The big apple", "https://i.natgeofe.com/k/5b396b5e-59e7-43a6-9448-708125549aa1/new-york-statue-of-liberty.jpg"));
                repository.save(new Place("Tokyo", "The capital of Japan", "https://media.nomadicmatt.com/2024/tokyothings.jpeg"));
                repository.save(new Place("Paris", "The city of lights", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/La_Tour_Eiffel_vue_de_la_Tour_Saint-Jacques%2C_Paris_ao%C3%BBt_2014_%282%29.jpg/640px-La_Tour_Eiffel_vue_de_la_Tour_Saint-Jacques%2C_Paris_ao%C3%BBt_2014_%282%29.jpg"));
                repository.save(new Place("New York", "The big apple", "https://i.natgeofe.com/k/5b396b5e-59e7-43a6-9448-708125549aa1/new-york-statue-of-liberty.jpg"));
                repository.save(new Place("Tokyo", "The capital of Japan", "https://media.nomadicmatt.com/2024/tokyothings.jpeg"));
//            }
        };
    }
}
