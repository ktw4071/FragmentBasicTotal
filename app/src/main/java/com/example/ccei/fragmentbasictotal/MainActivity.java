package com.example.ccei.fragmentbasictotal;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SListFragment.MessageCallBack{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            FBundleFragment f = FBundleFragment.newInstance("처음시작", 10);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, f);
            ft.commit();
        }

        Button firstBtn = (Button)findViewById(R.id.firstBundleBtn);
        firstBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FBundleFragment f = FBundleFragment.newInstance("변경", 10);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, f);
                ft.commit();
            }
        });

        Button secondBtn = (Button)findViewById(R.id.secondMessage);
        secondBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SListFragment sf = new SListFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, sf);
                ft.commit();
            }
        });

        Button anotherBtn = (Button) findViewById(R.id.another_btn);
        anotherBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void receiveMessage(String messageToFragment) {
        Toast.makeText(this, "프래그먼트에서 넘어온 메시지 ==> " + messageToFragment, Toast.LENGTH_SHORT).show();
    }

    //프래그먼트에서 직접 호출하는 방법

    public void callFromFragment(String message){
        Toast.makeText(this, "프래그먼트에서 넘어온 메시지 ==> " + message, Toast.LENGTH_SHORT).show();
    }


}
