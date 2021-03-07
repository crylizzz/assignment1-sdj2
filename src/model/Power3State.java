package model;

public class Power3State implements RadiatorState{
    private static final int POWER = 1;
    public Power3State(Radiator radiator) {
        try {
            Thread t1 = new Thread();
            t1.sleep(1000);
            radiator.setPowerState(new Power2State());
        } catch (InterruptedException e) {
            //
        }
    }

    @Override public void turnUp(Radiator radiator) {
        //nothing
    }
    @Override public void turnDown(Radiator radiator) {
        //nothing
    }
    @Override public int getPower() {
        return POWER;
    }
}
