package trapintegrationapp;

import static java.lang.Math.sin;

public class TrapIntegrationApp {

    public static void main(String[] args) {
        int sizeOfLineSegments = 7;
        int sizeOfPoints = sizeOfLineSegments + 1;
        
        double a = 1.0;
        double b = 2.0;
        
        double h = (b - a) / sizeOfLineSegments;
        
        double[] x = new double[sizeOfPoints];
        x[0] = a;
        x[sizeOfPoints - 1] = b;
        for(int i = 1; i < sizeOfPoints - 1; i++)
            x[i] = x[0] + i*h;
        
        double[] y = new double[sizeOfPoints];
        for(int i = 0; i < sizeOfPoints; i++)
            y[i] = (x[i]/2 + 1) * sin(x[i] / 2);
           
        double integral = 0.0;
        for(int i = 0; i < sizeOfPoints; i++)
            if(i == 0 || i == sizeOfPoints - 1)
                integral += y[i] / 2;
            else
                integral += y[i];
        integral *= h;
        
        
        double[] der = new double[sizeOfPoints];
        for(int i = 0; i < sizeOfPoints; i++){
            der[i] = 1 / (2*x[i] * Math.pow(Math.sqrt(x[i]) + 1, 3));
            der[i] += 1 / (4*Math.pow(x[i], 1.5) * Math.pow(Math.sqrt(x[i]) + 1, 2));
        }
        
        double M2 = 0;
        for(int i = 0; i < sizeOfPoints; i++)
            if(Math.abs(der[i]) > M2 && der[i] != Double.POSITIVE_INFINITY)
                M2 = Math.abs(der[i]);
                
        double R = -((b-a) / 12) * M2 * Math.pow(h, 2); 
        
        

        
        System.out.println("Function: 1/(1+sqrt(x))");
        System.out.println("[" + a + "]" + "[" + b +"]");
        System.out.println("n = " + sizeOfLineSegments);
        System.out.println("Trapezoid's method");
        System.out.println("****************");
        System.out.println("Answer = " + integral);
        System.out.println("R = " + R);
        System.out.println("Answer with R = " + (integral + R));
            
        /*System.out.println("x[i]:");
        for(int i = 0; i < sizeOfPoints; i++)
            System.out.println(x[i]);
        System.out.println();
        
        System.out.println("y[i]:");
        for(int i = 0; i < sizeOfPoints; i++)
            System.out.println(y[i]);
        System.out.println();
        
        System.out.println("Result of integration without R(h):");
        System.out.println(integral);
        System.out.println();
        
        System.out.println("R(h):");
        System.out.println(R);
        System.out.println();
        
        System.out.println("Result of integration with R(h):");
        System.out.println(integral + R);*/
        
    }
}
