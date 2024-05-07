package aorquerab.controller;

import aorquerab.model.Exercise;
import aorquerab.repository.ExerciseRepositoryOld;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/exercises")
@Slf4j
public class ExerciseController {

    @GetMapping("/get")
    public ResponseEntity<String> getController () {
        log.info("Get endpoint executed correctly");
        String body = "I am a body lol";
        return new ResponseEntity<> (body, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> postController(@Valid @RequestBody String body) {
        log.info("Get endpoint executed correctly");
        return new ResponseEntity<> (body, HttpStatus.OK);
    }

    //FIRST VERSION USING MY OWN METHODS IN REPOSITORYOLD CLASS

//    private final ExerciseRepositoryOld exerciseRepositoryOld;
//
//    public ExerciseController (ExerciseRepositoryOld exerciseRepositoryOld){
//        this.exerciseRepositoryOld = exerciseRepositoryOld;
//    }

//    @GetMapping("")
//    public List<Exercise> getExercises(){
//        return exerciseRepositoryOld.getExercises();
//    }
//
//    @GetMapping("/{id}")
//    public Exercise getExerciseById(@PathVariable Integer id){
//        Optional<Exercise> exercise = exerciseRepositoryOld.getExerciseById(id);
//        if(exercise.isEmpty()) {
//            log.info("Exercise {} not found in database",id.toString());
//            throw new ExerciseNotFoundException(HttpStatus.NOT_FOUND,"Exercise not found in DB");
//        }
//        return exercise.get();
//    }
//
//    @PostMapping("/addExercise")
//    public ResponseEntity<Exercise> addExercise (@Valid @RequestBody Exercise exercise) {
//        log.info("Exercise adding attempt");
//        exerciseRepositoryOld.addExercise(exercise);
//        return new ResponseEntity<> (HttpStatus.CREATED);
//        // ResponseEntity.status(HttpStatus.CREATED)
//    }
//
//    //PUT
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PutMapping("/updateExercise/{id}")
//    public void updateExercise (
//            @PathVariable Integer id,
//            @Valid @RequestBody Exercise exercise) {
//        log.info("Exercise update attempt");
//        exerciseRepositoryOld.updateExercise(exercise, id);
//    }
//
//    //DELETE
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("/deleteExercise/{id}")
//    public void deleteExercise (@PathVariable Integer id) {
//        log.info("Exercise delete attempt");
//        exerciseRepositoryOld.deleteExercise(id);
//    }

    //SECOND VERSION USING JDBC CLIENT (NOT OLDER JDBC API)
//    @GetMapping("")
//    public List<Exercise> getExercises(){
//        return exerciseRepositoryOld.getExercisesJDBC();
//    }



    //TODO: 2h10 - using... POSTGRESQL and Docker
}
