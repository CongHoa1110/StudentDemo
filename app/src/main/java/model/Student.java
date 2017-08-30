package model;

/**
 * Created by Thinkpad on 8/13/2017.
 */

public class Student {

    private String mId;
    private String mName;
    private String mPhone;
    private boolean isCheck;

    public Student() {
    }

    public Student(String mName, String mPhone) {
        this.mName = mName;
        this.mPhone = mPhone;
    }

    public Student(String mName, String mPhone, boolean isCheck) {
        this.mName = mName;
        this.mPhone = mPhone;
        this.isCheck = isCheck;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
