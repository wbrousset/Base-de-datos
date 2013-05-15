package com.wbrousset.base_de_datos;

import com.wbrousset.base_de_datos.*;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Aniadir_BaseDatos extends Activity {
	
	public static int resultCode = 10;

	private EditText t_nombre, t_apellido, t_edad;
	private Acceso_BaseDatos data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.proceso_activity);

		data = new Acceso_BaseDatos(this);
		data.abrir();
		
		t_nombre=(EditText)findViewById(R.id.name);	
		t_apellido=(EditText)findViewById(R.id.lastname);
		t_edad=(EditText)findViewById(R.id.age);
		
		findViewById(R.id.agregar).setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				String textoNombre = t_nombre.getText().toString() ;
				String textoApellido = t_apellido.getText().toString() ;
				String textoEdad = t_edad.getText().toString() ;
				
				if(textoNombre.length() != 0 &&
						textoApellido.length() !=0 &&
						textoEdad.length() != 0){
					
					data.Insertar(textoNombre, textoApellido, textoEdad);
					setResult(RESULT_OK);
					finish();
				}
				
				else {
					Toast.makeText(getApplicationContext(),
							"No ha introducido texto", Toast.LENGTH_SHORT).show();
				}
			}
			
		});
		

	}
	
}
