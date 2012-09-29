package com.herokuapp.portalbll.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the permissao database table.
 * 
 */
@Entity
public class Permissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERMISSAO_PERMISSAOID_GENERATOR", sequenceName="PERMISSAO_PERMISSAO_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERMISSAO_PERMISSAOID_GENERATOR")
	@Column(name="permissao_id")
	private Long permissaoId;

	//bi-directional many-to-one association to TipoPermissao
	@ManyToOne
	@JoinColumn(name="tipo_permissao_id")
	private TipoPermissao tipoPermissao;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public Permissao() {
	}

	public Long getPermissaoId() {
		return this.permissaoId;
	}

	public void setPermissaoId(Long permissaoId) {
		this.permissaoId = permissaoId;
	}

	public TipoPermissao getTipoPermissao() {
		return this.tipoPermissao;
	}

	public void setTipoPermissao(TipoPermissao tipoPermissao) {
		this.tipoPermissao = tipoPermissao;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}