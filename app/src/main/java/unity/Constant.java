package unity;

/**
 * Created by Thinkpad on 8/13/2017.
 */

public class Constant {

    public static class DBStudent {
        public static final String DATABASE_NAME = "my_student_demo.sqlite";
        public static final int DATABASE_VERSION = 1;

        public static final String TABLE_NAME = "student_demo";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_SEX = "sex";
    }

    public static class State {
        public static final String TAG_DB_STUDENT = "tag_db_student";
        public static final String TAG_MAIN_ACTIVITY = " tag_main_activity";
    }
}
