package com.android.calculomedia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText n1, n2, n3, n4, faltas;
    Button calcular;
    TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1        = findViewById(R.id.txtNota1);
        n2        = findViewById(R.id.txtNota2);
        n3        = findViewById(R.id.txtNota3);
        n4        = findViewById(R.id.txtNota4);
        faltas    = findViewById(R.id.txtFaltas);
        resultado = findViewById(R.id.txtMedia);
        calcular = findViewById(R.id.btnContMedia);


        calcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

               boolean retorno = validarCampo();
               if (retorno) {
                   int nota1 = Integer.parseInt(n1.getText().toString());
                   int nota2 = Integer.parseInt(n2.getText().toString());
                   int nota3 = Integer.parseInt(n3.getText().toString());
                   int nota4 = Integer.parseInt(n4.getText().toString());
                   int nfalta = Integer.parseInt(faltas.getText().toString());

                   double media = (nota1 + nota2 + nota3 + nota4) / 4;

                   if (media >= 5 && nfalta < 20) {
                       resultado.setText("Aluno Aprovado com Sucesso!");
                       resultado.setTextColor(R.color.verde);
                   } else if (nfalta > 20) {
                       resultado.setText("Aluno Reprovado por FALTAS!");
                       resultado.setTextColor(R.color.vermelho);
                   } else if (media < 5) {
                       resultado.setText("Aluno Reprovado com NOTA:" + media);
                       resultado.setTextColor(R.color.vermelho);
                   }
               }
                }
        });
    }


    private boolean validarCampo() {

        boolean camposValidados = true;

        if (n1.getText().toString().isEmpty()) {
                camposValidados = false;
                n1.setError("Digite a Nota 1");
        } else
            if (n2.getText().toString().isEmpty()) {
                camposValidados = false;
                n2.setError("Digite a Nota 2");
        } else
            if (n3.getText().toString().isEmpty()) {
                camposValidados = false;
                n3.setError("Digite a Nota 3");
        } else
            if (n4.getText().toString().isEmpty()) {
                camposValidados = false;
                n4.setError("Digite a Nota 4");
        } else
            if (faltas.getText().toString().isEmpty()) {
                camposValidados = false;
                faltas.setError("Digite o Número de faltas");
        } else {
                camposValidados = true;
            }
        return camposValidados;
    }
}
