 interface Run {
    void printName();
    int getSpeed();
    double getWeight();
    int getPassengerCount();
    int getLandingGearsCount();
}
 abstract class Transport implements Run {
    protected static final int MAX_SPEED = 1000;
    protected static final int MIN_SPEED = 0;
    protected static final int MIN_PASSENGERS = 0;
    protected static final int MAX_PASSENGERS = 500;

    protected String name;
    protected int currentSpeed;

    public Transport(String name, int speed) {
        this.name = name;
        this.currentSpeed = Math.max(MIN_SPEED, Math.min(speed, MAX_SPEED));
    }

    @Override
    public void printName() {
        System.out.println("Назва транспортного засобу: " + name);
    }
}
// cуперклас "Літак"
abstract class Plane extends Transport {
    protected double weight;
    protected int passengers;
    protected int landingGears;

    public Plane(String name, int speed, double weight, int passengers, int landingGears) {
        super(name, speed);
        this.weight = weight;
        this.passengers = passengers;
        this.landingGears = landingGears;
    }

    @Override
    public int getSpeed() { return currentSpeed; }
    @Override
    public double getWeight() { return weight; }
    @Override
    public int getPassengerCount() { return passengers; }
    @Override
    public int getLandingGearsCount() { return landingGears; }
}

// транспортний літак
class CargoPlane extends Plane {
    public CargoPlane(String name, int speed, double weight, int landingGears) {
        super(name, speed, weight, 2, landingGears);
    }
}

// пасажирський літак
class PassengerPlane extends Plane {
    public PassengerPlane(String name, int speed, double weight, int passengers, int landingGears) {
        super(name, speed, weight, passengers, landingGears);
    }
}
public class Lab_3 {
    public static void displayInfo(Run vehicle) {
        vehicle.printName();
        System.out.println("Швидкість: " + vehicle.getSpeed() + " км/год");
        System.out.println("Вага: " + vehicle.getWeight() + " кг");
        System.out.println("Пасажирів: " + vehicle.getPassengerCount());
        System.out.println("Кількість шасі: " + vehicle.getLandingGearsCount());
    }

    public static void main(String[] args) {
        CargoPlane cargo = new CargoPlane("Літак1", 800, 40000.0, 24);
        PassengerPlane airbus = new PassengerPlane("Мрія Пасажирський", 850, 640000.0, 1800, 32);

        displayInfo(cargo);
        System.out.println("---------------------------");
        displayInfo(airbus);
    }
}