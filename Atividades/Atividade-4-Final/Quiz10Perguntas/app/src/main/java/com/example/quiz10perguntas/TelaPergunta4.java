package com.example.quiz10perguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TelaPergunta4 extends AppCompatActivity {

    Funcoes func = new Funcoes();

    TextView txtNomeJogador;
    RadioGroup rgpPergunta4;
    Button btnAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pergunta4);

        txtNomeJogador = findViewById(R.id.txtNomeJogador);
        rgpPergunta4 = findViewById(R.id.rgpPergunta4);
        btnAvancar   = findViewById(R.id.btnAvancar);

        Jogador jogador = getIntent().getExtras().getParcelable("jogador");
        txtNomeJogador.setText(jogador.getNome());


        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // func.manipularClick(
                //     rgpPergunta1, // radio group
                //     "questao-01", // questão a se obter a resposta
                //     jogador, // objeto do jogador
                //     TelaPergunta4.class, // activity atual
                //     TelaPergunta5.class  // activity de destino                    
                // );

                int respostaCorreta = func.obterRespostaCorreta("questao-04");
                int opcaoSelecionada = rgpPergunta4.getCheckedRadioButtonId();

                if (opcaoSelecionada == -1) {
                    String text = "Por favor, escolha uma alternativa";
                    Toast.makeText(TelaPergunta4.this, text, Toast.LENGTH_SHORT).show();
                } else {
                    if (opcaoSelecionada == respostaCorreta) {
                        jogador.setAcertos(1);
                    }

                    func.irPara(TelaPergunta4.this, TelaPergunta5.class, jogador);
                }
            }
        });
        
    }
}