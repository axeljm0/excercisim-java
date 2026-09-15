class IllegalOperationException extends Exception {
    public IllegalOperationException(String message) {
        super(message);
    }

    public IllegalOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class CalculatorConundrum {

    public String calculate(int operand1, int operand2, String operation) throws IllegalOperationException {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }

        int result;
        switch (operation) {
            case "+":
                result = operand1 + operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                try {
                    result = operand1 / operand2;
                } catch (ArithmeticException e) {
                    throw new IllegalOperationException("Division by zero is not allowed", e);
                }
                break;
            default:
                throw new IllegalOperationException("Operation '" + operation + "' does not exist");
        }

        return operand1 + " " + operation + " " + operand2 + " = " + result;
    }

    public static void main(String[] args) {
        CalculatorConundrum calculator = new CalculatorConundrum();

        try {
            System.out.println(calculator.calculate(16, 51, "+"));
            System.out.println(calculator.calculate(32, 6, "*"));
            System.out.println(calculator.calculate(512, 4, "/"));
        } catch (IllegalOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            calculator.calculate(10, 1, null);
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        try {
            calculator.calculate(10, 1, "");
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        try {
            calculator.calculate(10, 1, "-");
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        try {
            calculator.calculate(512, 0, "/");
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}