package se.hackney.softhouse;


import io.micronaut.runtime.Micronaut;
import se.hackney.softhouse.engine.Engine;
import se.hackney.softhouse.target.People;
import se.hackney.softhouse.visitors.SortOfXmlVisitor;

public class Application {

    public static void main(String[] args) {

        if( args != null && args.length > 0 ) {
            // Manual execution
            Engine engine = new Engine();
            engine.extract( args[0] );

            // for( Person person : engine.getPeople().getPersons() ) {
            //    System.out.println("Name: " + person.getFirstname() + " " + person.getLastname());
            // }

            // System.out.println("\n\n");

            People people = engine.getPeople();
            SortOfXmlVisitor xmlVisitor = new SortOfXmlVisitor();
            people.accept(xmlVisitor);

            xmlVisitor.getOutput().stream().forEach( System.out::println );

            
        } else {
            // Online execution ( or user error )
            Micronaut.run(Application.class, args);
        }
        
    }
}
