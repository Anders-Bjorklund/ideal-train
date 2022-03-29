package se.hackney.softhouse.engine;

import java.util.List;

import se.hackney.softhouse.target.Address;
import se.hackney.softhouse.target.Family;
import se.hackney.softhouse.target.Person;

public class AState implements IState {
    
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
        
        Person person = engine.getLatestPerson();
        Values details = new Values( line );

        Address address = new Address();
        address.setStreet( details.index( 0 ) );
        address.setCity( details.index( 1 ) );
        address.setZip( details.index( 2 ) );

        List< Family > families = person.getFamilies();

        // Implicit växel. Om ingen familjemedlem tillagd än -> telefon och adress lagras i Person. Annars i senaste Familj. Se felformaterad XML kring familj och multipler av dessa. 
        if( families.isEmpty() ) {
            person.getAddresses().add( address );
        } else {
            Family lastFamilyMember = families.get( families.size() - 1);
            lastFamilyMember.getAddresses().add( address );
        }
            

    }
    
}