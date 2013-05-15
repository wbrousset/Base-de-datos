package com.wbrousset.base_de_datos;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;

import static android.provider.BaseColumns._ID;	// id de cada registro

public class Creador_BaseDatos  extends SQLiteOpenHelper {
	
	public Creador_BaseDatos(Context ctx){
		
		super(ctx, "Base de Datos - WBrousset", null,1);	
	}	
	
	@Override
	
	public void onCreate(SQLiteDatabase BaseDatos){
		
		final String crear = "CREATE TABLE Usuarios ("+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
				"Nombre TEXT, Apellido TEXT, Edad TEXT);";
		
		BaseDatos.execSQL(crear);
		
	}
	
	@Override
	
	public void onUpgrade(SQLiteDatabase BaseDatos, int versionAnterior, int nuevaVersion){
		
		BaseDatos.execSQL("DROP TABLE IF EXISTS Usuarios"); 
		onCreate(BaseDatos); 
		
	}

}
