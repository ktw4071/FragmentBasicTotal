package com.example.ccei.fragmentbasictotal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
    }

    public void callFromFragment(String message){
        Toast.makeText(this, "프래그먼트 직접 호출 ==> " + message, Toast.LENGTH_SHORT).show();
    }
}
