package com.challenge.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase que representa entidades de Affiliate
 *
 * @author edinson Stiben Sinitave Marin - stivennevits16@gmail.com
 * @version 1.0.0 
 * @since 1.0.0
 */

@Data
@Entity
@Table(name = "affiliates", uniqueConstraints = {@UniqueConstraint(columnNames = {"mail"})})
@AllArgsConstructor
@NoArgsConstructor
public class Affiliate implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador de la tupla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * Nombre del affiliate
     */
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    /**
     * Edad del affiliate
     */
    @Column(name = "age", nullable = false)
    private Integer age;

    /**
     * Email del affiliate
     */
    @Column(name = "mail", nullable = false)
    private String mail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}
