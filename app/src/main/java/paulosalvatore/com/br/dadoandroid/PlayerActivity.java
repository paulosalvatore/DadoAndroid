package paulosalvatore.com.br.dadoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PlayerActivity extends AppCompatActivity {

	private EditText etPlayerName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);

		etPlayerName = (EditText) findViewById(R.id.etPlayerName);
	}

	public void play(View v)
	{
		if (etPlayerName.getText().toString().equals(""))
		{
			Toast.makeText(this, R.string.insert_name, Toast.LENGTH_SHORT).show();
			return;
		}

		Intent telaGame = new Intent(this, GameActivity.class);

		telaGame.putExtra("PLAYER", etPlayerName.getText().toString());

		startActivityForResult(telaGame, 1);
	}
}
