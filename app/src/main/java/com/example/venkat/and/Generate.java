package com.example.venkat.and;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Locale;

public class Generate extends AppCompatActivity {
    protected TextView resultTEXT;
    protected String para;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        resultTEXT=(TextView) findViewById(R.id.qs);
        promptSpeechInput();
    }






    public void record_button(View v)
    {
        if(v.getId()==R.id.record_id)
        {
            promptSpeechInput();
        }
    }


    public void promptSpeechInput()
    {

        Intent i= new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, Locale.getDefault());
        i.putExtra(RecognizerIntent.EXTRA_PROMPT,"Question please");
        try {
            startActivityForResult(i, 100);
        }
        catch (ActivityNotFoundException a)
        {
            String qa=a.toString();
            Toast.makeText(this, qa, Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(this, "VOICE RECORDED1", Toast.LENGTH_SHORT).show();
    }

    public void onActivityResult (int request_code,int result_code,Intent i)
    {
        super.onActivityResult(request_code,result_code,i);
        switch(request_code)
        {
            case 100: if(result_code==RESULT_OK &&i!=null)
            {

                ArrayList<String> result=i.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                Toast.makeText(this, "VOICE RECORDED", Toast.LENGTH_SHORT).show();
                resultTEXT.setText(result.get(0));
                para=resultTEXT.getText().toString();


            }break;
        }

    }

    public void generate(View v)
    {
        if(v.getId()==R.id.getcode)
        {

        }
    }


    public void disp(View view)
    {
        TextView textView=(TextView)findViewById(R.id.qs);
        StringBuilder sb=new StringBuilder();
        String s=textView.getText().toString();
        sb.append(s);
        String fl="history.txt";
        textView.setText("Waiting for the question");
        String FILE_NAME = "history.txt";
        try {
            FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.write(s.toString().getBytes());
            fos.close();
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader ;



        String content = "hello world";
        File file1;
        FileOutputStream outputStream;
        try {
            // file = File.createTempFile("MyCache", null, getCacheDir());
            file1 = new File(getCacheDir(), "MyCache");

            outputStream = new FileOutputStream(file1);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }





        String file=null;
        s=s.toLowerCase();
        //Toast.makeText(this, "in this fn", Toast.LENGTH_SHORT).show();
        try {
            bufferedReader =new BufferedReader(new InputStreamReader(getAssets().open("INDEX.txt")));
            String st;
            while ((st=bufferedReader.readLine())!=null)
            {

                if(s.equals(st)==true)
                {
                    file=bufferedReader.readLine();
                  //  Toast.makeText(this, file, Toast.LENGTH_SHORT).show();
                    bufferedReader.close();
                    break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        if(file==null)
        {
            file="NOTHING";
        }
        String a=file+".txt";
        Intent i = new Intent(this,Disp_code.class);
        i.putExtra("file",a);
        startActivity(i);


    }

    public void his(View view)
    {
        Intent i=new Intent(this,history.class);
        startActivity(i);
    }




}
