import model.Power2State;
import model.Radiator;

public class Main {
    public static void main(String[] args) {
        Radiator radiator1 = new Radiator();
        radiator1.setPowerState(new Power2State());
        radiator1.getPower();
    }
}
