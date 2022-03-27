package se.hackney.softhouse.engine;

import se.hackney.softhouse.target.Person;


public class PState implements IState {

    // P kan följas av T, A och F ( om inte, returnera )

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

        System.out.println("PState invoked");
        Person person = new Person();

        engine.getPeople().getPersons().add( person );

        Values values = new Values( line );

        person.setFirstname( values.index( 0 ) );
        person.setLastname( values.index( 1 ) );

    }

}