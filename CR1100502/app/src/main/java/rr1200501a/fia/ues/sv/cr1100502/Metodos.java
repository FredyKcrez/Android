package rr1200501a.fia.ues.sv.cr1100502;

/**
 * Created by PDM-115 on 06/03/2015.
 */
public class Metodos {
    public static String suma(float valor1, float valor2){
        String sumastr;
        float sumafloat=valor1+valor2;
        sumastr=String.valueOf(sumafloat);
        return sumastr;
    }
    public static String suma(float valor1, float valor2, float valor3) {
        String sumastr;
        float sumafloat = valor1 + valor2 + valor3;
        sumastr = String.valueOf(sumafloat);
        return sumastr;
    }
    public static String suma(int...valores) {
        String sumastr;
        int suma = 0;
        for(int valor:valores){
            suma+=valor;
        }
        sumastr = String.valueOf(suma);
        return sumastr;
    }
}
