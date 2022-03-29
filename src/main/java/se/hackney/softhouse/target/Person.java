package se.hackney.softhouse.target;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import se.hackney.softhouse.visitors.IVisit;

@Setter
@Getter
public class Person implements Node {

    private String firstname;
    private String lastname;

    private List< Phone > phones = new ArrayList<>();
    private List< Address > addresses = new ArrayList<>();
    private List< Family > families = new ArrayList<>();

    @Override
    public void accept( IVisit visitor ) {
        visitor.visit(this);
    }

}