package se.hackney.softhouse.engine;

import java.util.List;

import se.hackney.softhouse.target.Family;
import se.hackney.softhouse.target.Person;
import se.hackney.softhouse.target.Phone;

public class TState implements IState {

    @Override
    public IState next( String line ) {
        
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
        System.out.println("TState invoked");
        

        Person person = engine.getLatestPerson();
        Values numbers = new Values( line );

        Phone phone = new Phone();
        phone.setMobile( numbers.index( 0 ) );
        phone.setLandline( numbers.index( 1 ) );

        List< Family > families = person.getFamilies();

        // Implicit växel. Om ingen familjemedlem tillagd än -> telefon och adress lagras i Person. Annars i senaste Familj. Se felformaterad XML kring familj och multipler av dessa. 
        if( families.isEmpty() ) {
            person.getPhones().add( phone) ;
        } else {
            Family lastFamilyMember = families.get( families.size() - 1 );
            lastFamilyMember.getPhones().add(phone);
        }
        
    }
    
}