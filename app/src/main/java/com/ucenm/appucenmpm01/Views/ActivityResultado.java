package com.ucenm.appucenmpm01.Views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.ucenm.appucenmpm01.MainActivity;
import com.ucenm.appucenmpm01.R;
import com.ucenm.appucenmpm01.Models.Operaciones;

public class ActivityResultado extends AppCompatActivity {

    private TextView tvResultado;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvResultado = findViewById(R.id.tv_resultado);
        btnVolver = findViewById(R.id.btn_volver);

        Operaciones op = (Operaciones) getIntent().getSerializableExtra("objeto_operacion");

        if (op != null) {
            double res = op.getResultado();
            if (res % 1 == 0) {
                tvResultado.setText("El resultado es: " + (int) res);
            } else {
                tvResultado.setText("El resultado es: " + res);
            }
        }

        // Forma explícita para regresar a la Activity Principal
        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityResultado.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
    }
}