/**
 * Main
 */
class HiloSumapim {
    public static void main(String[] args) {
        int suma;
        HiloSuma hilo1 = new HiloSuma("Par", 2, 100);
        HiloSuma hilo2 = new HiloSuma("Impar", 1, 99);

        hilo1.start();
        hilo2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {}

        suma = hilo1.suma() + hilo2.suma();
        System.out.println("La suma es: " + suma);
    }

    /**
     * HiloSuma
     */
    static class HiloSuma extends Thread {
        private int i, f, suma;

        HiloSuma(String mensaje, int i, int f) {
            super(mensaje);
            this.i = i;
            this.f = f;
            suma = 0;
        }

        @Override
        public void run() {
            for (int k = i; k <= f; k += 2) {
                suma += k;
                System.out.println(getName() + ":" + suma);
            }
            System.out.println("Hilo finalizado: " + getName());
        }

        public int suma() {
            return suma;
        }
    } // end class HiloSuma
} // end class Main
