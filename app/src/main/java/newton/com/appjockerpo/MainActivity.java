package newton.com.appjockerpo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView jogador1;
    ImageView jogador2;

    ImageButton botaoPedra;
    ImageButton botaoTesoura;
    ImageButton botaoPapel;

    int jogada1=0;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.musica);

        jogador1 = findViewById(R.id.jogador1);
        jogador2 = findViewById(R.id.jogador2);

        botaoPapel = findViewById(R.id.botaoPapel);
        botaoTesoura = findViewById(R.id.botaoTesoura);
        botaoPedra = findViewById(R.id.botaoPedra);



        botaoPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogador1.setScaleX(-1f);
                tocaSom();
                jogador1.setImageResource(R.drawable.pedra);
                jogada1 =1;
                sorteiaJogada();
            }
        });

        botaoPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogador1.setScaleX(-1f);
                tocaSom();
                jogador1.setImageResource(R.drawable.papel);
                jogada1 =2;
                sorteiaJogada();
            }
        });

        botaoTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogador1.setScaleX(-1f);
                tocaSom();
                jogador1.setImageResource(R.drawable.tesoura);
                jogada1 =3;
                sorteiaJogada();
            }
        });



    }

    private void sorteiaJogada() {

        Random r = new Random();
        int num = r.nextInt(3);

        switch (num){
            case 0:
                jogador2.setImageResource(R.drawable.pedra);
                break;

            case 1:
                jogador2.setImageResource(R.drawable.papel);
                break;

            case 2:
                jogador2.setImageResource(R.drawable.tesoura);
                break;
        }

        verificaVencedor(num+1);

    }

    private void verificaVencedor(int num) {

        if (num==jogada1){
            Toast.makeText(this, "Empatou !!!", Toast.LENGTH_SHORT).show();
        }

        if (num==1 && jogada1==2 ||num==2 && jogada1==3 || num==3 && jogada1==1){
            Toast.makeText(this, "Vitoria !!!", Toast.LENGTH_SHORT).show();
        }

        if ( num==1 && jogada1==3 ||num==2 && jogada1==1 || num==3 && jogada1==2){
            Toast.makeText(this, "Derrota !!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void tocaSom(){
        if (mediaPlayer!=null){
            mediaPlayer.start();
        }
    }

}
