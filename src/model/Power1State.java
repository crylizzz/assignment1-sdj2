package model;

public class Power1State implements RadiatorState{
    private static final int POWER = 1;

    @Override public void turnUp(Radiator radiator) {
        radiator.setPowerState(new Power2State());
    }
    @Override public void turnDown(Radiator radiator) {
        radiator.setPowerState(new Offstate());
    }
    @Override public int getPower() {
        return POWER;
    }
}
