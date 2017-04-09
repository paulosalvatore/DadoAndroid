package paulosalvatore.com.br.dadoandroid;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

	private final int SPLASH_DISPLAY_LENGTH = 5000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);

		carregar();
	}

	void carregar()
	{
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
		anim.reset();

		ImageView iv = (ImageView) findViewById(R.id.splash);

		if (iv != null)
		{
			iv.clearAnimation();
			iv.startAnimation(anim);
		}

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run()
			{
				Intent intent = new Intent(SplashScreen.this, PlayerActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
				SplashScreen.this.finish();
			}
		}, SPLASH_DISPLAY_LENGTH);

	}
}
