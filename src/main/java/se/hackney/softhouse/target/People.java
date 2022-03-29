package se.hackney.softhouse.target;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import se.hackney.softhouse.visitors.IVisit;

@Setter
@Getter
public class People implements Node {

    private List< Person > persons = new ArrayList<>();
    
    @Override
    public void accept( IVisit visitor ) {
        visitor.visit( this );
    }

}