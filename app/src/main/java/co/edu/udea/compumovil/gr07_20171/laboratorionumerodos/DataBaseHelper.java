package co.edu.udea.compumovil.gr07_20171.laboratorionumerodos;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jeniffer Acosta on 24/03/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "Lab2Activities.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME_USER = "user";
    public static final String USER_USERNAME = "userName";
    public static final String USER_PASSWORD = "password";
    public static final String USER_NAME = "name";
    public static final String USER_EMAIL = "email";
    public static final String USER_AGE = "age";
    public static final String USER_PHOTO = "photo";

    SQLiteDatabase db;
    DataBaseHelper dbHelper;

    public static final String TABLE_CREATE = "create table " + "user" +
            "( " + "userName" + " text primary key," + "password, name text, email text, age text, photo text); ";

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public DataBaseHelper open() throws SQLException{
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public void insertUser(String userName, String name, String password, String email, String age) {
        //db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        /*values.put(USER_USERNAME, user.getUserName());
        values.put(USER_PASSWORD, user.getPassword());
        values.put(USER_NAME, user.getName());
        values.put(USER_EMAIL, user.getEmail());
        values.put(USER_AGE, user.getAge());
        values.put(USER_PHOTO, user.getPhoto());*/

        values.put(USER_USERNAME, userName);
        values.put(USER_PASSWORD, name);
        values.put(USER_NAME, password);
        values.put(USER_EMAIL, email);
        values.put(USER_AGE, age);
        db.insert(TABLE_NAME_USER, null, values);
        db.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        //this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME_USER;
        db.execSQL(query);
        this.onCreate(db);
    }
}


