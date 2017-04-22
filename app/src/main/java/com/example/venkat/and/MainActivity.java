package com.example.venkat.and;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this);
        builder.setContentTitle("welcome");
        builder.setContentText("safcsaf");
        //Intent i=new Intent(this,)
        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawer, toolbar, R.string.open, R.string.close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    public void clk(View view)
    {
        Intent i=new Intent(this,Generate.class);
        startActivity(i);
    }
    public void Samp(View view)
    {
        Intent i= new Intent(this,Sample.class);
        startActivity(i);
    }

    public void abt(View view)
    {
        Intent i=new Intent(this,Abt.class);
        startActivity(i);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {




        if(item.getItemId()==R.id.rate)
        {
            final Dialog dialog=new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.rate);
            dialog.show();


            Button bt=(Button)dialog.findViewById(R.id.ratesub);
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText e=(EditText)dialog.findViewById(R.id.editText);
                    String cmt=e.getText().toString();
                    RatingBar r=(RatingBar)dialog.findViewById(R.id.ratingBar);
                    int star=(int)r.getRating();
                    int t=10;
                    Toast.makeText(MainActivity.this, ""+star, Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
            });


        }


        if(item.getItemId()==R.id.share)
        {

            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "The link is still under work";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        }




        if(item.getItemId()==R.id.help)
        {
            String number = "1234567890";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" +number));
            try {

                startActivity(intent);
            }finally {
                Toast.makeText(this, "Starting", Toast.LENGTH_SHORT).show();
            };
        }
        return false;
    }
}
