package com.abc.dtos;

import java.util.Set;

public class ContactDto {
	
	private Long id;
	private NameDto name;
	private AddressDto address;
	private Set<PhoneDto> phone;
	private String email;
	
	public ContactDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NameDto getName() {
		return name;
	}

	public void setName(NameDto name) {
		this.name = name;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public Set<PhoneDto> getPhone() {
		return phone;
	}

	public void setPhone(Set<PhoneDto> phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}

