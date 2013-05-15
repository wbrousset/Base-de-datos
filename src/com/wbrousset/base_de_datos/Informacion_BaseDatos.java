package com.wbrousset.base_de_datos;

public class Informacion_BaseDatos {
	
	private long id;
	private String nombre;
	private String apellido;
	private String edad;
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id=id;
	}
	
	///////
	
	public String getnombre(){
		return nombre;
	}
	
	public void setnombre(String nombre){
		this.nombre=nombre;
	}
	
	public String toString1(){
		return nombre;
	}
	
	//////
	
	public String getapellido(){
		return apellido;
	}
	
	public void setapellido(String apellido){
		this.apellido=apellido;
	}
	
	public String toString2(){
		return apellido;
	}
	
	//////
	
	public String getedad(){
		return edad;
	}
	
	public void setedad(String edad){
		this.edad=edad;
	}
		
	public String toString3(){
		return edad;
	}

}
