package se.hackney.softhouse.target;

import se.hackney.softhouse.visitors.IVisit;

public interface Node {

    public void accept( IVisit visitor );
    
}