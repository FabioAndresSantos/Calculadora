package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNumero1, editNumero2;
    private TextView resultado;

    private Button btnSuma, btnResta, btnMultiplicacion, btnDivision, btnPotencia, btnPorcentaje, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //campos editable
        editNumero1 = (EditText) findViewById(R.id.editNumero1);
        editNumero2 = (EditText) findViewById(R.id.editNumero2);
        resultado = (TextView) findViewById(R.id.Resultado);

        //botones
        btnSuma =(Button) findViewById(R.id.btnSuma);
        btnResta = (Button) findViewById(R.id.btnResta);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        btnMultiplicacion = (Button) findViewById(R.id.btnMultiplicacion);
        btnPorcentaje = (Button) findViewById(R.id.btnPorcentaje);
        btnPotencia = (Button) findViewById(R.id.btnPotencia);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        btnSuma.setOnClickListener(this);
        btnResta.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnMultiplicacion.setOnClickListener(this);
        btnPorcentaje.setOnClickListener(this);
        btnPotencia.setOnClickListener(this);
        btnSalir.setOnClickListener(this);
    }

    @Override
    public void onClick(View vista) {
        double n1,n2;
        switch (vista.getId()){
            case R.id.btnSuma:
                 n1 = Double.parseDouble (editNumero1.getText().toString());
                 n2 = Double.parseDouble(editNumero2.getText().toString());
                resultado.setText(String.valueOf(formatearDouble(n1+n2)));
                break;
            case R.id.btnResta:
                 n1 = Double.parseDouble (editNumero1.getText().toString());
                 n2 = Double.parseDouble(editNumero2.getText().toString());
                resultado.setText(String.valueOf(formatearDouble(n1-n2)));
                break;
            case R.id.btnDivision:
                n1 = Double.parseDouble (editNumero1.getText().toString());
                n2 = Double.parseDouble(editNumero2.getText().toString());
                if (n2 == 0){
                    resultado.setText(String.valueOf("No se puede dividir por 0"));
                    break;
                }
                resultado.setText(String.valueOf(formatearDouble(n1/n2)));
                break;
            case R.id.btnMultiplicacion:
                n1 = Double.parseDouble (editNumero1.getText().toString());
                n2 = Double.parseDouble(editNumero2.getText().toString());
                resultado.setText(String.valueOf(formatearDouble(n1*n2)));
                break;
            case R.id.btnPorcentaje:
                n1 = Double.parseDouble (editNumero1.getText().toString());
                n2 = Double.parseDouble(editNumero2.getText().toString());
                if (n2 == 0){
                    resultado.setText(String.valueOf(0));
                    break;
                }
                resultado.setText(String.valueOf(formatearDouble(n1%n2)));
                break;
            case R.id.btnPotencia:
                n1 = Double.parseDouble (editNumero1.getText().toString());
                n2 = Double.parseDouble(editNumero2.getText().toString());
                resultado.setText(String.valueOf(formatearDouble(Math.pow(n1,n2))));
                break;
            case R.id.btnSalir:
                finish();
                break;
        }
    }
    public static String formatearDouble(double numero) {
        if (numero == (int) numero) {
            return String.format("%d", (int) numero); // Si el valor es un número entero, devolverlo sin decimales
        } else {
            return String.format("%s", numero); // Si el valor tiene decimales, devolverlo con decimales
        }
    }
}