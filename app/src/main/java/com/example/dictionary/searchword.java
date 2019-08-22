package com.example.dictionary;

import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class searchword extends AppCompatActivity
{
    Button button;
    mydatabasehandler handler;
    TextView textView,textView2,textView3;
    AutoCompleteTextView autoCompleteTextView;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchword);
        button=findViewById(R.id.button2);
        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);
        textView=findViewById(R.id.textView2);
        textView2=findViewById(R.id.textView3);
        textView3=findViewById(R.id.textView4);
        arrayList=new ArrayList<>();
        handler=new mydatabasehandler(this);
        ArrayAdapter adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(1);
        Cursor cr=handler.getword();
        while(cr.moveToNext())
        {
            arrayList.add(cr.getString(0));
        }
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String word =autoCompleteTextView.getText().toString();
                record record=handler.getmeaning(word);
                String meaning=record.getMeaning();
                String description=record.getDescription();
                textView.setText(word);
                textView2.setText(meaning);
                textView3.setText(description);
            }
        });
    }
}
