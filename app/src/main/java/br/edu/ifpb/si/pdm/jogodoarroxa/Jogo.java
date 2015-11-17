package br.edu.ifpb.si.pdm.jogodoarroxa;

import android.util.Log;

import java.util.Random;

/**
 * Created by admin on 17/11/15.
 */
public class Jogo {


    private int numeroMenor, numeroMaior, secretNumber;

    public Jogo() {
        this.numeroMenor = 01;
        this.numeroMaior = 100;
        this.secretNumber = secretNumber();
    }

    private int secretNumber(){
        Random r = new Random();
        int x = r.nextInt(97) + 2;
        return x;
    }
    public int getNumeroMenor() {
        return numeroMenor;
    }

    public int getNumeroMaior() {
        return numeroMaior;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public Status checkNumber(int numeroDigitado) {
        Log.w("APP", String.format("%d %d %d %d", numeroMenor, numeroMaior, secretNumber, numeroDigitado));
        if (numeroDigitado <= numeroMenor || numeroDigitado >= numeroMaior) {
            return Status.PERDEU;
        }
        if (numeroDigitado == secretNumber){
            Log.w ("APP", "ENTROU");
            return Status.GANHOU;

        }else if (numeroDigitado > secretNumber){
            this.numeroMaior = numeroDigitado;
        }else if(numeroDigitado < secretNumber) {
            this.numeroMenor = numeroDigitado;
        }

        if (verificarIntervalo()){
            return Status.PERDEU;
        }else {
            return Status.TENTAR_NOVAMENTE;
        }
    }
    private boolean verificarIntervalo (){
        if (numeroMenor +2 == numeroMaior){
            return true;
        }else {
            return false;
        }

    }
}
