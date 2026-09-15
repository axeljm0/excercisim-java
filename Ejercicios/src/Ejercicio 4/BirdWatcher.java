class BirdWatcher {

    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay;
    }

    public static int[] getLastWeek() {
        return new int[] { 0, 2, 5, 3, 7, 8, 4 };
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int count : birdsPerDay) {
            if (count == 0) {
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int total = 0;
        int limit = Math.min(numberOfDays, birdsPerDay.length);
        for (int i = 0; i < limit; i++) {
            total += birdsPerDay[i];
        }
        return total;
    }

    public int getBusyDays() {
        int busy = 0;
        for (int count : birdsPerDay) {
            if (count >= 5) {
                busy++;
            }
        }
        return busy;
    }

    public static void main(String[] args) {
        int[] birdsPerDay = { 2, 5, 0, 7, 4, 1 };
        BirdWatcher birdCount = new BirdWatcher(birdsPerDay);

        int[] lastWeek = BirdWatcher.getLastWeek();
        System.out.print("getLastWeek: ");
        for (int count : lastWeek) {
            System.out.print(count + " ");
        }
        System.out.println();

        System.out.println("getToday: " + birdCount.getToday());

        birdCount.incrementTodaysCount();
        System.out.println("getToday tras incrementar: " + birdCount.getToday());

        System.out.println("hasDayWithoutBirds: " + birdCount.hasDayWithoutBirds());
        System.out.println("getCountForFirstDays(4): " + birdCount.getCountForFirstDays(4));
        System.out.println("getBusyDays: " + birdCount.getBusyDays());
    }
}