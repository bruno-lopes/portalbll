package com.herokuapp.portalbll.managedbeans;

//import br.usp.mavenproject1.util.MessageUtil;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.herokuapp.portalbll.utils.MessageUtil;

/**
 * Classe responsável por tratar o login do usuário
 * 
 * @author bruno
 * 
 */
@ManagedBean(name = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {

	// properties
	private String userId;
	private String password;

	/**
	 * default empty constructor
	 */
	public LoginManagedBean() {
		Exception ex = (Exception) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSessionMap()
				.get(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY);
		if (ex != null) {
			MessageUtil.addErrorMessage("loginForm", ex.getMessage());
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String doLogin() throws IOException {
 		HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();

		try {
			RequestDispatcher dispatcher = httpServletRequest
					.getRequestDispatcher("/j_spring_security_check");
			dispatcher.forward(httpServletRequest, httpServletResponse);
			FacesContext.getCurrentInstance().responseComplete();

		} catch (UsernameNotFoundException ex) {
			MessageUtil.addErrorMessage("loginForm", ex.getMessage());
		} catch (ServletException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (Exception ex) {
			// TODO: handle exception
			MessageUtil.addErrorMessage("loginForm", ex.getMessage());
		}
		
		return null;
	}

	public String doLogout() throws IOException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();

		try {
			RequestDispatcher dispatcher = httpServletRequest
					.getRequestDispatcher("/j_spring_security_logout");
			MessageUtil.addSuccessMessage("loginForm", "Sucessfull logout");
			dispatcher.forward(httpServletRequest, httpServletResponse);
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception ex) {
			MessageUtil.addErrorMessage("loginForm", ex.getMessage());
		}
		return null;
	}

}
