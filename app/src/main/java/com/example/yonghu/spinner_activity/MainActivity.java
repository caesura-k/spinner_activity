package com.example.yonghu.spinner_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //method 1:
        //绑定组件，然后监听，以及new一个监听的响应事件
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner_1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        adapterView.getItemAtPosition(i).toString()+" select by spinner1", LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        //method 2:
        //定义叫adapter的ArrayAdapter适配器（spinner视图与array-string的加工厂）
        // 给adapter传递数据,参数可以理解为(MainActivity.this , 数据原料来源， 数据加工方式：数组中的一个元素就是一个spinner选项)
        //将adapter的数据传递出去给spinner视图（加工完了，卖给spinner视图）

        //定义名字叫spinnner2的Spinner，顺便绑定到视图（spinner2找到了名字）
        //将adapter绑定到spinner2（spinner2找到了数据）
        //监听，以及new一个监听的响应事件
        ArrayAdapter<CharSequence> adapter;
        adapter=ArrayAdapter.createFromResource(this,  R.array.spinner2_array,  android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_2);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int positon, long id) {
                Toast.makeText(MainActivity.this,
                        parent.getItemAtPosition(positon).toString()+"select by spinner2", LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });
    }
}
