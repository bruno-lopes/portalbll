package com.herokuapp.portalbll.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name = "Usuario", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login"),
})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_USUARIOID_GENERATOR", sequenceName="USUARIO_USUARIO_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_USUARIOID_GENERATOR")
	@Column(name="usuario_id")
	private Long usuarioId;

	@Column(name = "habilitado")
	private Boolean habilitado;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	//bi-directional many-to-one association to Permissao
	@OneToMany(mappedBy="usuario")
	private List<Permissao> permissoes;

	public Usuario() {
	}

	public Long getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Boolean getHabilitado() {
		return this.habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Permissao> getPermissoes() {
		return this.permissoes;
	}

	public void setPermissoes(List<Permissao> permissaos) {
		this.permissoes = permissaos;
	}

}