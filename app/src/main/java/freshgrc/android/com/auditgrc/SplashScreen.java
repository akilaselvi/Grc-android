package freshgrc.android.com.auditgrc;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by akila on 15/12/16.
 */

public class SplashScreen extends Activity {


    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    /** Called when the activity is first created. */
    Thread splashTread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);;
        StartAnimations();
    }
    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout logo =(LinearLayout) findViewById(R.id.activity_splash);
        logo.clearAnimation();
        logo.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.img_splash);
        iv.clearAnimation();
        iv.startAnimation(anim);


        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 2500) {
                        sleep(100);
                        waited += 100;
                    }
//                    Intent intent = new Intent(SplashScreen.this,
//                            Decision.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
//                    SplashScreen.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    final Intent intent;
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
                    final String storedusername = pref.getString("username", null);
                    final String storeuserpsw = pref.getString("userpsw",null);
                    if(storedusername!=null && !storedusername.isEmpty()){
                        intent = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(intent);
                        SplashScreen.this.finish();
                    }
                    else {
                        intent = new Intent(SplashScreen.this, SiginActivity.class);
                        startActivity(intent);
                    }

                }

            }
        };
        splashTread.start();

    }
}
