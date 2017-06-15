package com.vilibrary.utils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class BaseAction extends DispatchAction {

	protected transient final Log logger = LogFactory.getLog(getClass());

	/*
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		try{
			//-- Variables locales
			HttpSession session = request.getSession();
			//Si la session es nueva es que expiro la session
			if(session != null && !session.isNew()){
			}else{
				logger.info("Entró a BaseAction - execute - Sesión Expirada.");
				request.setAttribute("msg", "Sesión Expirada.");
				return mapping.findForward("global.sessionExpiro");
			} 
			
			
		}catch (Exception e) {
				
		}
		return super.execute(mapping, form, request, response);
	}
	*/
	
	// Método auxiliar para obtener un objeto de la sesión por su nombre.
    protected Object getSessionObject(HttpServletRequest req, String attrName){
        Object sessionObj = null;
        HttpSession session = req.getSession(false);

        if (session != null)
        {
            sessionObj = session.getAttribute(attrName);
        }

        return sessionObj;
    }

    // Obtenemos el contenedor del usuario que está en la sesión.
    protected UserContainer getUserContainer(HttpServletRequest request){
        UserContainer userContainer = (UserContainer)getSessionObject(request, "UserContainer");

        // Creamos un UserContainer para este usuario si no existe ...
        if(userContainer == null)
        {
            userContainer = new UserContainer();

            HttpSession session = request.getSession(true);
            session.setAttribute("UserContainer", userContainer);
        }

        return userContainer;
    }

    // Obtenemos un objeto del contexto de la aplicación por su nombre.
    protected Object getApplicationObject(String attrName){
        return servlet.getServletContext().getAttribute(attrName);
    }
}
