package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import model.Student;
import unity.Constant;

/**
 * Created by Thinkpad on 8/13/2017.
 */

public class StudentDatabase extends SQLiteOpenHelper {

    private Context context;

    public StudentDatabase(Context context) {
        super(context, Constant.DBStudent.DATABASE_NAME, null, Constant.DBStudent.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery = "create table " + Constant.DBStudent.TABLE_NAME + " (" +
                Constant.DBStudent.COLUMN_ID + " integer primary key, " +
                Constant.DBStudent.COLUMN_NAME + " text, " +
                Constant.DBStudent.COLUMN_PHONE + " text, " +
                Constant.DBStudent.COLUMN_SEX + " boolean)";

        sqLiteDatabase.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + Constant.DBStudent.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertStudent(Student student) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.DBStudent.COLUMN_NAME, student.getmName());
        contentValues.put(Constant.DBStudent.COLUMN_PHONE, student.getmPhone());
        contentValues.put(Constant.DBStudent.COLUMN_SEX, student.isCheck());

        sqLiteDatabase.insert(Constant.DBStudent.TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> students = new ArrayList<>();
        String selectQuery = "select * from " + Constant.DBStudent.TABLE_NAME;

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setmName(cursor.getString(cursor.getColumnIndex(Constant.DBStudent.COLUMN_NAME)));
                student.setmPhone(cursor.getString(cursor.getColumnIndex(Constant.DBStudent.COLUMN_PHONE)));
                student.setCheck(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(Constant.DBStudent.COLUMN_SEX))));
                students.add(student);
            }while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return students;
    }

    public int updateStudent(Student student) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.DBStudent.COLUMN_NAME, student.getmName());
        contentValues.put(Constant.DBStudent.COLUMN_PHONE, student.getmPhone());
        contentValues.put(Constant.DBStudent.COLUMN_SEX, student.isCheck());
        return sqLiteDatabase.update(Constant.DBStudent.TABLE_NAME, contentValues, Constant.DBStudent.COLUMN_ID + "=?", new String[]{String.valueOf(student.getmId())});
    }

    public int deleteStudent(Student student) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        int effect = sqLiteDatabase.delete(Constant.DBStudent.TABLE_NAME, Constant.DBStudent.COLUMN_ID + "=?", new String[]{String.valueOf(student.getmId())});
        sqLiteDatabase.close();
        return effect;
    }
}
