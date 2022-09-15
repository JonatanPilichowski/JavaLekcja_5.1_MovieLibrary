package models;

import lombok.Getter;

@Getter
public class Director extends Person{
    public Director(){
        super();
    }
    public Director(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
