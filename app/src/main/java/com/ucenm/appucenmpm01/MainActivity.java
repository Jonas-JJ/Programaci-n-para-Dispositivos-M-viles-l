package com.ucenm.appucenmpm01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.ucenm.appucenmpm01.Models.Operaciones;
import com.ucenm.appucenmpm01.Views.ActivityResultado;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private Button btnSuma, btnResta, btnDivision, btnMultiplicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.et_num1);
        etNum2 = findViewById(R.id.et_num2);

        btnSuma = findViewById(R.id.btn_suma);
        btnResta = findViewById(R.id.btn_resta);
        btnDivision = findViewById(R.id.btn_division);
        btnMultiplicacion = findViewById(R.id.btn_multiplicacion);

        btnSuma.setOnClickListener(v -> procesarOperacion("suma"));
        btnResta.setOnClickListener(v -> procesarOperacion("resta"));
        btnDivision.setOnClickListener(v -> procesarOperacion("division"));
        btnMultiplicacion.setOnClickListener(v -> procesarOperacion("multiplicacion"));
    }

    private void procesarOperacion(String tipoOperacion) {
        String n1Str = etNum1.getText().toString();
        String n2Str = etNum2.getText().toString();

        if (n1Str.isEmpty() || n2Str.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(n1Str);
        double num2 = Double.parseDouble(n2Str);

        Operaciones op = new Operaciones(num1, num2, tipoOperacion);

        Intent intent = new Intent(MainActivity.this, ActivityResultado.class);
        intent.putExtra("objeto_operacion", op);
        startActivity(intent);
    }
}