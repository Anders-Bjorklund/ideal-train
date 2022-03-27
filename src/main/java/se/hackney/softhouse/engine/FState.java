package se.hackney.softhouse.engine;

import se.hackney.softhouse.target.Family;
import se.hackney.softhouse.target.Person;

public class FState implements IState {

    // F kan följas av T och A, ytterligare F ( om inte, returnera )

    @Override
    public IState next(String line) {
        String firstCharacter = line.substring( 0, 1 );
        
        return switch ( firstCharacter ) {
            case "T" -> States.tState;
            case "A" -> States.aState;
            case "F" -> States.fState;

            // Could be followed by next Person as well.
            case "P" -> States.pState;

            default -> throw new AssertionError();
        };
    }

    @Override
    public void invoke( Engine engine, String line ) {
        System.out.println("FState invoked");
        
        Person person = engine.getLatestPerson();
        Values details = new Values( line );

        Family family = new Family();
        family.setName( details.index( 0 ) );
        family.setBorn( details.index( 1 ) );

        person.getFamilies().add( family );


    }
    
}
