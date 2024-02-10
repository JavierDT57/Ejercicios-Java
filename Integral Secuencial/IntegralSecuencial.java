/**
 * Main
 * Meotodo para resolver una integral mediante el metood de SImpson
 */
//Aca se ingresa la integral a realizar
public class IntegralSecuencial {
    public static double fx(double x) {
        return Math.exp(x*x);//Integral
    }

    //Variables a usar para el metodo Simpson
    public static void main(String[] args) {
        double sumaTotal, x0, xn, h;
        double sumaPar = 0;
        double sumaImpar = 0;
        int n;
        x0 = 1;
        xn = 3;
        n = 1000000;//Se ingresa una cantidad grande para evitar conflictos en la ejecucion
        h = (xn - x0) / n;



        // Suma de manera par
        for (int i = 2; i <= n - 2; i += 2) {
            double xi = x0 + i * h;
            sumaPar += fx(xi);
        }
        sumaPar = sumaPar * 2;

        // Suma de manera impar
        for (int i = 1; i <= n - 1; i += 2) {
            double xi = x0 + i * h;
            sumaImpar += fx(xi);
        }
        sumaImpar = sumaImpar * 4;

        // Calcular la suma final de los pares e impares
        sumaTotal = (h / 3) * (fx(x0) + fx(xn) + sumaPar + sumaImpar);
        System.out.println("La integral es: " + sumaTotal);
    }
}
