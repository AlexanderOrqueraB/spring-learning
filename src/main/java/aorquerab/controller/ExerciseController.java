package aorquerab.controller;

import aorquerab.model.Exercise;
import aorquerab.repository.ExerciseRepository;
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
    public ResponseEntity<String> postController(@RequestBody String body) {
        log.info("Get endpoint executed correctly");
        return new ResponseEntity<> (body, HttpStatus.OK);
    }

    private final ExerciseRepository exerciseRepository;

    public ExerciseController (ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping("")
    public List<Exercise> findAll (){
        return ExerciseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Exercise findById (@PathVariable Integer id){
        return exerciseRepository.findById(id);
    }

    //TODO: 1H07MIN


}
