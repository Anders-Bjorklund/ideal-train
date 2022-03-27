package se.hackney.softhouse.engine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Utils {

    public static Stream< String > lines( String path ) {

        try {
            Stream< String > lines = Files.lines( Paths.get( path ) );
            return lines;
        } catch( IOException e ) {
            throw new RuntimeException( "CheckYourPathException" );
        }

    }


    public static boolean hasContent( String input ) {

        if( input != null && !input.isBlank() ) {
            return true;
        } else {
            return false;
        }

    }

}