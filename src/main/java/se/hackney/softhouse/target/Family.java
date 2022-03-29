package se.hackney.softhouse.target;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import se.hackney.softhouse.visitors.IVisit;

@Setter
@Getter
public class Family implements Node {

    private String name;
    private String born;

    private List< Phone > phones = new ArrayList<>();
    private List < Address > addresses = new ArrayList<>();

    @Override
    public void accept( IVisit visitor ) {
        visitor.visit(this);
    }
    
}