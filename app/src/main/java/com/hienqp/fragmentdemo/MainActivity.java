package com.hienqp.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAddA, btnAddB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddA = findViewById(R.id.buttonAddA);
        btnAddB = findViewById(R.id.buttonAddB);

        FragmentA fragmentA = new FragmentA();
        FragmentB fragmentB = new FragmentB();

        /*
        FragmentManager được lấy từ method getSupportFragmentManager trong trường hợp ta đang
        thao tác với Fragment từ API androidx
        tương tự API của FragmentTransaction cũng theo API của FragmentManager
         */
//        FragmentManager fragmentManager = getSupportFragmentManager();

        /*
        FragmentManager được lấy từ method getFragmentManager trong trường hợp ta đang thao tác
        với Fragment từ API android.app
        tương tự API của FragmentTransaction cũng theo API của FragmentManager
         */
        FragmentManager fragmentManager = getFragmentManager();

        /*
        với mỗi sự kiện click Button ta sẽ tạo mới lại FragmentTransaction, vì FragmentTransaction chỉ được
        commit 1 lần, nhưng Button thì được click luân phiên, và ta phải commit luân phiên, nên sẽ xảy ra
        lỗi Exception commit already called nếu dùng 1 FragmentTransaction commit đến lần thứ 2
         */

        btnAddA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // với mỗi sự kiện click Button ta sẽ tạo mới lại FragmentTransaction
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameContent, fragmentA);
                fragmentTransaction.commit();
            }
        });

        btnAddB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // với mỗi sự kiện click Button ta sẽ tạo mới lại FragmentTransaction
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameContent, fragmentB);
                fragmentTransaction.commit();
            }
        });


    }
}