package com.efom.utiles_lib.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenHelper extends SQLiteOpenHelper {


    public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static OpenHelper newInstance(Context context){
        OpenHelper openHelper = new OpenHelper(context,Constants_SQLite.DB_NAME,null,1);
        return  openHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants_SQLite.CREATE_TABLE);
        String insert = "INSERT INTO eventos VALUES (1, 'TITULO-', 'DESCRIPCION-', '2018-06-04', '12:12:10'),(2, 'TITULO-2', 'DESCRIPCION-2', '2018-07-06', '11:15:10');";
        db.execSQL(insert);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
