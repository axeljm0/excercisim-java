import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface RemoteControlCar {
    void drive();
    int getDistanceTravelled();
}

class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    private int distanceTravelled;
    private int numberOfVictories;

    public void drive() {
        distanceTravelled += 10;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    public int compareTo(ProductionRemoteControlCar other) {
        return Integer.compare(other.numberOfVictories, this.numberOfVictories);
    }
}

class ExperimentalRemoteControlCar implements RemoteControlCar {

    private int distanceTravelled;

    public void drive() {
        distanceTravelled += 20;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }
}

class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        List<ProductionRemoteControlCar> sorted = new ArrayList<>(cars);
        Collections.sort(sorted);
        return sorted;
    }
}

class Main {
    public static void main(String[] args) {
        ProductionRemoteControlCar prod = new ProductionRemoteControlCar();
        prod.drive();
        System.out.println(prod.getDistanceTravelled());

        ExperimentalRemoteControlCar exp = new ExperimentalRemoteControlCar();
        exp.drive();
        System.out.println(exp.getDistanceTravelled());

        TestTrack.race(new ProductionRemoteControlCar());
        TestTrack.race(new ExperimentalRemoteControlCar());

        ProductionRemoteControlCar prc1 = new ProductionRemoteControlCar();
        ProductionRemoteControlCar prc2 = new ProductionRemoteControlCar();
        prc1.setNumberOfVictories(2);
        prc2.setNumberOfVictories(3);

        List<ProductionRemoteControlCar> unsortedCars = new ArrayList<>();
        unsortedCars.add(prc1);
        unsortedCars.add(prc2);

        List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(unsortedCars);
        System.out.println(rankings.get(0).getNumberOfVictories());
        System.out.println(rankings.get(1).getNumberOfVictories());
    }
}