package models;

import lombok.Getter;

@Getter
public class Actor extends Person{

    public Actor(){
        super();
    };

    public Actor(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
