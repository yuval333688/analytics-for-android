package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.analyticslibrary.Analytics;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       findView();
       initViews();

    }


    private void findView() {
        textView = findViewById(R.id.Textview);
    }
    private void initViews() {
        Analytics.getNamesFromServer(new Analytics.CallBack() {
            @Override
            public void onResult(List<String> names) {
                Log.d("MainActivity", "Received names: " + names);
                textView.setText("Names: " + names.toString());
            }
        }, Analytics.Gender.female);
    }

}