package com.gft.casadeeventos.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@NotEmpty(message="Insira o nome do evento.")
	@Size(max = 100, message = "O evento não pode ter mais de 100 caracteres.")
	private String nome;
	
	@NotNull(message="A capacidade não pode ser zero.")
	@DecimalMax(value="60001", message="A capacidade não pode passar de 60 mil pessoas.")
	@DecimalMin(value="9", message="A capacidade não pode ser menos que 10 pessoas.")
	private BigInteger capacidade;

	@NotNull(message="Insira a data do evento.")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@NotNull(message="Insira o preço do ingresso.")
	@DecimalMin(value ="0.01", message="O preço não pode ser 0 (zero).")
	@DecimalMax(value="4001.00", message="O preço máximo deve ser de 4000 reais.")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal preco;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigInteger getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(BigInteger capacidade) {
		this.capacidade = capacidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
	
	
	
	
}
