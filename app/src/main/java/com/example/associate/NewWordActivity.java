package com.example.associate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.associate.ArchitectureComponents.WordViewModel;
import com.example.associate.Object.Word;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY =
            "com.example.android.NewWordActivity.ADD";

    private  EditText mEditWordView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        mEditWordView = findViewById(R.id.edit_word);
       final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
              Intent addIntent=new Intent();
              if(TextUtils.isEmpty(mEditWordView.getText().toString())){
                  setResult(RESULT_CANCELED,addIntent);
              }
              else{
                  String word=mEditWordView.getText().toString();
                  addIntent.putExtra(EXTRA_REPLY,word);
                  setResult(RESULT_OK,addIntent);
              }
              finish();
            }

        });

    }
}