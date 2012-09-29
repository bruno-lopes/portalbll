package com.herokuapp.portalbll.utils;



import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
*
* @author bruno
*/
public class MessageUtil {

    public static void addErrorMessage(String componentID, String message) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(componentID, facesMessage);
    }

    public static void addSuccessMessage(String componentID, String message) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(componentID, facesMessage);
    }
}

