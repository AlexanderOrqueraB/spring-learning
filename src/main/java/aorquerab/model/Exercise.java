package aorquerab.model;

import aorquerab.model.enums.TypeCardio;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Exercise {

    private Integer id;
    private String name;
    private Integer repetition;
    private Integer serie;
    private LocalDateTime startedOn;
    private TypeCardio typeCardio;
}
