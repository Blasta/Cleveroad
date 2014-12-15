package blasta.cleveroad.system.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import blasta.cleveroad.system.database.listeners.OnDBAction;
import blasta.cleveroad.system.model.ImageModel;

/**
 * Created by 1 on 15.12.2014.
 */
public class DBFavorites {
    private final String TABLE_FAVORITES = "favorites";
    private final String URL = "image";
    private final String TITLE = "title";
    private final String THUMBNAIL = "thumbnail";

    private DBFavoritesOpenHelper helper;
    private List<OnDBAction> listeners = new ArrayList<OnDBAction>();

    public DBFavorites(Context context) {
        String DATABASE = "TestAppDataBase";
        helper = new DBFavoritesOpenHelper(context, DATABASE, null, 1);
    }

    public void addImage (ImageModel image){
        ContentValues values = new ContentValues();
        values.put(URL, image.getUrl());
        values.put(TITLE, image.getTitle());
        values.put(THUMBNAIL, image.getThumbnailUrl());

        SQLiteDatabase db = helper.getWritableDatabase();

        long id = db.insert(TABLE_FAVORITES, null, values);
        image.setId(id);
        image.setFavorite(true);

        db.close();
        Log.d("DBFavorites", "Success ading");

        for (OnDBAction action : listeners)
            action.onAdd(image);
    }

    public List<ImageModel> selectAll(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_FAVORITES, null, null, null, null,null,null);
        List<ImageModel>result = cursorToListImages(cursor);
        db.close();
        return result;
    }

    public List<ImageModel>select(int start, int limit){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(false, TABLE_FAVORITES, null, null, null, null,null,null,
                start == 0 ? String.valueOf(limit) : String.format("%s,%s", start, limit));
        List<ImageModel>result = cursorToListImages(cursor);
        db.close();
        return result;
    }

    public void remove (ImageModel model){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(TABLE_FAVORITES, "id=" + model.getId(), null);
        db.close();
        Log.d("DBFavorites", "success removing");
        for (OnDBAction action: listeners)
            action.onRemove(model);
    }

    private List<ImageModel>cursorToListImages(Cursor cursor){
        if (cursor.moveToFirst()){
            List<ImageModel>list = new ArrayList<ImageModel>();
            int columnTitle = cursor.getColumnIndex(TITLE);
            int columnImage = cursor.getColumnIndex(URL);
            int columnThumbnail = cursor.getColumnIndex(THUMBNAIL);
            int columnId = cursor.getColumnIndex("id");

            do {
                ImageModel model = new ImageModel(cursor.getString(columnTitle),
                        cursor.getString(columnImage),
                        cursor.getString(columnThumbnail));
                model.setId(cursor.getLong(columnId));
                model.setFavorite(true);
                list.add(model);
            }while (cursor.moveToNext());
            return list;

            }
        return null;

        }

    public void addActionListener(OnDBAction action){
        listeners.add(action);
    }

    }



























