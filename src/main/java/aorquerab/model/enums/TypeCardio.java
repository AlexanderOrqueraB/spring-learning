package aorquerab.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TypeCardio {
    RUN("Run"),
    STEP("Steps"),
    BIKE("Bike");

    private final String value;

    @JsonValue
    public String getValue () {
        return value;
    }
}
