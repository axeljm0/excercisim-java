class Greeter {

    String getGreeting() {
        return "Hello, World!";
    }

    // main para probar localmente
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        System.out.println(greeter.getGreeting());
    }
}