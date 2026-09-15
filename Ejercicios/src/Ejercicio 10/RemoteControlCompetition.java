class NeedForSpeed {

    private final int speed;
    private final int batteryDrain;
    private int distanceDriven;
    private int battery = 100;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }

    void drive() {
        if (!batteryDrained()) {
            distanceDriven += speed;
            battery -= batteryDrain;
        }
    }

    int distanceDriven() {
        return distanceDriven;
    }

    boolean batteryDrained() {
        return battery < batteryDrain;
    }
}

class RaceTrack {

    private final int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    boolean canFinishRace(NeedForSpeed car) {
        while (!car.batteryDrained()) {
            car.drive();
        }
        return car.distanceDriven() >= distance;
    }
}

class Main {
    public static void main(String[] args) {
        NeedForSpeed car = new NeedForSpeed(5, 2);
        car.drive();
        System.out.println(car.distanceDriven());
        System.out.println(car.batteryDrained());

        NeedForSpeed nitro = NeedForSpeed.nitro();
        nitro.drive();
        System.out.println(nitro.distanceDriven());

        RaceTrack race1 = new RaceTrack(100);
        RaceTrack race2 = new RaceTrack(300);
        System.out.println(race1.canFinishRace(new NeedForSpeed(5, 2)));
        System.out.println(race2.canFinishRace(new NeedForSpeed(5, 2)));
    }
}