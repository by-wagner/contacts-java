import java.util.Scanner;

/* Product - Clock */
interface Clock {
    void tick();
}

/* Concrete Product - Sand Clock */
class SandClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...sand noise...");
    }
}

/* Concrete Product - Digital Clock */
class DigitalClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...pim...");
    }
}

/* Concrete Product - Mechanical Clock */
class MechanicalClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...clang mechanism...");
    }
}

class ClockFactory {

    /* It produces concrete clocks corresponding to their types: Digital, Sand or Mechanical */
    public Clock produce(String type) {
        switch (type) {
            case "Sand":
                return new SandClock();
            case "Digital":
                return new DigitalClock();
            case "Mechanical":
                return new MechanicalClock();
            default:
                return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String type = scanner.next();
        final ClockFactory clockFactory = new ClockFactory();
        final Clock clock = clockFactory.produce(type);
        if (clock != null) {
            clock.tick();
        } else {
            System.out.println("Invalid clock type");
        }
        scanner.close();
    }
}