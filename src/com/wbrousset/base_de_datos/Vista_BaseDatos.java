package com.wbrousset.base_de_datos;

import java.util.List;
import com.wbrousset.base_de_datos.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Vista_BaseDatos extends Activity implements OnItemClickListener {
	
	private int requestCode = 1;
	private ListView lInfo;
	private Acceso_BaseDatos data;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.mostrar_activity);

			data = new Acceso_BaseDatos(this);
			data.abrir();
			
			lInfo = (ListView)findViewById(R.id.lista);
			
			List<Informacion_BaseDatos> listaInformacion = data.getAllInformacion();
			ArrayAdapter<Informacion_BaseDatos> adapter = new ArrayAdapter<Informacion_BaseDatos>(this,
					android.R.layout.simple_list_item_1,listaInformacion);
			
			lInfo.setAdapter(adapter);
			lInfo.setOnItemClickListener(this);
		}
	
		public void aniadirInfo(View v){
			
			Intent i = new Intent(this, Aniadir_BaseDatos.class);
			startActivityForResult(i, requestCode);
		}
		
		public void onItemClick(final AdapterView<?> adapterView, View view, final int position, long id){
			
			AlertDialog.Builder builder = new AlertDialog.Builder(this)
			.setTitle("Borrar Usuario")
			.setMessage("¿Desea borrar este Usuario?")
			.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					
					Informacion_BaseDatos info = (Informacion_BaseDatos) adapterView
							.getItemAtPosition(position);
					
					data.borrar(info);
					
					refrescarLista();
					
				}

			})
			
			.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
					return;
				}
			});
			builder.show();	
		}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent dat){
	
	super.onActivityResult(requestCode, resultCode, dat);
	
	if(requestCode == this.requestCode && resultCode == RESULT_OK){
		data.abrir();
		refrescarLista();
	}
}

private void refrescarLista(){
	
	List<Informacion_BaseDatos> listaInformacion = data.getAllInformacion();
	ArrayAdapter<Informacion_BaseDatos> adapter = new ArrayAdapter<Informacion_BaseDatos>(this,
			android.R.layout.simple_list_item_1,listaInformacion);
	
	lInfo.setAdapter(adapter);
}

@Override

protected void onPause(){
	data.cerrar();
	super.onPause();
}

@Override

protected void onResume(){
	data.abrir();
	super.onResume();
}			
		
}
