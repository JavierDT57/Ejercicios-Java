public class factorial {

    public static void main(String[] args) {
        int n = 10;
        int r = 5;

        HiloF hilo1 = new HiloF(n, "FactorialN");
        HiloF hilo2 = new HiloF(r, "FactorialR");
        HiloF hilo3 = new HiloF(n - r, "FactorialNR");

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            Thread.sleep(1000); // Espera 1 segundo
            while (!hilo1.isFinished() || !hilo2.isFinished() || !hilo3.isFinished()) {
                Thread.sleep(100); // Espera 100 milisegundos
            }
        } catch (InterruptedException ie) {}

        long factorialN = hilo1.f;
        long factorialR = hilo2.f;
        long factorialNR = hilo3.f;

        System.out.println("n! = " + factorialN);
        System.out.println("r! = " + factorialR);

        long combinaciones = factorialN / (factorialNR * factorialR);

        System.out.println("C(" + n + ", " + r + ") = " + combinaciones);
    }

    static class HiloF extends Thread {
        private int numero;
        long f = 1;
        private boolean fin = false;

        public HiloF(int numero, String nombre) {
            super(nombre);
            this.numero = numero;
        }

        @Override
        public void run() {
            for (int i = 1; i <= numero; i++) {
                f *= i;
            }
            fin = true;
        }

        public boolean isFinished() {
            return fin;
        }
    }
}
