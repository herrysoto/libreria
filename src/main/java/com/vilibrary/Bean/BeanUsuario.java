package com.vilibrary.Bean;

import java.io.Serializable;
import lombok.Data;

@Data
public class BeanUsuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String nombre;
	private String nombres;
	private String apellidos;
	private String apepat;
	private String apemat;
	private String fecNac;
	private String dni;
	private String codigoCargo;
	private String login;
	private String clave;
	private String iniciales;
	private String direccion;
	private String celular;
	private String telefono;
	private String email;
	private String username;
	private String contrasena;
	private String name;
	private double [] data;
	
	public BeanUsuario(String name, double [] data){
		this.name = name;
		this.data = data;
	}
	public BeanUsuario(){
		
	}
}
