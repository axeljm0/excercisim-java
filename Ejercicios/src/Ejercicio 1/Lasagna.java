public class Lasagna {
    public int expectedMinutesInOven() {
        return 40;
    }

    public int remainingMinutesInOven(int actualMinutesInOven) {
        return expectedMinutesInOven() - actualMinutesInOven;
    }

    public int preparationTimeInMinutes(int numberOfLayers) {
        return numberOfLayers * 2;
    }

    public int totalTimeInMinutes(int numberOfLayers, int actualMinutesInOven) {
        return preparationTimeInMinutes(numberOfLayers) + actualMinutesInOven;
    }

    public static void main(String[] args) {
        Lasagna lasagna = new Lasagna();

        System.out.println("Tiempo esperado: " + lasagna.expectedMinutesInOven());
        System.out.println("Tiempo restante: " + lasagna.remainingMinutesInOven(30));
        System.out.println("Tiempo de preparación: " + lasagna.preparationTimeInMinutes(2));
        System.out.println("Tiempo total: " + lasagna.totalTimeInMinutes(3, 20));
    }
}