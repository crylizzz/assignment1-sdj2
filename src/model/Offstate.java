package model;

public class Offstate implements RadiatorState {
    private static final int POWER = 0;
    @Override public void turnUp(Radiator radiator)
    {
        radiator.setPowerState(new Power1State());
    }
    @Override public void turnDown(Radiator radiator)
    {
        //nothing
    }
    @Override public int getPower()
    {
        return POWER;
    }
}
