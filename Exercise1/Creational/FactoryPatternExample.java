// Factory Pattern: Vehicle Factory Example

// Product Interface
interface Vehicle {
    void create();
}

// Concrete Products
class Car implements Vehicle {
    @Override
    public void create() {
        System.out.println("Car created.");
    }
}

class Truck implements Vehicle {
    @Override
    public void create() {
        System.out.println("Truck created.");
    }
}

// Factory Class
class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type.equalsIgnoreCase("Car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("Truck")) {
            return new Truck();
        }
        throw new IllegalArgumentException("Unknown vehicle type.");
    }
}

// Main Class
public class FactoryPatternExample {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getVehicle("Car");
        car.create();

        Vehicle truck = VehicleFactory.getVehicle("Truck");
        truck.create();
    }
}
