package se.hackney.softhouse.visitors;

import se.hackney.softhouse.target.Address;
import se.hackney.softhouse.target.Family;
import se.hackney.softhouse.target.People;
import se.hackney.softhouse.target.Person;
import se.hackney.softhouse.target.Phone;

public interface IVisit {

    public void visit( People people );

    public void visit( Person person );

    public void visit( Phone phone );

    public void visit( Address address );

    public void visit( Family family );
}