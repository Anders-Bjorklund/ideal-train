package se.hackney.softhouse.engine;

public class Values {

    private String[] values;

    public Values( String input ) {
        String temp[] = input.split( "\\|");

        if( temp.length > 1 ) {
            values = new String[ temp.length - 1 ];

            for( int index = 1; index < temp.length; index++ ) {
                values[ index - 1 ] = temp[ index ];
            }

        } else {
            values = new String[0];
        }

    }


    /* Index always returns something, even if it is just the empty string. */
    public String index( int index ) {

        if( index >= values.length ) {
            return "";
        }

        return values[ index ];
    }

 }