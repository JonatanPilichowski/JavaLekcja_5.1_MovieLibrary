package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Person {
    private String firstName;
    private String lastName;

    public Person() {
    }
}
