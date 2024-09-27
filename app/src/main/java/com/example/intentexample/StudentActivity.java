package com.example.intentexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StudentActivity extends AppCompatActivity {

    EditText etID;
    EditText etName;
    Button btnSave,btnClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getView();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentInfo = etID.getText().toString() + " - " + etName.getText().toString();

                //put dữ liệu về cho list
                Intent intentResult = new Intent();
                intentResult.putExtra("result",studentInfo);
                //goi phuong thuc setResult đẻ gọi kq trả ề
                setResult(RESULT_OK,intentResult);
                //Đóng student activity và trả về list
                finish();
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void getView(){
        etID = findViewById(R.id.etID);
        etName = findViewById(R.id.etName);
        btnSave = findViewById(R.id.btnSave);
        btnClose = findViewById(R.id.btnClose);
    }
}