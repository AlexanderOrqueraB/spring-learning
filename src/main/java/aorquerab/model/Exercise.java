package aorquerab.model;

import aorquerab.model.enums.TypeCardio;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Exercise {
    @Id //If using ExerciseRepository extends ListCrudRepository
    private Integer id;
    @NotEmpty (message = "Name must not be null and size must be greater than zero!")
    private String name;
    @Positive (message = "Number of repetition must not be negative")
    private Integer repetition;
    @Positive (message = "Number of series must not be negative")
    private Integer serie;
    private LocalDateTime startedOn;
    private TypeCardio typeCardio;
    //If using ExerciseRepository extends ListCrudRepository (if using JDBC)
    @Version
    private Integer version;
}
