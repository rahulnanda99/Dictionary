package com.example.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class addWord1 extends AppCompatActivity
{
    ArrayList<String> arrayList;
    EditText editText,editText2,editText3;
    Button button;
    mydatabasehandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word1);
        editText=findViewById(R.id.editText3);
        editText2=findViewById(R.id.editText);
        editText3=findViewById(R.id.editText2);
        button=findViewById(R.id.button);
        arrayList=new ArrayList<String>();
        handler=new mydatabasehandler(this);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String word=editText.getText().toString();
                String meaning=editText2.getText().toString();
                String description=editText3.getText().toString();
                record record=new record(word,meaning,description);
                handler.addword(record);
                Toast.makeText(addWord1.this, "Saved...", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
