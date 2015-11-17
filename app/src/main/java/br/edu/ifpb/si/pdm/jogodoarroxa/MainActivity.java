package br.edu.ifpb.si.pdm.jogodoarroxa;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_valores;
    private EditText et_valores;
    private Button btn_jogar;
    private LinearLayout linearLayout_background;
    private Jogo jogo;


    public MainActivity() {
        this.jogo = new Jogo();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trazerComponentes();
        this.btn_jogar.setOnClickListener(new OnClickBotao());
        tv_valores.setText(jogo.getNumeroMenor() + "--" + jogo.getNumeroMaior());


    }
    public void trazerComponentes(){
        this.btn_jogar = (Button) this.findViewById(R.id.btn_jogar);
        this.et_valores = (EditText) this.findViewById(R.id.et_valores);
        this.tv_valores = (TextView) this.findViewById(R.id.tv_valores);
        this.linearLayout_background = (LinearLayout) this.findViewById(R.id.Layout_backgroud);
    }

    private class OnClickBotao implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Log.w("APP", jogo.getSecretNumber() + "");
            switch (jogo.checkNumber(Integer.parseInt(et_valores.getText().toString()))){

                case GANHOU: {
                    tv_valores.setText("Voce Ganhou!");
                    et_valores.setVisibility(View.INVISIBLE);
                    btn_jogar.setVisibility(View.INVISIBLE);
                    linearLayout_background.setBackgroundColor(Color.GREEN);
                    break;
                }
                case PERDEU: {
                    tv_valores.setText("Voce Perdeu!");
                    et_valores.setVisibility(View.INVISIBLE);
                    btn_jogar.setVisibility(View.INVISIBLE);
                    linearLayout_background.setBackgroundColor(Color.RED);
                    break;
                }
                case TENTAR_NOVAMENTE: {
                    tv_valores.setText(jogo.getNumeroMenor() + "--" + jogo.getNumeroMaior());
                    break;
                }

            }
        }
    }

}
