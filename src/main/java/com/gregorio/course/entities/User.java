package com.gregorio.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_user") // ANOTATION PARA DIZER AO BANCO DE DADOS QUE É UMA TABELA; pARA NÃO DAR
							// CONFLITO COM PALAVRAS RESERVADAS DO BANCO;
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ID AUTO-INCREMENT
	private Long id;

	private String name;
	private String email;
	private String phone;
	private String password;

	@OneToMany(mappedBy = "client") // ASSOCIAÇÃO UM PARA MUITOS
	@JsonIgnore
	/*
	 * ESSA ANOTATION É PARA O JACSON CHAMAR O JPA, QUE POR SUA VEZ, CHAMAR OS
	 * PEDIDOS ASSOCIADOS AOS USUÁRIOS. AQUI NO USER, TODA VEZ QUE EU CHAMAR NA URL
	 * /ORDERS/1, POR EXEMPLO, VIRÁ UM PEDIDO ASSOCIADO COM UM USUÁRIO; OBS: SE EU
	 * COLOCAR ESSA ANOTATION NA CLASSE USER, TODA VEZ QUE EU CHAMAR NA URL
	 * /USERS/1, POR EXEMPLO, VIRÁ UM USUÁRIO COM TODOS OS SEUS PEDIDOS; PORTANTO,
	 * ESSA ANOTATION É COLOCADA DEPENDENDO DA REGRA DE EXIBIÇÃO ESCOLHIDA.
	 */
	private List<Order> orders = new ArrayList<>(); // ASSOCIATION WITH ORDER;
	// AN USER CAN HAVE MANY ORDERS;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String name, String email, String phone, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
