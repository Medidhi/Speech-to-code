package com.example.venkat.and;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class history extends AppCompatActivity {

    private TextView textView;
    private StringBuilder text = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toast.makeText(this, "open", Toast.LENGTH_SHORT).show();
        BufferedReader reader = null;
        ArrayList<String> s =new ArrayList<String>();
     //   String s[]={};
        ListAdapter listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s);
        final ListView listView=(ListView)findViewById(R.id.lst);

        int t=0;






        BufferedReader input = null;
        File file = null;
        try {
            file = new File(getCacheDir(), "MyCache"); // Pass getFilesDir() and "MyFile" to read file

            input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = input.readLine()) != null) {

                text.append(line);
                text.append('\n');            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            listView.setAdapter(listAdapter);
        }













//
//        try {
//            reader = new BufferedReader(
//                    new InputStreamReader(getAssets().open("history.txt")));
//
//
//            String mLine;
//            while ((mLine = reader.readLine()) != null) {
//                t=1;
//                s.add(mLine);
//
//                text.append(mLine);
//                text.append('\n');
//            }
//        } catch (IOException e) {
//            Toast.makeText(getApplicationContext(), "Error reading file!", Toast.LENGTH_LONG).show();
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//
//                }
//            }
//            if(t!=0)
//            {
//
//                listView.setAdapter(listAdapter);
//            }
//
//        }




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(history.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();


            }
        });



    }




}
