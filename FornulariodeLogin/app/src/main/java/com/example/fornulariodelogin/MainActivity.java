package com.example.fornulariodelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText nome,idade;
    private RadioButton masculino, feminino;
    private TextView resultadoNome, resultadoIdade, resultadoSexo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nome = findViewById(R.id.editNome);
        idade = findViewById(R.id.editIdade);
        masculino = findViewById(R.id.radioBtnMasculino);
        feminino = findViewById(R.id.radioBtnFeminino);
        resultadoNome = findViewById(R.id.resultadoNome);
        resultadoIdade = findViewById(R.id.resultadoIdade);
        resultadoSexo= findViewById(R.id.resultadoSexo);

        // escutar eventos de click do button de cadastrar
        Button buttonCadastrar = findViewById(R.id.btnCadastar);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String editNome = nome.getText().toString();  // captura oq foi digitado no inp e transforma em string
                
                String editIdade = idade.getText().toString();
                
                if(editNome.isEmpty() || editIdade.isEmpty()){
                    Snackbar.make(v, "Preencha o nome e a idade", Snackbar.LENGTH_SHORT).show();
                } else{
                    RadioBtnSelection(v);
                }
            }
        });
    }

    // metodo para escolher o radioButton
    private void RadioBtnSelection(View view){
        String editNome = nome.getText().toString();
        String editIdade = idade.getText().toString();

        if(feminino.isChecked()){
            resultadoNome.setText(editNome);
            resultadoIdade.setText(editIdade);
            resultadoSexo.setText("feminino");
        }else if(masculino.isChecked()){
            resultadoNome.setText(editNome);
            resultadoIdade.setText(editIdade);
            resultadoSexo.setText("Masculino");
        } else{
            Snackbar.make(view, "Selecionar um sexo", Snackbar.LENGTH_SHORT).show();
        }
    }

}