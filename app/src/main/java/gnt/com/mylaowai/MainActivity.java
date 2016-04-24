package gnt.com.mylaowai;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView iv,iv1,iv2,iv3,iv4,iv5,iv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //
        iv =(ImageView) findViewById(R.id.ivImg);
        iv1 =(ImageView) findViewById(R.id.ivImg1);
        iv2 =(ImageView) findViewById(R.id.ivImg2);
        iv3 =(ImageView) findViewById(R.id.ivImg3);
        iv4 =(ImageView) findViewById(R.id.ivImg4);
        iv5 =(ImageView) findViewById(R.id.ivImg5);
        iv6 =(ImageView) findViewById(R.id.ivImg6);
        setImage();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setImage(){
        Glide.with(MainActivity.this)
                .load("http://mylaowai.net/images/products/image_567a6bb29003c.png")
                .placeholder(R.mipmap.ic_launcher)
//                .transform(new CircleTransform(MainActivity.this))
                .into(iv);
        Glide.with(MainActivity.this)
                .load("http://mylaowai.net/images/products/image_567a6bb2902e2.png")
                .placeholder(R.mipmap.ic_launcher)
//                .transform(new CircleTransform(MainActivity.this))
                .into(iv1);
        Glide.with(MainActivity.this)
                .load("https://i.ytimg.com/vi/xZV1Oxo45AE/hqdefault.jpg")
                .placeholder(R.mipmap.ic_launcher)
//                .transform(new CircleTransform(MainActivity.this))
                .into(iv2);
        Glide.with(MainActivity.this)
                .load("http://mylaowai.net/images/products/image_567a6bb290496.png")
                .placeholder(R.mipmap.ic_launcher)
//                .transform(new CircleTransform(MainActivity.this))
                .into(iv3);
        Glide.with(MainActivity.this)
                .load("http://mylaowai.net/images/products/image_567a6c0dec172.png")
                .placeholder(R.mipmap.ic_launcher)
//                .transform(new CircleTransform(MainActivity.this))
                .into(iv4);
        Glide.with(MainActivity.this)
                .load("http://mylaowai.net/images/products/image_567a6c0dec499.png")
                .placeholder(R.mipmap.ic_launcher)
//                .transform(new CircleTransform(MainActivity.this))
                .into(iv5);
        Glide.with(MainActivity.this)
                .load("http://mylaowai.net/images/products/image_567a6c0dec6c0.png")
                .placeholder(R.mipmap.ic_launcher)
//                .transform(new CircleTransform(MainActivity.this))
                .into(iv6);
    }
}
