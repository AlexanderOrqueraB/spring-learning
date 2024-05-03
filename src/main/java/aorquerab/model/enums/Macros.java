package aorquerab.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Macros {
    PROTEIN("Protein"),
    CARBO("Carbohydrates"),
    FAT("Fat");

    private final String value;

    @JsonValue
    public String getValue () {
        return value;
    }
}
