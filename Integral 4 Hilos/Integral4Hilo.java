/**
 * Main
 * Meotodo para resolver una integral mediante el metood de SImpson
 */
 //Aca se ingresa la integral a realizar
 
class Integral4Hilo {
    public static double fx (double x){
        return Math.exp(x*x);//Integral
     }
     
    public static void main(String[] args) {
        double suma, x0, xn, h;
        long n;// Se cambio el tipo de dato de n a long al igual en el constructor de los hilos
        x0 = 1;
        xn = 2;
        n = (long) (Math.pow(2, 32) / 2);//Se cambia el valor de n, al solicitado por el profesor
        h = (xn-x0)/n;
        //Hilos par
        HiloSumaPar hilo1 = new HiloSumaPar("Par", x0, xn, n);
        HiloSumaPar hilo2 = new HiloSumaPar("Par2", x0, xn, n);
        //Hilos impar
        HiloSumaImpar hilo3 = new HiloSumaImpar("Impar", x0, xn, n);
        HiloSumaImpar hilo4 = new HiloSumaImpar("Impar2", x0, xn, n);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException ie) {}

        // Calcular la suma final de los pares e impares
        suma = (h/3)*(fx(x0)+fx(xn)+hilo1.suma()+hilo2.suma()+hilo3.suma()+hilo4.suma());
        System.out.println("La integral es: " + suma);
    }///Fin metodo Main 



    /**
     * HiloSumaPar
     */
    static class HiloSumaPar extends Thread {
        private double suma, x0, xn;
        private int n;

        HiloSumaPar(String mensaje, double x0, double xn, int n) {
            super(mensaje);
            suma = 0;
            this.x0 = x0;
            this.xn = xn;
            this.n = n;
        }


        public double fx (double x){
            return x*x+1;
        }

        @Override
        public void run() {
            double xi, h;
            h = (xn-x0)/n;

            for (int i = 2; i <= n-2; i += 2) {
                xi = x0 + i *h;
                suma += fx(xi);
            }
            
            suma = suma*2;


            System.out.println(getName() + ":" + suma);
            System.out.println("Hilo finalizado: " + getName());
        }

        public double suma() {
            return suma;
        }
    } // end class HiloSumaPar



    /**
     * HiloSumaImPar
     */
    static class HiloSumaImpar extends Thread {
        private double suma, x0, xn;
        private int n;



        HiloSumaImpar(String mensaje, double x0, double xn, int n) {
            super(mensaje);
            suma = 0;
            this.x0 = x0;
            this.xn = xn;
            this.n = n;
        }


        public double fx (double x){
            return x*x+1;
        }

        @Override
        public void run() {
            double xi, h;
            h = (xn-x0)/n;

            for (int i = 1; i <= n-1; i += 2) {
                xi = x0 + i *h;
                suma += fx(xi);
            }
            suma= suma*4;


            System.out.println(getName() + ":" + suma);
            System.out.println("Hilo finalizado: " + getName());
        }

        public double suma() {
            return suma;
        }
    } // end class HiloSumaImpar

} // end class Main
