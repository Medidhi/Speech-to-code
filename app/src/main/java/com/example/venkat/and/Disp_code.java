package com.example.venkat.and;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Disp_code extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp_code);
        String file = getIntent().getExtras().getString("file").toString();
       // Toast.makeText(this,file, Toast.LENGTH_SHORT).show();
        //String file="INDEX.txt";
        if (file != "NOTHING.txt") {
            StringBuilder Sb;
            Sb = new StringBuilder();
            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open(file)));

                String mline;
                while ((mline = reader.readLine()) != null) {
                    Sb.append(mline);
                    Sb.append("\n");
                }

                TextView textView = (TextView) findViewById(R.id.cd);
                textView.setText(Sb);

                reader.close();


            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        else {
            TextView textView = (TextView) findViewById(R.id.cd);
            textView.setText("Oops no t found");
        }
    }
}
