package com.example.fileoutputtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText editText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.edit);
        String input=load();
        if (!TextUtils.isEmpty(input)){
            editText.setText(input);
            editText.setSelection(input.length());
            Toast.makeText(MainActivity.this,"数据已经恢复",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String input=editText.getText().toString();
        save(input);
    }
    public void save(String input){
        FileOutputStream out=null;
        BufferedWriter writer =null;
        try{
            out=openFileOutput("data",MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(input);
        }catch (Exception e){
            e.printStackTrace();

        }
        finally {
            try {
                if (writer!=null){
                    writer.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    public String load(){
        FileInputStream in=null;
        BufferedReader reader=null;
        StringBuffer content=new StringBuffer();
        try {
            in=openFileInput("data");
            reader= new BufferedReader(new InputStreamReader(in));
            String line="";
            while ((line=reader.readLine())!=null){
                content.append(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (reader!=null){
                    reader.close();
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return content.toString();
    }
}
