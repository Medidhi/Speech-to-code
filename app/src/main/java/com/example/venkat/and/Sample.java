package com.example.venkat.and;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

import static com.example.venkat.and.R.id.text;

public class Sample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        BufferedReader reader = null;
        ArrayList<String> s =new ArrayList<String>();

        int t=0;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("sample.txt")));
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                t=1;
                //         s[i]=mLine;
                s.add(mLine);
        }
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Error reading file!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        if(t!=0)
            {

                ListAdapter listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s);
                ListView listView=(ListView)findViewById(R.id.sample_list);
                listView.setAdapter(listAdapter);
            }

        }
ListView listView=(ListView)findViewById(R.id.sample_list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String fl=null;
                String S=parent.getItemAtPosition(position).toString();
             //   Toast.makeText(Sample.this, S, Toast.LENGTH_SHORT).show();


                try {
                    BufferedReader br=new BufferedReader(new InputStreamReader(getAssets().open("INDEX.txt")));


                    String mline;
                    while ((mline=br.readLine())!=null)
                    {
                        if(mline.equals(S))
                        {
                            fl=br.readLine();
                            br.close();
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                fl=fl+".txt";
              //  Toast.makeText(Sample.this, fl, Toast.LENGTH_LONG).show();

                Intent i =new Intent(Sample.this,Disp_code.class);
                i.putExtra("file",fl);
                startActivity(i);



            }
        });
        

    }

}
