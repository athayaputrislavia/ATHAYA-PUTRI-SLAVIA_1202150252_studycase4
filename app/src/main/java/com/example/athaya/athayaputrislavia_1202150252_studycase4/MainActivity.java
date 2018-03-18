package com.example.athaya.athayaputrislavia_1202150252_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //membuat aktivitas untuk button listview
    public void list(View view) {
        Intent a = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(a);
    }

    //membuat aktivitas untuk button pencarian gambar
    public void pencarian(View view) {
        Intent a = new Intent(MainActivity.this,Main3Activity.class);
        startActivity(a);
    }
}
