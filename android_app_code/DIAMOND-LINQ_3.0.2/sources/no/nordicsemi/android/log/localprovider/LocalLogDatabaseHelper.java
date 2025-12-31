package no.nordicsemi.android.log.localprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

class LocalLogDatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_LOG = "CREATE TABLE log(_id INTEGER PRIMARY KEY AUTOINCREMENT, session_id INTEGER NOT NULL, time INTEGER NOT NULL, level INTEGER NOT NULL, data TEXT NOT NULL, FOREIGN KEY(session_id) REFERENCES sessions(_id));";
    private static final String CREATE_LOG_SESSIONS = "CREATE TABLE sessions(_id INTEGER PRIMARY KEY AUTOINCREMENT, key TEXT NOT NULL, name TEXT, created_at INTEGER NOT NULL);";
    private static final String DATABASE_NAME = "local_log.db";
    private static final int DATABASE_VERSION = 1;
    private static LocalLogDatabaseHelper sInstance;

    public interface LogColumns {
        public static final String CONCRETE_DATA = "log.data";
        public static final String CONCRETE_ID = "log._id";
        public static final String CONCRETE_LEVEL = "log.level";
        public static final String CONCRETE_SESSION_ID = "log.session_id";
        public static final String CONCRETE_TIME = "log.time";
    }

    public interface Projections {
        public static final String[] ID = {"_id"};
        public static final String[] MAX_NUMBER = {"MAX(number)"};
    }

    public interface SessionColumns {
        public static final String CONCRETE_APPLICATION_ID = "sessions.application_id";
        public static final String CONCRETE_CREATED_AT = "sessions.created_at";
        public static final String CONCRETE_DESCRIPTION = "sessions.description";
        public static final String CONCRETE_ID = "sessions._id";
        public static final String CONCRETE_KEY = "sessions.key";
        public static final String CONCRETE_MARK = "sessions.mark";
        public static final String CONCRETE_NAME = "sessions.name";
        public static final String CONCRETE_NUMBER = "sessions.number";
    }

    public interface Tables {
        public static final String LOG = "log";
        public static final String LOG_SESSIONS = "sessions";
    }

    private LocalLogDatabaseHelper(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
    }

    static synchronized LocalLogDatabaseHelper getInstance(Context context) {
        LocalLogDatabaseHelper localLogDatabaseHelper;
        synchronized (LocalLogDatabaseHelper.class) {
            if (sInstance == null) {
                sInstance = new LocalLogDatabaseHelper(context, DATABASE_NAME, 1);
            }
            localLogDatabaseHelper = sInstance;
        }
        return localLogDatabaseHelper;
    }

    private void initializeAutoIncrementSequences(SQLiteDatabase sQLiteDatabase) {
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(CREATE_LOG_SESSIONS);
        arrayList.add(CREATE_LOG);
        for (String execSQL : arrayList) {
            sQLiteDatabase.execSQL(execSQL);
        }
        initializeAutoIncrementSequences(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
