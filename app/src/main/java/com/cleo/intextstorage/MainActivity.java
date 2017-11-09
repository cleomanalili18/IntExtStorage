package com.cleo.intextstorage;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.et_data);
    }


    public void Next(View view) {
        startActivity(new Intent(this,Main2Activity.class));
    }

    //public void SaveInSharedPrefences (View view) {
       // String text = editText.getText().toString();
        //File dir = getFilesDir();
        //File file = new File(dir,"MyFile6.txt");
        //writeData(file, text);

    //}

    public void SaveInInternalStorage(View view) {
        String text=editText.getText().toString();
        File dir = getFilesDir();
        File file = new File(dir,"MyFile1.txt");
        writeData(file, text);

    }

    public void SaveInInternalCacheStorage(View view) {
        String text=editText.getText().toString();
        File dir = getCacheDir();
        File file = new File(dir,"MyFile2.txt");
        writeData(file, text);

    }

    public void SaveInExternalCacheStorage(View view) {
        String text=editText.getText().toString();
        File dir = getExternalCacheDir();
        File file = new File(dir,"MyFile3.txt");
        writeData(file, text);

    }

    public void SaveInExternalPrivateStorage(View view) {
        String text=editText.getText().toString();
        File dir = getExternalFilesDir("MyDir");
        File file = new File(dir,"MyFile4.txt");
        writeData(file, text);

    }

    public void SaveInExternalPublicStorage(View view) {
        String text=editText.getText().toString();
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(dir,"MyFile5.txt");
        writeData(file, text);

    }

    public void writeData(File file,String text)
    {
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(text.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fileOutputStream!=null)
            {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Toast.makeText(this,"Data saved to "+file.getAbsolutePath(),Toast.LENGTH_LONG).show();

    }
}