package aorquerab.repository;

import aorquerab.model.Exercise;
import aorquerab.model.enums.TypeCardio;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * REPOSITORY USING METHODS CREATED FROM SCRATCH AND A SMALL VERSION OF
 * REPOSITORY BUT USING JBDC CLIENT
 * */
@Repository
public class ExerciseRepositoryOld {

    //FIRST VERSION USING MY OWN METHODS IN THIS REPOSITORY
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
    public void updateExercise(Exercise exercise, Integer id) {
        Optional<Exercise> existingExercise = getExerciseById(id);
        existingExercise.ifPresent(value -> exercises.set(exercises.indexOf(value), exercise));
        /*Optional<Exercise> existingExercise = getExerciseById(id);
        if (existingExercise.isPresent()){
            exercises.set(exercises.indexOf(existingExercise.get()),exercise);}*/
    }

    //DELETE
    public void deleteExercise(Integer id) {
        exercises.removeIf(exercise -> exercise.getId().equals(id));
    }

    //"Initialization" inside this class
    @PostConstruct
    private void init () {
        exercises.add(new Exercise(1,"Pullups",5,5, LocalDateTime.now(), TypeCardio.BIKE,1));
        exercises.add(new Exercise(2,"Dips",5,5, LocalDateTime.now(), TypeCardio.STEP,1));
    }

    //SECOND VERSION USING JDBC CLIENT
    private final JdbcClient jdbcClient;

    public ExerciseRepositoryOld(JdbcClient jdbcClient) {
        this.jdbcClient= jdbcClient;
    }

    public List<Exercise> getExercisesJDBC() {
        return jdbcClient.sql("select * from exercise")
                .query(Exercise.class)
                .list();
    }

    public void deleteExerciseJDBC (Integer id) {
        var updated = jdbcClient.sql("delete from exercise where id = :id")
                .param("id",id)
                .update();
    }
}
