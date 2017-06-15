package com.vilibrary.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.vilibrary.Bean.BeanUsuario;



// Almacena la informaci�n del usuario en su sesi�n.
// Implementa el interfaz HttpSessionBindingListener para que se le notifique
// el timeout y as� pueda liberar los recursos de la sesi�n.

public class UserContainer implements HttpSessionBindingListener {

	private BeanUsuario beanUsuario=null;
	private String perspectivaTaller = null;
	private HashMap<String,String> hmMenuGeneral = null;
	//private String codSucursal = null;
	private String codSucursalTaller = null;
	private String codSucursalAlmacen = null;
	private String codSucursalFacturacion = null;
	private ArrayList lstSucursal = null;
	public  ArrayList lstAmbiente = null;
	//------------------------- 
	public BeanUsuario beanUsuario2 =null;
	public ArrayList lstSucursal2 = null;
	public ArrayList lstAmbiente2 = null;
	//-------------------------

	public UserContainer() {
		super();
        initialize();
	}

	// El contenedor llama a este m�todo cuando comienza la sesi�n.
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

	// El contenedor llama a este m�todo cuando se termina la sesi�n.
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// Liberamos recursos de la sesi�n.
       System.out.println( "Liberando sesi�n...");       
       cleanUp();
	}


	// Inicializaci�n de los datos del usuario en sesi�n.
    private void initialize(){
        // Creamos un nuevo usuario
        beanUsuario = new BeanUsuario();
        perspectivaTaller = new String();
        hmMenuGeneral = new HashMap<String,String>();
        codSucursalTaller = new String();
        codSucursalAlmacen = new String();
        codSucursalFacturacion = new String();
        lstSucursal = new ArrayList();
        lstAmbiente = new ArrayList();
        //-- codSucursal = new String();
        //------------------------------ 
    	beanUsuario2 = new BeanUsuario();
    	lstSucursal2 = new ArrayList();
    	lstAmbiente2 = new ArrayList();
    	//----------------------------

    }


    // Liberamos recursos de la sesi�n.
    public void cleanUp(){
       setUsuario(null);
       //setUsuario2(null);//---
    }

    public void setUsuario(BeanUsuario beanUsuario) {
    	this.beanUsuario= beanUsuario;
    }

    public BeanUsuario getUsuario(){
    	return beanUsuario;
    }
    
	public BeanUsuario getUsuario2(){
		return beanUsuario2;
	}

	public void setUsuario2(BeanUsuario beanUsuario2){
		this.beanUsuario2 = beanUsuario2;
	}

    public void setPerspectivaTaller(String perspectivaTaller){
    	this.perspectivaTaller = perspectivaTaller;
    }

    public String getPerspectivaTaller(){
    	return perspectivaTaller;
    }

	public HashMap<String, String> getHmMenuGeneral() {
		return hmMenuGeneral;
	}

	public void setHmMenuGeneral(HashMap<String, String> hmMenuGeneral) {
		this.hmMenuGeneral = hmMenuGeneral;
	}

	public String getCodSucursalAlmacen() {
		return codSucursalAlmacen;
	}

	public void setCodSucursalAlmacen(String codSucursalAlmacen) {
		this.codSucursalAlmacen = codSucursalAlmacen;
	}

	public String getCodSucursalFacturacion() {
		return codSucursalFacturacion;
	}

	public void setCodSucursalFacturacion(String codSucursalFacturacion) {
		this.codSucursalFacturacion = codSucursalFacturacion;
	}

	public String getCodSucursalTaller() {
		return codSucursalTaller;
	}

	public void setCodSucursalTaller(String codSucursalTaller) {
		this.codSucursalTaller = codSucursalTaller;
	}

	public ArrayList getLstSucursal() {
		return lstSucursal;
	}

	public void setLstSucursal(ArrayList lstSucursal) {
		this.lstSucursal = lstSucursal;
	}

	public ArrayList getLstAmbiente(){
		return lstAmbiente;
	}

	public void setLstAmbiente(ArrayList lstAmbiente){
		this.lstAmbiente = lstAmbiente;
	}

	public ArrayList getLstSucursal2() {
		return lstSucursal2;
	}

	public void setLstSucursal2(ArrayList lstSucursal2) {
		this.lstSucursal2 = lstSucursal2;
	}

	public ArrayList getLstAmbiente2() {
		return lstAmbiente2;
	}

	public void setLstAmbiente2(ArrayList lstAmbiente2) {
		this.lstAmbiente2 = lstAmbiente2;
	}


}
