package model;

public interface RadiatorState {
    public abstract void turnUp(Radiator radiator);
    public abstract void turnDown(Radiator radiator);
    public int getPower();
}
