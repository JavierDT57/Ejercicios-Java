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
        Hilo1SumaPar hilo1 = new Hilo1SumaPar("Par", x0, xn, n);
        Hilo2SumaPar hilo2 = new Hilo2SumaPar("Par2", x0, xn, n);
        //Hilos impar
        Hilo3SumaImpar hilo3 = new Hilo3SumaImpar("Impar", x0, xn, n);
        Hilo4SumaImpar hilo4 = new Hilo4SumaImpar("Impar2", x0, xn, n);

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
     * Hilo1SumaPar
     */
    static class Hilo1SumaPar extends Thread {
        private double suma, x0, xn;
        private long n;

        Hilo1SumaPar(String mensaje, double x0, double xn, long n) {
            super(mensaje);
            suma = 0;
            this.x0 = x0;
            this.xn = xn;
            this.n = n;
        }


        public double fx (double x){
            return Math.exp(x*x);//Integral
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
    } // end class Hilo1SumaPar




    /**
     * Hilo2SumaPar
     */
    static class Hilo2SumaPar extends Thread {
        private double suma, x0, xn;
        private long n;

        Hilo2SumaPar(String mensaje, double x0, double xn, long n) {
            super(mensaje);
            suma = 0;
            this.x0 = x0;
            this.xn = xn;
            this.n = n;
        }


        public double fx (double x){
            return Math.exp(x*x);//Integral
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
    } // end class Hilo2SumaPar




    /**
     * Hilo3SumaImPar
     */
    static class Hilo3SumaImpar extends Thread {
        private double suma, x0, xn;
        private long n;



        Hilo3SumaImpar(String mensaje, double x0, double xn, long n) {
            super(mensaje);
            suma = 0;
            this.x0 = x0;
            this.xn = xn;
            this.n = n;
        }


        public double fx (double x){
            return Math.exp(x*x);//Integral
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
    } // end class Hilo3SumaImpar




    /**
     * Hilo4SumaImPar
     */
    static class Hilo4SumaImpar extends Thread {
        private double suma, x0, xn;
        private long n;



        Hilo4SumaImpar(String mensaje, double x0, double xn, long n) {
            super(mensaje);
            suma = 0;
            this.x0 = x0;
            this.xn = xn;
            this.n = n;
        }


        public double fx (double x){
            return Math.exp(x*x);//Integral
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
    } // end class Hilo4SumaImpar

} // end class Main
