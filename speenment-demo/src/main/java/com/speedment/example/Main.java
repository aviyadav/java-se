package com.speedment.example;

import com.company.sakila.SakilaApplication;
import com.company.sakila.SakilaApplicationBuilder;
import com.company.sakila.sakila.sakila.actor.Actor;
import com.company.sakila.sakila.sakila.film.Film;
import com.company.sakila.sakila.sakila.film.FilmManager;
import com.company.sakila.sakila.sakila.film_actor.FilmActor;
import com.company.sakila.sakila.sakila.film_actor.FilmActorManager;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuples;
import com.speedment.enterprise.application.InMemoryBundle;
import com.speedment.enterprise.datastore.runtime.DataStoreComponent;
import com.speedment.runtime.core.ApplicationBuilder;
import com.speedment.runtime.core.Speedment;
import com.speedment.runtime.join.Join;
import com.speedment.runtime.join.JoinComponent;
import java.util.Map;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {

    public static void main(String[] args) {
        Speedment app = new SakilaApplicationBuilder()
                .withPassword("password")
                .withLogging(ApplicationBuilder.LogType.STREAM)
                //                .withBundle(InMemoryBundle.class)
                .build();
        
//        example1(app);
//        example2(app);
        example3(app);
    }

    private static void example1(Speedment app) {
        

        FilmManager films = app.getOrThrow(FilmManager.class);
        films.stream()
                .filter(
                        Film.LENGTH.greaterThan(60)
                //                                .or(Film.LENGTH.lessThan(30))
                )
                .sorted(Film.LENGTH.thenComparing(Film.TITLE.reversed()))
                .forEach(System.out::println);

//                app.getOrThrow(DataStoreComponent.class).load();
    }
    
    private static void example2(Speedment app) {
        JoinComponent joinComponent = app.getOrThrow(JoinComponent.class);
        
        Join<Tuple3<FilmActor, Film, Actor>> join = joinComponent
                .from(FilmActorManager.IDENTIFIER)
                .innerJoinOn(Film.FILM_ID).equal(FilmActor.FILM_ID)
                .innerJoinOn(Actor.ACTOR_ID).equal(FilmActor.ACTOR_ID)
                .build(Tuples::of);
        
        Map<Actor, Map<String, Long>> pivot = join.stream()
                .collect(
                        groupingBy(
                                Tuple3::get2,
                                groupingBy(
                                        tu -> tu.get1().getRating().get(), counting()
                                )
                        )
                );
        
        pivot.forEach((k, v) ->  {
            System.out.format("%22s  %5s %n", k.getFirstName() + " " + k.getLastName(), v);
        });
    }
    
    private static void example3(Speedment app) {
        JoinComponent joinComponent = app.getOrThrow(JoinComponent.class);
        
        Join<ActorRating> join = joinComponent
                .from(FilmActorManager.IDENTIFIER)
                .innerJoinOn(Film.FILM_ID).equal(FilmActor.FILM_ID)
                .innerJoinOn(Actor.ACTOR_ID).equal(FilmActor.ACTOR_ID)
                .build(ActorRating::new);
        
        Map<Actor, Map<String, Long>> pivot = join.stream()
                .collect(
                        groupingBy(
                                ActorRating::actor,
                                groupingBy(
                                        ActorRating::rating, counting()
                                )
                        )
                );
        
        pivot.forEach((k, v) ->  {
            System.out.format("%22s  %5s %n", k.getFirstName() + " " + k.getLastName(), v);
        });
    }
    
    private static class ActorRating {
        private final Actor actor;
        private final String rating;

        public ActorRating(FilmActor fa, Film film, Actor actor) {
            this.actor = actor;
            this.rating = film.getRating().get();
        }
        
        public Actor actor() {
            return actor;
        }
        
        public String rating() {
            return rating;
        }
    }
}
