package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import org.nfunk.jep.JEP;
import org.nfunk.jep.ParseException;


public class MainActivity extends AppCompatActivity {


    private String numeroTemp = "";


    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnAC, btnGuardar, btnBorrar, btnDivision, btnMultiplicacion,btnMas, btnMenos, btnComa, btnIgual;
    TextView tvResultado;
    TextView tvHistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();

        tvResultado = findViewById(R.id.tvResultado);
        tvHistorico = findViewById(R.id.tvHistorico);
        String valorRecuperado = SharedPreferencesManager.getMyValue(getApplicationContext());

        tvHistorico.setText(valorRecuperado);

        //Botones numericos
        btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(v -> {
            numeroTemp = numeroTemp + "0";
            tvResultado.setText(numeroTemp);
        });

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(v -> {
            numeroTemp = numeroTemp + "1";
            tvResultado.setText(numeroTemp);
        });

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(v -> {
            numeroTemp = numeroTemp + "2";
            tvResultado.setText(numeroTemp);
        });

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(v -> {
            numeroTemp = numeroTemp + "3";
            tvResultado.setText(numeroTemp);
        });

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(v -> {
            numeroTemp = numeroTemp + "4";
            tvResultado.setText(numeroTemp);
        });

        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(v -> {
            numeroTemp = numeroTemp + "5";
            tvResultado.setText(numeroTemp);
        });

        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(v -> {
            numeroTemp = numeroTemp + "6";
            tvResultado.setText(numeroTemp);
        });

        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(v -> {
            numeroTemp = numeroTemp + "7";
            tvResultado.setText(numeroTemp);
        });

        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(v -> {
            numeroTemp = numeroTemp + "8";
            tvResultado.setText(numeroTemp);
        });

        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(v -> {
            numeroTemp = numeroTemp + "9";
            tvResultado.setText(numeroTemp);
        });

        //Botones operaciones
        btnAC = findViewById(R.id.btnAC);
        btnAC.setOnClickListener(v -> {
            numeroTemp = "";
            tvHistorico.setText("");
            tvResultado.setText(numeroTemp);
        });

        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(v -> {
            SharedPreferencesManager.saveMyValue(getApplicationContext(), (String) tvHistorico.getText());

        });

        btnBorrar = findViewById(R.id.btnBorrar);
        btnBorrar.setOnClickListener(v -> {
            if (numeroTemp.length()>1){
                numeroTemp = numeroTemp.substring(0,numeroTemp.length()-1);

            }else{
                numeroTemp = "0";

            }
            tvResultado.setText(numeroTemp);

        });

        btnDivision = findViewById(R.id.btnDivision);
        btnDivision.setOnClickListener(v -> {
            numeroTemp += "/";
            tvResultado.setText(numeroTemp);
        });

        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);
        btnMultiplicacion.setOnClickListener(v -> {
            numeroTemp += "*";
            tvResultado.setText(numeroTemp);
        });

        btnMenos = findViewById(R.id.btnMenos);
        btnMenos.setOnClickListener(v -> {
            numeroTemp += "-";
            tvResultado.setText(numeroTemp);
        });

        btnMas = findViewById(R.id.btnMas);
        btnMas.setOnClickListener(v -> {
            numeroTemp += "+";
            tvResultado.setText(numeroTemp);
        });

        btnComa = findViewById(R.id.btnComa);
        btnComa.setOnClickListener(v ->
        {
            numeroTemp += ".";
            tvResultado.setText(numeroTemp);
        });

        btnIgual =  findViewById(R.id.btnIgual);
        btnIgual.setOnClickListener(v -> {

                    try {
                        Object resultado = jep.evaluate(jep.parseExpression(numeroTemp));
                        String resMath = resultado.toString();
                        tvResultado.setText(resMath);
                        tvHistorico.setText(String.format("%s = %s", numeroTemp, resMath));
                        numeroTemp= resMath;
                    } catch (ParseException e) {
                        tvResultado.setText(R.string.syntax_error);

                    }
                }
        );




    }
}