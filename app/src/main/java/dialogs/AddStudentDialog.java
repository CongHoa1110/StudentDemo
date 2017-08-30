package dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import activity.studentdemo.R;
import database.StudentDatabase;
import interfaces.ListenerDialogAddStudent;
import model.Student;


public class AddStudentDialog extends Dialog implements View.OnClickListener {

    ListenerDialogAddStudent listenerDialogAddStudent;

    Context context;
    StudentDatabase studentDatabase;

    EditText etNameAddStudent;
    EditText etPhoneAddStudent;
    RadioButton rbMale;
    RadioButton rbFemale;
    Button btnSaveAddStudent;
    Button btnExitAddStudent;

    public AddStudentDialog(Context context) {
        super(context);
        this.context = context;

        setContentView(R.layout.item_add_student_dialog);
        setTitle("Add Student");
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        studentDatabase = new StudentDatabase(context);

        etNameAddStudent = (EditText) findViewById(R.id.et_name_add_student);
        etPhoneAddStudent = (EditText) findViewById(R.id.et_phone_add_student);
        rbMale = (RadioButton) findViewById(R.id.rb_male);
        rbFemale = (RadioButton) findViewById(R.id.rb_female);
        btnSaveAddStudent = (Button) findViewById(R.id.btn_save_add_student_dialog);
        btnExitAddStudent = (Button) findViewById(R.id.btn_exit_add_student_dialog);

        btnExitAddStudent.setOnClickListener(this);
        btnSaveAddStudent.setOnClickListener(this);
    }

    public void setListenerDialogAddStudent(ListenerDialogAddStudent listenerDialogAddStudent) {
        this.listenerDialogAddStudent = listenerDialogAddStudent;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save_add_student_dialog:
                boolean isCheckSex = true;
                if (rbMale.isChecked()) {
                    isCheckSex = true;
                }else {
                    isCheckSex = false;
                }
                Student student = new Student(etNameAddStudent.getText().toString(), etPhoneAddStudent.getText().toString(), isCheckSex);

                if (null != student) {
                    studentDatabase.insertStudent(student);
                }
                listenerDialogAddStudent.afterAddStudent();
                clearText();
                dismiss();
                break;
            case R.id.btn_exit_add_student_dialog:
                dismiss();
                break;
        }
    }

    public void clearText() {
        etNameAddStudent.setText("");
        etPhoneAddStudent.setText("");
    }
}
