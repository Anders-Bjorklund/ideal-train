package se.hackney.softhouse.engine;

public class States {

    public static final IState pState = new PState();
    public static final IState tState = new TState();
    public static final IState aState = new AState();
    public static final IState fState = new FState();

}