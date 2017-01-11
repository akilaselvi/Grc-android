package freshgrc.android.com.auditgrc.auditeActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import freshgrc.android.com.auditgrc.R;

/**
 * Created by akila on 3/11/16.
 */

public class EntityActivity extends AppCompatActivity {
    public EditText in_name, in_address,in_contact,in_mail;
    private Toolbar toolbar;
    public TextInputLayout txt_name, txt_address,txt_conatct,txt_mail;
    public Button btn_add;
    String Title = "FIXNIX";
    String Tag ="Sucessfully Created Entity";
    protected void onCreate(Bundle SaveInstanceState){
        super.onCreate(SaveInstanceState);
        setContentView(R.layout.activity_entity_add);
        in_name = (EditText)findViewById(R.id.usr_name);
        in_address = (EditText) findViewById(R.id.usr_address);
        in_contact = (EditText)findViewById(R.id.user_contact);
        in_mail = (EditText)findViewById(R.id.user_mail);
        txt_name = (TextInputLayout) findViewById(R.id.username_text_input_layout);
        txt_address =(TextInputLayout)findViewById(R.id.address_text_input_layout);
        txt_conatct =(TextInputLayout)findViewById(R.id.contact_text_input_layout);
        txt_mail = (TextInputLayout)findViewById(R.id.mail_text_input_layout);
        in_name.addTextChangedListener(new MyTextWatcher(in_name));
        in_address.addTextChangedListener(new MyTextWatcher(in_address));
        in_mail.addTextChangedListener(new MyTextWatcher(in_mail));
        in_contact.addTextChangedListener(new MyTextWatcher(in_contact));
        toolbar = (Toolbar) findViewById(R.id.toolbarEntity);
        btn_add =(Button) findViewById(R.id.btn_addNewEntity);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                Notification notify=new Notification.Builder
                        (getApplicationContext()).setContentTitle(Title).setContentText(Tag).setSmallIcon(R.drawable.newlogo).build();

                notify.flags |= Notification.FLAG_AUTO_CANCEL;
                notif.notify(0, notify);
//                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//                Notification notifi = new Notification.Builder(getApplicationContext()).setContentTitle(Title)
//                        .setContentText(Tag).setSmallIcon(R.drawable.newlogo).build();
//                notifi.flags |= Notification.FLAG_AUTO_CANCEL;
//                notificationManager.notifi(0, notifi);

            }
        });

    }

    public void onClick(View v) {
        onBackPressed();

    }


    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.usr_name:
                    if (in_name.getText().length() == 0) {
                        txt_name.setErrorEnabled(true);
                        txt_name.setError("Enter name");
                    } else {
                        txt_name.setErrorEnabled(false);
                    }

                    break;
                case R.id.usr_address:
                    if (in_address.getText().length() == 0) {
                        txt_address.setErrorEnabled(true);
                        txt_address.setError("Enter Address");
                    } else {
                        txt_address.setErrorEnabled(false);
                    }
                    break;
                case R.id.user_contact:
                    if(in_contact.getText().length()==0){
                        txt_conatct.setErrorEnabled(true);
                        txt_conatct.setError("Enter Contact");
                    }
                    else{
                        txt_conatct.setErrorEnabled(false);
                    }
                    break;
                case R.id.user_mail:
                    if( in_mail.getText().length()==0){
                        txt_mail.setErrorEnabled(true);
                        txt_mail.setError("Enter Email");
                    }
                    else{
                        txt_mail.setErrorEnabled(false);
                    }
                    break;

            }
        }
    }
}