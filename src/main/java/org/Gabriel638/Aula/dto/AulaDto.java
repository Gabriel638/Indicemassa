package org.Gabriel638.Aula.dto;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.Gabriel638.Aula.entity.Aula;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AulaDto {
	private int id;
	private String nome;
	private String descricao;
	private String ementa;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataCadastro;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataInicio;
	private float valor;
	
	public AulaDto(Aula produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.ementa = produto.getEmenta();
		this.dataCadastro = produto.getDataCadastro();
		this.dataInicio = produto.getDataInicio();
		this.valor = produto.getValor();
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getEmenta() {
		return ementa;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public float getValor() {
		return valor;
	}
	
	
	public static List<AulaDto> converter(List<Aula> produtos){
		return produtos.stream().map(AulaDto::new).collect(Collectors.toList());
		//return produtos.map(ProdutoDto::new);
	}


}
