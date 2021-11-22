package com.example.demo.movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    private static final List<Movie> MOVIES = Arrays.asList(
            new Movie(1, "Torrente, el brazo tonto de la ley", "Torrente es un policía español, machista, racista y alcohólico. " +
                    "Este magnífico representante de las fuerzas del orden vive, con su padre hemipléjico, en Madrid. " +
                    "Gracias a su olfato, descubre en su propio barrio una importante red de narcotraficantes.", 1998, "Santiago Segura"),
            new Movie(2, "Robocop 2", "Bajo un cielo carente de ozono y en una época futurista, la policía de Detroit está en huelga, y las peligrosas bandas criminales dominan a la población. " +
                    "Sin embargo, Robocop no se rinde y trata de hacer frente a la adicción a una nueva droga que existe entre los habitantes.", 1990, "Irvin Kershner"),
            new Movie(3, "Titanic", "Jack es un joven artista que gana un pasaje para viajar a América en el Titanic, el transatlántico más grande y seguro jamás construido.", 1998, "James Cameron")
    );

    @GetMapping(path = "{movieId}")
    public Movie getMovie(@PathVariable("movieId") Integer movieId){
        //movieId is the /{movieId}
        return MOVIES.stream()
                .filter(movie -> movieId.equals(movie.getMovieId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Movie " + movieId + " does not exist!"));
    }

}
