package com.example.calculoimc;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import Classes.IMC;
import telas.ResultadoIMC_activity;


public class MainActivity extends AppCompatActivity {
    final IMC imc = new IMC();

    public final String CHAVE = "Resultado";
    SeekBar SeekBarPeso;
    TextView textPeso;
    SeekBar SeekBarAltura;
    TextView textAltura;
    public double Altura;
    int Peso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View ButtonCalcular = IniciaViews();
        SeekBarPeso();
        SeekBarAltura();


        buttonCAlcular(ButtonCalcular);


    }

    private void buttonCAlcular(View ButtonCalcular) {
        ButtonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent AbreResultado = new Intent(MainActivity.this, ResultadoIMC_activity.class);
                Bundle parametros = new Bundle();



                parametros.putDouble(CHAVE, ResultadoIMC());

                AbreResultado.putExtras(parametros);

                finish();
                startActivity(AbreResultado);

            }
        });
    }

    private double ResultadoIMC() {
        return imc.CalculoIMC(imc.getPeso(), imc.getAltura());
    }

    private void SeekBarAltura() {

        SeekBarAltura.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int altura, boolean b) {
                alturaEmMetros(altura);
                imc.setAltura(Altura);
                textAltura.setText(Altura +"m");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void SeekBarPeso() {
        SeekBarPeso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int peso, boolean b) {
                    Peso = peso;
                    imc.setPeso(Peso);

                    textPeso.setText(Peso +"Kg");
                }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private View IniciaViews() {
        View ButtonCalcular = findViewById(R.id.buttonCalcular);
        SeekBarPeso = (SeekBar)findViewById(R.id.seekbarPeso);
        textPeso = (TextView)findViewById(R.id.textviewPeso);
        SeekBarAltura = (SeekBar)findViewById(R.id.seekbarAltura);
        textAltura = (TextView)findViewById(R.id.textViewAltura);
        return ButtonCalcular;
    }

    private void alturaEmMetros(int altura) {
        Altura = altura;
        Altura /= 100;
    }


}