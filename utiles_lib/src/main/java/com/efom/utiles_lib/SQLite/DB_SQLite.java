package com.efom.utiles_lib.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.database.DatabaseUtils;
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

    public ArrayList<String[]> select(String fecha) {
        openDB(true);
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

    public boolean existe(int idResultado, int tipoRequest) {
        openDB(true);
        boolean bool = false;
        int i = (int) DatabaseUtils.longForQuery(db, "SELECT count("+ID+") FROM "+ TABLE
                + " WHERE "+ID+" = "+idResultado+" AND "+FECHA+" = "+tipoRequest+";", null);
        if (i != 0) {
            bool = true;
        }
        db.close();
        return bool;
    }


    public int insert(int titulo, String descripcion, int fecha) {
        openDB(false);
        ContentValues contenedor = new ContentValues();
        contenedor.put(TITULO, titulo);
        contenedor.put(DESCRIPCION, descripcion);
        contenedor.put(FECHA, fecha);
        int retorno = (int) db.insert(TABLE, null, contenedor);
        db.close();
        return retorno;
    }

    public int contar() {
        openDB(true);
        int i = (int) DatabaseUtils.longForQuery(db, "SELECT count(*) FROM "+TABLE, null);
        db.close();
        return i;
    }

    public int update(String id, int tipo, int valorDos){
        openDB(false);
        ContentValues contenedor = new ContentValues();
        contenedor.put(FECHA, valorDos);
        String WHERE = ID+ " = "+id+" AND "+tipo+" = "+tipo;
        int retorno = 0;
        retorno = db.update(TABLE, contenedor, WHERE, null);
        db.close();
        return retorno;
    }

    public void deletTables() {
        openDB(false);
        String requeste = "DELETE FROM " + TABLE;
        db.execSQL(requeste);
        db.close();
    }
}