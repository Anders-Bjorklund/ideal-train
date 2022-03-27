package se.hackney.softhouse.engine;

public class InitialState implements IState {

    // Kan bara följas av P eller inget ( om inte, kasta undantag )

    @Override
    public IState next( String line ) {

        String firstCharacter = line.substring( 0, 1 );
        
        return switch ( firstCharacter ) {
            case "P" -> States.pState;

            default -> throw new AssertionError();
        };

    }

    @Override
    public void invoke( Engine engine, String line ) {
        throw new UnsupportedOperationException("Not supported yet and never will be.");
    }

    
}