package com.codelabs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.codelabs.utility.ErrorConstants;

@Entity
@Table(name = "phone")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long key;
	
	@Column(name = "type")
	@NotEmpty(message = ErrorConstants.INVALID_PHONE_TYPE)
	private String type;
	
	@Column(name = "phone_number")
	@NotEmpty(message = ErrorConstants.INVALID_PHONE_NUMBER)
	private String number;
	
	@Column(name = "is_primary")
	private boolean primary;

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
}
