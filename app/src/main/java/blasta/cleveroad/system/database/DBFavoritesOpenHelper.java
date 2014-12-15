package blasta.cleveroad.system.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 1 on 15.12.2014.
 */
public class DBFavoritesOpenHelper extends SQLiteOpenHelper {


    public DBFavoritesOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table favorites ("
        + "id integer primary key autoincrement,"
        + "title text,"
        + "image text,"
        + "thumbnail text");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
