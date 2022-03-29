package se.hackney.softhouse.target;

import lombok.Getter;
import lombok.Setter;
import se.hackney.softhouse.visitors.IVisit;

@Setter
@Getter
public class Phone implements Node {

    private String mobile;
    private String landline;

    @Override
    public void accept( IVisit visitor ) {
        visitor.visit(this);
    }
    
}