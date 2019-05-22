package com.example.menu;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Defining Buttons and sending to next page

        Button goatGame = findViewById(R.id.goatButton);
        goatGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, goat_games.class);
                startActivity(intent);
            }
        });

        Button momButton = findViewById(R.id.momButton);
        momButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, mom_games.class);
                startActivity(intent);
            }
        });

        Button supergirlsButton = findViewById(R.id.supergirlsButton);
        supergirlsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, supergirls_games.class);
                startActivity(intent);
            }
        });





    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_about_us:
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://katha.org/contact-us/"));
                startActivity(viewIntent);
                break;

            case R.id.nav_contact_us:
                viewIntent = new Intent("android.intent.action.VIEW",
                        Uri.parse("https://katha.org/who-we-are/"));
                startActivity(viewIntent);
                break;

            case R.id.nav_donate:
                viewIntent = new Intent("android.intent.action.VIEW",
                                Uri.parse("https://katha.org/donate-2/"));
                startActivity(viewIntent);
                break;

            case R.id.nav_play_store:
                viewIntent = new Intent("android.intent.action.VIEW",
                                Uri.parse("https://play.google.com/store?hl=en"));
                startActivity(viewIntent);
                break;


        }
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

}
