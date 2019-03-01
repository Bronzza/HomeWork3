package garrage;

public class CarDoor {
    private boolean isDoorOpen;
    private boolean isWindowOpen;

    public CarDoor(boolean isDoorOpen, boolean isWindowOpen) {
        this.isDoorOpen = isDoorOpen;
        this.isWindowOpen = isWindowOpen;
    }

    public CarDoor() {
    }

    public void openTheDoor() {
        System.out.println("You've opened the door");
        isDoorOpen = true;
    }

    public void closeTheDoor() {
        System.out.println("You've closed the door");
        isDoorOpen = false;
    }

    public boolean changeDoorStatus() {
        if (isDoorOpen) {
            System.out.println("You've closed the door");
            return isDoorOpen = false;
        } else {
            System.out.println("You've opened the door");
            return isDoorOpen = true;
        }
    }

    public void openTheWindow() {
        System.out.println("You've opened the window");
        isDoorOpen = true;
    }

    public void closeTheWindow() {
        System.out.println("You've closed the window");
        isDoorOpen = false;
    }

    public boolean changeWindowStatus() {
        if (isWindowOpen) {
            System.out.println("You've closed the window");
            return isWindowOpen = false;

        } else {
            System.out.println("You've opened the window");
            return isWindowOpen = true;
        }
    }

    @Override
    public String toString() {
        return "This is garrage.CarDoor{" +
                "Door is open=" + isDoorOpen +
                ", Window is open=" + isWindowOpen +
                '}';
    }
}
