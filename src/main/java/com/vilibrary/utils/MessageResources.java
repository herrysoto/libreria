package com.vilibrary.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Clase que maneja los recursos de mensajes de la aplicaci�n.
 * @author Victor Sanchez
 *
 */
public class MessageResources extends BaseAction {

	public static org.apache.struts.util.MessageResources message;
	private org.apache.struts.util.MessageResources m;
	
	/**
	 * Constructor predeterminado que utiliza el recurso asignado al momento de acceder al sistema.
	 */
	public MessageResources() {
		this.m = message;
	}
	
	/**
	 * Constructor que recibe un HttpServletRequest como par�metro para utilizarlo en caso el recurso sea nulo.
	 * @param request
	 */
	public MessageResources(HttpServletRequest request) {
		if (message != null) this.m = message; // Si 'message' no es null, reutiliza lo asignado al momento de hacer login
		else this.m = getResources(request); // Si 'message' es null, captura uno nuevo del request, y lo utiliza.
	}
	
	/**
	 * M�todo que retorna un mensaje de acuerdo a la llave provista.
	 * @param key
	 * @return MessageResource.value as String
	 */
	public String getMessage(String key) {
		return m.getMessage(key);
	}
	
	/**
	 * M�todo que retorna un mensaje de acuerdo a la llave provista, adicionalmente env�a 1 par�metro extra, cadena.
	 * @param key
	 * @param arg0
	 * @return MessageResource.value as String
	 */
	public String getMessage(String key, String arg0) {
		return m.getMessage(key, arg0);
	}
	
}
