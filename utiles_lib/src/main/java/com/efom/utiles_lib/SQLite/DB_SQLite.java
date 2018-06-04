package com.efom.utiles_lib.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DB_SQLite extends Constants_SQLite {
    OpenHelper openHelper;
    SQLiteDatabase db;


    public DB_SQLite(Context context) {
        openHelper = OpenHelper.newInstance(context);
    }

    public void openDB(boolean abrirLectura) {
        if (abrirLectura) {
            db = openHelper.getReadableDatabase();
        } else {
            db = openHelper.getWritableDatabase();
        }
    }


    public ArrayList<String[]> getEventos(String fecha) {
        this.openDB(true);
        ArrayList<String[]> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE + " WHERE " + FECHA + " LIKE '%" + fecha + "%';";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                String[] fila = new String[5];
                fila[0] = cursor.getString(0);
                fila[1] = cursor.getString(1);
                fila[2] = cursor.getString(2);
                fila[3] = cursor.getString(3);
                fila[4] = cursor.getString(4);
                list.add(fila);
            } while (cursor.moveToNext());
        }
        db.close();
        return list;
    }
}