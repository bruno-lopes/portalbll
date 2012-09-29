package com.herokuapp.portalbll.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_permissao database table.
 * 
 */
@Entity
@Table(name="tipo_permissao")
public class TipoPermissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_PERMISSAO_TIPOPERMISSAOID_GENERATOR", sequenceName="TIPO_PERMISSAO_TIPO_PERMISSAO_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_PERMISSAO_TIPOPERMISSAOID_GENERATOR")
	@Column(name="tipo_permissao_id")
	private Long tipoPermissaoId;

	@Column(name="nome_tipo_permissao")
	private String nomeTipoPermissao;

	//bi-directional many-to-one association to Permissao
	@OneToMany(mappedBy="tipoPermissao")
	private List<Permissao> permissaos;

	public TipoPermissao() {
	}

	public Long getTipoPermissaoId() {
		return this.tipoPermissaoId;
	}

	public void setTipoPermissaoId(Long tipoPermissaoId) {
		this.tipoPermissaoId = tipoPermissaoId;
	}

	public String getNomeTipoPermissao() {
		return this.nomeTipoPermissao;
	}

	public void setNomeTipoPermissao(String nomeTipoPermissao) {
		this.nomeTipoPermissao = nomeTipoPermissao;
	}

	public List<Permissao> getPermissaos() {
		return this.permissaos;
	}

	public void setPermissaos(List<Permissao> permissaos) {
		this.permissaos = permissaos;
	}

}