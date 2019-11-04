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
        //�������Ȼ��������Լ�newһ����������Ӧ�¼�
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
        //�����adapter��ArrayAdapter��������spinner��ͼ��array-string�ļӹ�����
        // ��adapter��������,�����������Ϊ(MainActivity.this , ����ԭ����Դ�� ���ݼӹ���ʽ�������е�һ��Ԫ�ؾ���һ��spinnerѡ��)
        //��adapter�����ݴ��ݳ�ȥ��spinner��ͼ���ӹ����ˣ�����spinner��ͼ��

        //�������ֽ�spinnner2��Spinner��˳��󶨵���ͼ��spinner2�ҵ������֣�
        //��adapter�󶨵�spinner2��spinner2�ҵ������ݣ�
        //�������Լ�newһ����������Ӧ�¼�
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
