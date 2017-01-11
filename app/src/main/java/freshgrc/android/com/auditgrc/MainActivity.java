package freshgrc.android.com.auditgrc;

import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view) ;

//        View headerview = mNavigationView.getHeaderView(0);
//        ImageView drawerimage = (ImageView)findViewById(R.id.profile_image);
//        TextView drawername = (TextView) findViewById(R.id.users_name);
//        TextView draweremail = (TextView)findViewById(R.id.users_mail);
//        drawerimage.setImageResource(R.drawable.rahman);
//        drawername.setText("AkilaParthi");
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        String storedusername = pref.getString("username", null);
        String storeusermail = pref.getString("usermail",null);
        View nav_header = LayoutInflater.from(this).inflate(R.layout.drawer_header,null);
        ((TextView)nav_header.findViewById(R.id.users_name)).setText(storedusername);
        ((TextView)nav_header.findViewById(R.id.users_mail)).setText(storeusermail);

        ((ImageView)nav_header.findViewById(R.id.profile_image)).setImageResource(R.drawable.newlogo);
        mNavigationView.addHeaderView(nav_header);

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.frame_container,new Dashboard()).commit();

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();

                if (menuItem.getItemId() == R.id.nav_item_dashboard) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_container,new Dashboard()).commit();
                }
                if (menuItem.getItemId() == R.id.nav_item_config) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_container,new ConfigureNavigation()).commit();
                }
                if(menuItem.getItemId() == R.id.nav_item_audit) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_container, new AuditeNavigation()).commit();
                }
//
//                if(menuItem.getItemId()==R.id.nav_item_logout){
//                    Intent intHome = new Intent(MainActivity.this,Decision.class);
//                    startActivity(intHome);
//                    finish();
//                }


                return false;
            }

        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}