package se.hackney.softhouse.target;

import lombok.Getter;
import lombok.Setter;
import se.hackney.softhouse.visitors.IVisit;

@Getter
@Setter
public class Address implements Node {

    private String street;
    private String city;
    private String zip;

    @Override
    public void accept( IVisit visitor ) {
        visitor.visit(this);
    }
    
}