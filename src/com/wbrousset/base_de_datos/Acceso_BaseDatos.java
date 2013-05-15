package com.wbrousset.base_de_datos;

import java.util.ArrayList;
import java.util.List;
import com.wbrousset.base_de_datos.Informacion_BaseDatos;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Acceso_BaseDatos {

	private SQLiteDatabase BD;
	private Creador_BaseDatos BDHelper;
	
	private String [] columnas = {"_ID", "Nombre", "Apellido", "Edad"};
	
	public Acceso_BaseDatos(Context ctx){
		
		BDHelper = new Creador_BaseDatos(ctx);
	}
	
	public void abrir(){
		
		BD = BDHelper.getWritableDatabase();
	}
	
	public void cerrar(){
		BDHelper.close();
	}
	
	public void Insertar(String nom, String apell, String edad){
		
		ContentValues valores = new ContentValues();
		valores.put("Nombre", nom); 	
		valores.put("Apellido", apell);	 
		valores.put("Edad", edad);		  
		BD.insert("Usuarios", null, valores);
	}
	
	public List<Informacion_BaseDatos> getAllInformacion(){
		
		List<Informacion_BaseDatos> listaInformacion = new ArrayList<Informacion_BaseDatos>();
		
		Cursor cursor = BD.query("Usuarios", columnas, null, null, null, null, null);
		
		cursor.moveToFirst();
		
		while(!cursor.isAfterLast()){
			
			Informacion_BaseDatos nuevaInfo = cursorToInformacion_BaseDatos(cursor);
			listaInformacion.add(nuevaInfo);
			cursor.moveToNext();
		}
		
		cursor.close();
		return listaInformacion;
	}
	
	public void borrar(Informacion_BaseDatos info){
		
		long id = info.getId();
		BD.delete("Usuarios", "_ID"+ "="+id, null);
	}

	private Informacion_BaseDatos cursorToInformacion_BaseDatos(Cursor cursor) {
		
		Informacion_BaseDatos info = new Informacion_BaseDatos();
		info.setId(cursor.getLong(0));
		info.setnombre(cursor.getString(1));
		info.setapellido(cursor.getString(2));
		info.setedad(cursor.getString(3));
		
		return info;
		
	}
	
}