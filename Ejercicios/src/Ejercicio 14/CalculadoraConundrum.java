class OperacionIlegalException extends Exception {
    public OperacionIlegalException(String mensaje) {
        super(mensaje);
    }

    public OperacionIlegalException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

public class CalculadoraConundrum {

    public String calcular(int operando1, int operando2, String operacion) throws OperacionIlegalException {
        if (operacion == null) {
            throw new IllegalArgumentException("La operación no puede ser nula");
        }
        if (operacion.isEmpty()) {
            throw new IllegalArgumentException("La operación no puede estar vacía");
        }

        int resultado;
        switch (operacion) {
            case "+":
                resultado = operando1 + operando2;
                break;
            case "*":
                resultado = operando1 * operando2;
                break;
            case "/":
                try {
                    resultado = operando1 / operando2;
                } catch (ArithmeticException e) {
                    throw new OperacionIlegalException("No se permite dividir entre cero", e);
                }
                break;
            default:
                throw new OperacionIlegalException("La operación '" + operacion + "' no existe");
        }

        return operando1 + " " + operacion + " " + operando2 + " = " + resultado;
    }

    public static void main(String[] args) {
        CalculadoraConundrum calculadora = new CalculadoraConundrum();

        try {
            System.out.println(calculadora.calcular(16, 51, "+"));
            System.out.println(calculadora.calcular(32, 6, "*"));
            System.out.println(calculadora.calcular(512, 4, "/"));
        } catch (OperacionIlegalException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            calculadora.calcular(10, 1, null);
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        try {
            calculadora.calcular(10, 1, "");
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        try {
            calculadora.calcular(10, 1, "-");
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        try {
            calculadora.calcular(512, 0, "/");
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}