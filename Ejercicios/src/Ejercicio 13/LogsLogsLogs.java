class Secrets {

    public static int shiftBack(int value, int places) {
        return value >>> places;
    }

    public static int setBits(int value, int mask) {
        return value | mask;
    }

    public static int flipBits(int value, int mask) {
        return value ^ mask;
    }

    public static int clearBits(int value, int mask) {
        return value & ~mask;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(shiftBack(0b1001, 2)));
        System.out.println(Integer.toBinaryString(setBits(0b0110, 0b0101)));
        System.out.println(Integer.toBinaryString(flipBits(0b1100, 0b0101)));
        System.out.println(Integer.toBinaryString(clearBits(0b0110, 0b0101)));
    }
}