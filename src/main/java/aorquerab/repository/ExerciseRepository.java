package aorquerab.repository;

import aorquerab.model.Exercise;
import aorquerab.model.enums.TypeCardio;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ExerciseRepository extends ListCrudRepository<Exercise,Integer> {

    List<Exercise> findAllByTypeCardio (TypeCardio typeCardio);
}
