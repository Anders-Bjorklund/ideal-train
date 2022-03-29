package se.hackney.softhouse.engine;

import java.util.List;
import java.util.stream.Stream;

import se.hackney.softhouse.target.People;
import se.hackney.softhouse.target.Person;

public class Engine {

    private IState state = new InitialState();
    private int index;

    private People people = new People();

    public List< Person > extract( String path ) {

        
        index = 1;

        Stream< String > lines = Utils.lines(path);

        lines.forEach( ( a ) -> {
            // System.out.println( (index++) + ". " +  a );
            state = state.next( a );
            state.invoke( this, a );
        } );

        return null;
        
    }

    public People getPeople() {
        return people;
    }

    public Person getLatestPerson() {

        List< Person > persons = people.getPersons();

        if( persons.isEmpty() ) {
            return null;
        } else {
            return persons.get( persons.size() - 1 );
        }
    }

}