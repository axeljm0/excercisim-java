class AnnalynsInfiltration {

    public static boolean canFastAttack(boolean knightIsAwake) {
        return !knightIsAwake;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        return knightIsAwake || archerIsAwake || prisonerIsAwake;
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        return prisonerIsAwake && !archerIsAwake;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake,
                                          boolean archerIsAwake,
                                          boolean prisonerIsAwake,
                                          boolean petDogIsPresent) {
        return (petDogIsPresent && !archerIsAwake)
                || (!petDogIsPresent && prisonerIsAwake && !knightIsAwake && !archerIsAwake);
    }

    public static void main(String[] args) {
        System.out.println(canFastAttack(true));
        System.out.println(canFastAttack(false));

        System.out.println(canSpy(false, false, false));
        System.out.println(canSpy(false, true, false));

        System.out.println(canSignalPrisoner(true, true));
        System.out.println(canSignalPrisoner(false, true));

        System.out.println(canFreePrisoner(false, false, false, true));
        System.out.println(canFreePrisoner(false, true, false, true));
        System.out.println(canFreePrisoner(false, false, true, false));
        System.out.println(canFreePrisoner(true, false, true, false));
        System.out.println(canFreePrisoner(false, false, false, false));
    }
}