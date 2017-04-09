package paulosalvatore.com.br.dadoandroid;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

	private ImageView ivDado1;
	private ImageView ivDado2;

	private TextView tvPlayerName;

	private TextView tvWin;
	private TextView tvSpare;
	private TextView tvLose;

	private int totalVitoria = 0;
	private int totalEmpate = 0;
	private int totalDerrota = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);

		ivDado1 = (ImageView) findViewById(R.id.ivDado1);
		ivDado2 = (ImageView) findViewById(R.id.ivDado2);

		tvPlayerName = (TextView) findViewById(R.id.tvPlayerName);

		tvWin = (TextView) findViewById(R.id.tvWin);
		tvSpare = (TextView) findViewById(R.id.tvSpare);
		tvLose = (TextView) findViewById(R.id.tvLose);

		jogar();
	}

	public void play (View v)
	{
		jogar();
	}

	void jogar()
	{
		tvPlayerName.setText("Nome: " + getIntent().getStringExtra("PLAYER"));

		int jogada1 = pegarJogada();
		int jogada2 = pegarJogada();

		ivDado1.setImageDrawable(ContextCompat.getDrawable(this, pegarDado(jogada1)));
		ivDado2.setImageDrawable(ContextCompat.getDrawable(this, pegarDado(jogada2)));

		if (jogada1 > jogada2)
			totalVitoria++;
		else if (jogada1 < jogada2)
			totalDerrota++;
		else if (jogada1 == jogada2)
			totalEmpate++;

		exibirStatus();
	}

	int pegarJogada()
	{
		Random random = new Random();
		int numero = random.nextInt(6) + 1;

		return numero;
	}

	int pegarDado(int numero)
	{
		if (numero == 1)
			return R.drawable.dado_1;
		else if (numero == 2)
			return R.drawable.dado_2;
		else if (numero == 3)
			return R.drawable.dado_3;
		else if (numero == 4)
			return R.drawable.dado_4;
		else if (numero == 5)
			return R.drawable.dado_5;
		else
			return R.drawable.dado_6;
	}

	void exibirStatus()
	{
		tvWin.setText(String.format(Locale.US, "%d", totalVitoria));
		tvLose.setText(String.format(Locale.US, "%d", totalDerrota));
		tvSpare.setText(String.format(Locale.US, "%d", totalEmpate));
	}
}
