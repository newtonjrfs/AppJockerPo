package newton.com.appjockerpo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView jogador1;
    ImageView jogador2;

    ImageButton botaoPedra;
    ImageButton botaoTesoura;
    ImageButton botaoPapel;

    Animation some;
    Animation aparece;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jogador1 = findViewById(R.id.jogador1);
        jogador2 = findViewById(R.id.jogador2);

        botaoPapel = findViewById(R.id.botaoPapel);
        botaoTesoura = findViewById(R.id.botaoTesoura);
        botaoPedra = findViewById(R.id.botaoPedra);

        some = new AlphaAnimation(1,0);
        aparece = new AlphaAnimation(0,1);

        some.setDuration(1500);
        aparece.setDuration(200);

        some.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                jogador2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                jogador2.setVisibility(View.INVISIBLE   );
                jogador2.startAnimation(aparece);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        aparece.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                jogador2.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                jogador2.setVisibility(View.VISIBLE   );
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



        botaoPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogador1.setScaleX(-1f);
                jogador1.setImageResource(R.drawable.pedra);
                jogador2.setImageResource(R.drawable.interrogacao);
            }
        });

        botaoPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogador1.setScaleX(-1f);
                jogador1.setImageResource(R.drawable.papel);
                jogador2.setImageResource(R.drawable.interrogacao);
            }
        });

        botaoTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogador1.setScaleX(-1f);
                jogador1.setImageResource(R.drawable.tesoura);
                jogador2.setImageResource(R.drawable.interrogacao);
            }
        });



    }

}
