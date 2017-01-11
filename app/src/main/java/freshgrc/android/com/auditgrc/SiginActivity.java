package freshgrc.android.com.auditgrc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by akila on 15/12/16.
 */

public class SiginActivity extends AppCompatActivity {
    public Button btn_sigin;
    protected void onCreate(Bundle SaveInstanceState){
        super.onCreate(SaveInstanceState);
        setContentView(R.layout.activity_sigin);
        btn_sigin = (Button)findViewById(R.id.button_sigin);
        btn_sigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SiginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
