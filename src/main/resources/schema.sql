CREATE TABLE IF NOT EXISTS Exercise (
    id INT NOT NULL,
    name VARCHAR (250) NOT NULL,
    repetition INT NOT NULL,
    serie INT NOT NULL,
    started_on TIMESTAMP NOT NULL,
    type_cardio VARCHAR (10) NOT NULL,
    PRIMARY KEY (id)
);
