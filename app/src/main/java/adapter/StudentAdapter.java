package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import activity.studentdemo.R;
import holder.StudentHolder;
import model.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentHolder> {

    private Context context;
    private ArrayList<Student> students = new ArrayList<>();
    private LayoutInflater inflater;

    public StudentAdapter(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public StudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = inflater.inflate(R.layout.row_item_student, parent, false);
        StudentHolder studentHolder = new StudentHolder(itemLayoutView);
        return studentHolder;
    }

    @Override
    public void onBindViewHolder(StudentHolder holder, int position) {
        Student student = students.get(position);

        holder.tvName.setText(student.getmName());
        holder.tvPhone.setText(student.getmPhone());

        if (student.isCheck()== true) {
            holder.ivSex.setImageResource(R.drawable.male_black_icon);
        }else {
            holder.ivSex.setImageResource(R.drawable.female_black_icon);
        }
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
