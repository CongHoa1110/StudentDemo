package activity.studentdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import adapter.StudentAdapter;
import database.StudentDatabase;
import dialogs.AddStudentDialog;
import interfaces.ListenerDialogAddStudent;
import model.Student;

public class MainActivity extends AppCompatActivity implements ListenerDialogAddStudent {

    private RecyclerView rvStudent;
    private ImageView ivAddStudent;

    private StudentDatabase studentDatabase;
    private StudentAdapter studentAdapter;
    private ArrayList<Student> students;
    private AddStudentDialog addStudentDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        setAdapter();

        addStudentDialog = new AddStudentDialog(MainActivity.this);
        addStudentDialog.setListenerDialogAddStudent(this);

        ivAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStudentDialog.show();
            }
        });
    }

    public void initUI() {
        rvStudent = (RecyclerView) findViewById(R.id.rv_student);
        ivAddStudent = (ImageView) findViewById(R.id.iv_add_student);
    }

    public void setAdapter() {
        studentDatabase = new StudentDatabase(MainActivity.this);
        rvStudent.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        students = studentDatabase.getAllStudent();
        if (null == studentAdapter) {
            studentAdapter = new StudentAdapter(MainActivity.this, students);
            rvStudent.setAdapter(studentAdapter);
        }else {
            studentAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void afterAddStudent() {
        students.clear();
        students.addAll(studentDatabase.getAllStudent());
        studentAdapter.notifyDataSetChanged();
    }
}
