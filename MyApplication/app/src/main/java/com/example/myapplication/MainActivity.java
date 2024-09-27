package com.example.myapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    AutoCompleteTextView autoText;
    final  String cities [] = {"Hanoi", "Hai Phong","Nha Trang", "Nam Dinh"};
    ArrayAdapter<String> adapter;
    TextView txtDate;
    Calendar c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
//        showAutoText();
//        showListCitiesName();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void showProgress(){
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();


    }

    private void showAutoText(){
        autoText = findViewById(R.id.actvAutoText);
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line,cities);
        autoText.setAdapter(adapter);
    }

//    private void showListCitiesName(){
//        adapter = new ArrayAdapter<>(MainActivity);
//        Lis
//    }
    public void onSelectDate(View view) {
        //Thực hiện xử lý chọn date ở đây
        int mYear = c.get(Calendar.YEAR);
        int mMoth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


//        DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
//                txtDate = findViewById(R.id.txtDate);
//                txtDate.setText(dayofmonth + " / " + month + " / " + year);
//            }
//        })
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}