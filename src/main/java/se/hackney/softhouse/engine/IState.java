package se.hackney.softhouse.engine;

public interface IState {

    public IState next( String line );

    public void invoke( Engine engine, String line );

}