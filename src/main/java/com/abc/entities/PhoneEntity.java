package com.abc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="PHONE")
public class PhoneEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String number;
	private String type;
	
	@ManyToOne
	private ContactEntity contactDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ContactEntity getContactDTO() {
		return contactDTO;
	}

	public void setContactDTO(ContactEntity contactDTO) {
		this.contactDTO = contactDTO;
	}
	
	
	
}
