package com.efom.utiles_lib;

public class Constants_SQLite {
    public final static String DB_NAME = "name_db";
    public final static String TABLE = "name_table";


    public final static String ID = "id";
    public final static String TITULO = "titulo";
    public final static String DESCRIPCION = "descripcion";
    public final static String FECHA = "fecha";
    public final static String HORA = "hora";

    //SELECT strftime('%Y-%m-%d %H:%M:%S', date('now'))
    public final static String CREATE_TABLE = "CREATE TABLE "+TABLE +" ("
            +ID+" INTEGER, "
            +TITULO+" TEXT, "
            +DESCRIPCION+" TEXT, "
            +FECHA+" TEXT, "
            +HORA+" TEXT)";
}
