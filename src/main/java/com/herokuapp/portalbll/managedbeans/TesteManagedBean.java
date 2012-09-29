package com.herokuapp.portalbll.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 * ManagedBean de Teste
 * @author blopes
 *
 */
@ManagedBean
@ViewScoped
public class TesteManagedBean implements Serializable{

    public String proximaPagina() {
        
        return "livre/mapa.xhtml?faces-redirect=true";
    }
    
    public String security(){
        return "/paginas/secured/new?faces-redirect=true";
        //return "new";
    }
}
