package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText NameFileField;
    private TextView textView;
    private Button button;
    private String NameFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NameFileField = (EditText) findViewById(R.id.NameFileField);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        NameFile = NameFileField.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateFile();
            }
        });
    }
    private void  CreateFile(){
        try {

            FileWriter fileWriter = new FileWriter(NameFile);
            fileWriter.write("");
            fileWriter.close();

        }catch (Exception exception){
            textView.setText("Error");
            exception.printStackTrace();
        }
    }
}