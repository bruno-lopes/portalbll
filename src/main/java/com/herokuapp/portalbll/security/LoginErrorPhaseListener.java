package com.herokuapp.portalbll.security;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.herokuapp.portalbll.utils.MessageUtil;

/**
 * 
 * @author bruno
 */
public class LoginErrorPhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent arg0) {
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public void beforePhase(PhaseEvent arg0) {

		Exception e = (Exception) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSessionMap()
				.get(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY);

		if (e instanceof BadCredentialsException) {
			FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.getSessionMap()
					.put(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY,
							null);
			MessageUtil.addErrorMessage("loginForm",
					"Username and/or password invalid.");

		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
