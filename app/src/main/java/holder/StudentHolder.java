package holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import activity.studentdemo.R;

/**
 * Created by Thinkpad on 8/13/2017.
 */

public class StudentHolder extends RecyclerView.ViewHolder {

    public TextView tvName;
    public TextView tvPhone;
    public ImageView ivSex;
    public LinearLayout llRowStudent;

    public StudentHolder(View itemView) {
        super(itemView);

        tvName = (TextView) itemView.findViewById(R.id.tv_name_student);
        tvPhone = (TextView) itemView.findViewById(R.id.tv_phone_student);
        ivSex = (ImageView) itemView.findViewById(R.id.iv_sex_student);
        llRowStudent = (LinearLayout) itemView.findViewById(R.id.ll_row_student);
    }
}
