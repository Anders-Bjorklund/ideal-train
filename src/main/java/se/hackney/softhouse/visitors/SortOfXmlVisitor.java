package se.hackney.softhouse.visitors;

import java.util.ArrayList;
import java.util.List;

import se.hackney.softhouse.engine.Utils;
import se.hackney.softhouse.target.Address;
import se.hackney.softhouse.target.Family;
import se.hackney.softhouse.target.People;
import se.hackney.softhouse.target.Person;
import se.hackney.softhouse.target.Phone;

public class SortOfXmlVisitor implements IVisit {

    private List< String > output = new ArrayList<>();
    private boolean isInFamily = false;

    public List< String > getOutput() {
        return output;
    }

    @Override
    public void visit( People people ) {
        output.add( "<people>");

        for( Person person : people.getPersons() ) {
            person.accept( this );
        }

        output.add( "</people>" );
    }

    @Override
    public void visit(Person person) {
        output.add( "  <person>" );
        if ( Utils.hasContent( person.getFirstname() ) ) output.add( "    <firstname>" + person.getFirstname() + "</firstname>" );
        if ( Utils.hasContent( person.getLastname() ) )  output.add( "    <lastname>" + person.getLastname() + "</lastname>" );

        for( Address address : person.getAddresses() ) {
            address.accept( this );
        }

        for( Phone phone : person.getPhones() ) {
            phone.accept( this );
        }

        for( Family family : person.getFamilies() ) {
            family.accept(this);
        }
 
        output.add( "  </person>" );
    }

    @Override
    public void visit(Phone phone) {

        String spacer = "    "; // 4 spaces outside family for pretty printing.

        if( isInFamily ) {
            spacer = "      "; // 6 spaces in family for pretty printing.
        }

        output.add( spacer + "<phone>" );

        if ( Utils.hasContent( phone.getMobile() ) )   output.add( spacer + "  <mobile>" + phone.getMobile() + "</mobile>" );
        if ( Utils.hasContent( phone.getLandline() ) ) output.add( spacer + "  <landline>" + phone.getLandline() + "</landline>" );
        output.add( spacer + "</phone>" );

    }

    @Override
    public void visit(Address address) {

        String spacer = "    "; // 4 spaces outside family for pretty printing.

        if( isInFamily ) {
            spacer = "      "; // 6 spaces in family for pretty printing.
        }

        output.add( spacer + "<address>" );

        if ( Utils.hasContent( address.getStreet() ) ) output.add( spacer + "  <street>" + address.getStreet() + "</street>" );
        if ( Utils.hasContent( address.getCity() ) )   output.add( spacer + "  <city>" + address.getCity() + "</city>" );
        if ( Utils.hasContent( address.getZip() ) )    output.add( spacer + "  <zip>" + address.getZip() + "</zip>" );

        output.add( spacer + "</address>" );

    }

    @Override
    public void visit(Family family) {
        this.isInFamily = true;

        output.add( "    <family>" );
        
        if ( Utils.hasContent( family.getName() ) )  output.add( "      <name>" + family.getName() + "</name>");
        if ( Utils.hasContent( family.getBorn() ) )  output.add( "      <born>" + family.getBorn() + "</born>" );

        for( Address address : family.getAddresses() ) {
            address.accept( this );
        }

        for( Phone phone : family.getPhones() ) {
            phone.accept( this );
        }

        output.add( "    </family>" );

        this.isInFamily = false;

    }

}