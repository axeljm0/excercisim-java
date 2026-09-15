class JedliksToyCar {

    private int distance = 0;
    private int battery = 100;

    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + distance + " meters";
    }

    public String batteryDisplay() {
        if (battery == 0) {
            return "Battery empty";
        }
        return "Battery at " + battery + "%";
    }

    public void drive() {
        if (battery > 0) {
            distance += 20;
            battery -= 1;
        }
    }

    public static void main(String[] args) {
        JedliksToyCar car = JedliksToyCar.buy();

        System.out.println(car.distanceDisplay());
        System.out.println(car.batteryDisplay());

        car.drive();
        car.drive();
        System.out.println(car.distanceDisplay());
        System.out.println(car.batteryDisplay());

        for (int i = 0; i < 100; i++) {
            car.drive();
        }
        System.out.println(car.distanceDisplay());
        System.out.println(car.batteryDisplay());

        car.drive();
        System.out.println(car.distanceDisplay());
        System.out.println(car.batteryDisplay());
    }
}