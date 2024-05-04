package aorquerab.repository;


import aorquerab.model.Exercise;
import aorquerab.model.enums.TypeCardio;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ExerciseRepository {

    private static final List<Exercise> exercises = new ArrayList<>();

    //GET
    public List<Exercise> getExercises() {
        return exercises;
    }

    //GET
    public Optional<Exercise> getExerciseById(Integer id) {
        return exercises.stream()
                .filter(exercise -> exercise.getId().equals(id))
                .findFirst();
    }

    //POST
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    //UPDATE

    //DELETE

    //"Initialization" inside this class
    @PostConstruct
    private void init () {
        exercises.add(new Exercise(1,"Pullups",5,5, LocalDateTime.now(), TypeCardio.BIKE));
        exercises.add(new Exercise(2,"Dips",5,5, LocalDateTime.now(), TypeCardio.STEP));
    }
}
