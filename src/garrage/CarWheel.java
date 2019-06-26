package garrage;

public class CarWheel {
    private float tireState = 1;

    public CarWheel() {
    }

    public CarWheel(float tireState) {
        if ((tireState < 0) || (tireState > 100)) {
            System.out.println("Input number between 0 and 100");
        } else {
            this.tireState = tireState / 100;
        }
    }

    public void setNewTire() {
        tireState = 1;
        System.out.println("New tire has been installed");
    }

    public void changeTireState(int percent) {
        if (percent > 100) {
            percent = 100;
        } else if (percent < 0) {
            System.out.println("Input number between 0 and 100");
            return;
        }
        tireState -= tireState * percent / 100;
        System.out.println("Tire stait is: " + tireState);
    }

    public float getTireState() {
        return tireState;
    }

    @Override
    public String toString() {
        return "This is garrage.CarWheel{" +
                "Tire durability is=" + tireState + "%" +
                '}';
    }
}
