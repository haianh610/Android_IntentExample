package com.example.intentexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListStudent extends AppCompatActivity {

    Button btnInsertStudent;
    ListView lvStudent;

    ArrayList<String> lsStudent = new ArrayList<>();
    ArrayAdapter<String> adapter;
    final static int REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_student);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getView();
        btnInsertStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentIns = new Intent(ListStudent.this,StudentActivity.class);
//                startActivityForResult(intentIns,REQUEST_CODE);
                startInsStudentForResult.launch(intentIns);
            }
        });
    }

    private void bindDataListView(){
        adapter = new ArrayAdapter<>(ListStudent.this, android.R.layout.simple_list_item_1,lsStudent);
        lvStudent.setAdapter(adapter);
    }

    ActivityResultLauncher<Intent> startInsStudentForResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //Xử lý sự kiện trả về ở đây
                    if (result.getResultCode() == RESULT_OK){
                        String stInfo = result.getData().getStringExtra("result");
                        lsStudent.add(stInfo);
                        bindDataListView();
                        adapter.notifyDataSetChanged();
                    }
                }
            });

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        //xử lý kết quả trả về
//        if (resultCode == RESULT_OK){
//            //Lấy dữ liệu trả về và add và lvStudent
//            String stInfo = data.getStringExtra("result");
//            lsStudent.add(stInfo);
//            adapter.notifyDataSetChanged();
//        }
//    }

    private void getView(){
        btnInsertStudent = findViewById(R.id.btnInsertStudent);
        lvStudent = findViewById(R.id.lvStudents);
    }
}