package com.vilibrary.Actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.vilibrary.utils.BaseAction;
import com.vilibrary.utils.LocationUtils;

public class ActionBienvenido extends BaseAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		new LocationUtils().setLocation(request);
		//String nameProyecto = request.getContextPath().substring(1);
		//if (nameProyecto.equalsIgnoreCase("AUTODROMO")) return mapping.findForward("success");
		//else return mapping.findForward("showLite");
		
		int proyectInicia = 1; //1
		String resultado = "";
	
		switch (proyectInicia) {
			case 1 :  resultado = "success"; break;
		} 
		
		return mapping.findForward(resultado);
	}
}
