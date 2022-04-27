package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
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

    public void CreateFile() {
        try {
            File Directory = new File(Environment.getDownloadCacheDirectory(), "DirectoryFile");
            if (!Directory.exists()) {
                Directory.mkdir();
            }

            FileWriter fileWriter = new FileWriter("DirectoryFile/" + NameFile);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException ioException) {
            {
                textView.setText("Error");
                ioException.printStackTrace();
            }
        }
    }
}