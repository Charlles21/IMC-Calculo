package Classes;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class IMC implements Serializable {
    private double Peso;
    private double altura;

    public IMC() {

    }


    public double getPeso() {
        return Peso;
    }

    public void setPeso(double peso) {
        Peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @NonNull
    @Override
    public String toString() {
        return " Peso=" + Peso +", altura=" + altura;
    }

    public double CalculoIMC( double Peso,  double altura ){
        altura *= altura;
        Peso /= altura;

        return Peso;
    }



}
