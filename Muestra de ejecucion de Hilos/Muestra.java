class Muestra {
    public static void main(String[] args) {
        HiloMensaje hilo1 = new HiloMensaje("Gatote");
        HiloMensaje hilo2 = new HiloMensaje("Perrito");

        hilo1.start();
        hilo2.start();
        System.out.println("Bye");
    } // fin metodo main

    static class HiloMensaje extends Thread {
        HiloMensaje(String mensaje) {
            super(mensaje);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + ": " + getName());
                System.out.println("Hilo finalizado: " + getName());
            }
        }
    } // Fin Clase HiloMensaje
} // fin clase Main
