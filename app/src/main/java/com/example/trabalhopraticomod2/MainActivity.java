package com.example.trabalhopraticomod2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Definição das constantes enviadas pelo Intent

    public final static String SALARIO_VALUE = "SALARIO_VALUE";
    public final static String OUTROS_DESCONTOS_VALUE = "OUTROS_DESCONTOS_VALUE";
    public final static String NUM_DEPENDENTES = "NUM_DEPENDENTES";

    private EditText salarioBrutoEditText;
    private EditText numDependentesEditText;
    private EditText outrosDescontosEditText;
    private Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Iniciando as variáveis
        salarioBrutoEditText = findViewById(R.id.editTextSalarioBruto);
        numDependentesEditText = findViewById(R.id.editTextDependentes);
        outrosDescontosEditText = findViewById(R.id.editTextDependentes);
        calcularButton = findViewById(R.id.buttonCalcular);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);

                //Recebe os valores dos campos
                String salarioBrutoValue = salarioBrutoEditText.getText().toString();
                String numDependentesValue = numDependentesEditText.getText().toString();
                String outrosDescontosValue = outrosDescontosEditText.getText().toString();

                //Resgata valores digitados pelo usuário para enviar para a próxima activity
                Double salarioBruto = !salarioBrutoValue.isEmpty() ? Double.parseDouble(salarioBrutoValue) : 0;
                Integer numDependentes = !numDependentesValue.isEmpty() ? Integer.parseInt(numDependentesValue) : 0;
                Double outrosDescontos = !outrosDescontosValue.isEmpty() ? Double.parseDouble(outrosDescontosValue) : 0;

                //Define os valores a serem enviados para próxima activity
                intent.putExtra(SALARIO_VALUE, salarioBruto);
                intent.putExtra(NUM_DEPENDENTES, numDependentes);
                intent.putExtra(OUTROS_DESCONTOS_VALUE, outrosDescontos);

                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        //Reseta os valores do usuário ao voltar para a tela
        salarioBrutoEditText.setText("");
        numDependentesEditText.setText("");
        outrosDescontosEditText.setText("");
    }
}