package model;

public class Radiator {
    private RadiatorState currentState;
    public Radiator() {
        currentState = new Offstate();
    }
    public void turnUp()
    {
        currentState = new Power1State();
    }
    public void turnDown()
    {
        currentState = new Offstate();
    }
    public int getPower()
    {
        return currentState.getPower();
    }
    public void setPowerState(RadiatorState state)
    {
        this.currentState = state;
    }
}
