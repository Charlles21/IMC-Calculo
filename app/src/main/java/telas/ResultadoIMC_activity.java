package telas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculoimc.MainActivity;
import com.example.calculoimc.R;

public class ResultadoIMC_activity extends AppCompatActivity {
    double calculoIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadoimc);

        VinculaDadosMain();
        VinculaCalculoIMC();
        buttonRecalcular();
        TabelaDeIMC();

    }

    private void TabelaDeIMC() {
            TextView IMC = findViewById(R.id.imc);
            if(calculoIMC == Double.parseDouble("Infinity")){
                IMC.setText("Numeros Invalidos");
            }else if(calculoIMC < 18.5){
                IMC.setText("Magreza");

            }else if(calculoIMC > 18.5 && calculoIMC < 24.9){

                IMC.setText("Normal");
            }else if(calculoIMC > 24.9 && calculoIMC < 29.9){

                IMC.setText("Sobrepreso");
            }else if(calculoIMC > 29.9 && calculoIMC < 39.9){

                IMC.setText("Obesidade grau II");
            }else{

                IMC.setText("Obesidade Grave III");
            }

            Log.i("CalculoIMC", "TabelaDeIMC: "+calculoIMC);

    }

    private void buttonRecalcular() {
        Button Recalcular = findViewById(R.id.Recalcular);
        Recalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

                startActivity(new Intent(ResultadoIMC_activity.this, MainActivity.class));
            }
        });
    }

    private void VinculaCalculoIMC() {
        TextView ResultadoIMC = findViewById(R.id.ResultadoIMC);

        ResultadoIMC.setText(String.valueOf(calculoIMC));
        //formata em 2 casas decimais
        ResultadoIMC.setText(String.format("%.2f", calculoIMC));
    }

    private void VinculaDadosMain() {
        Intent DadosMain = getIntent();
        Bundle parametros = DadosMain.getExtras();
        Log.i("TAG", "VinculaDadosMain: "+parametros);

        calculoIMC = parametros.getDouble("Resultado");
    }

}
