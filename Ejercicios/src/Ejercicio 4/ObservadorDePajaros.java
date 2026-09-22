class ObservadorDePajaros {

    private final int[] pajarosPorDia;

    public ObservadorDePajaros(int[] pajarosPorDia) {
        this.pajarosPorDia = pajarosPorDia;
    }

    public static int[] obtenerSemanaPasada() {
        return new int[] { 0, 2, 5, 3, 7, 8, 4 };
    }

    public int obtenerHoy() {
        return pajarosPorDia[pajarosPorDia.length - 1];
    }

    public void incrementarConteoDeHoy() {
        pajarosPorDia[pajarosPorDia.length - 1]++;
    }

    public boolean hayDiaSinPajaros() {
        for (int conteo : pajarosPorDia) {
            if (conteo == 0) {
                return true;
            }
        }
        return false;
    }

    public int obtenerConteoPrimerosDias(int numeroDeDias) {
        int total = 0;
        int limite = Math.min(numeroDeDias, pajarosPorDia.length);
        for (int i = 0; i < limite; i++) {
            total += pajarosPorDia[i];
        }
        return total;
    }

    public int obtenerDiasOcupados() {
        int ocupados = 0;
        for (int conteo : pajarosPorDia) {
            if (conteo >= 5) {
                ocupados++;
            }
        }
        return ocupados;
    }

    public static void main(String[] args) {
        int[] pajarosPorDia = { 2, 5, 0, 7, 4, 1 };
        ObservadorDePajaros observador = new ObservadorDePajaros(pajarosPorDia);

        int[] semanaPasada = ObservadorDePajaros.obtenerSemanaPasada();
        System.out.print("obtenerSemanaPasada: ");
        for (int conteo : semanaPasada) {
            System.out.print(conteo + " ");
        }
        System.out.println();

        System.out.println("obtenerHoy: " + observador.obtenerHoy());

        observador.incrementarConteoDeHoy();
        System.out.println("obtenerHoy tras incrementar: " + observador.obtenerHoy());

        System.out.println("hayDiaSinPajaros: " + observador.hayDiaSinPajaros());
        System.out.println("obtenerConteoPrimerosDias(4): " + observador.obtenerConteoPrimerosDias(4));
        System.out.println("obtenerDiasOcupados: " + observador.obtenerDiasOcupados());
    }
}