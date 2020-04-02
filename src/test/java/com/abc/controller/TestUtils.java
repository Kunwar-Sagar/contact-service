package com.abc.controller;

import java.util.HashSet;
import java.util.Set;

import com.abc.dtos.AddressDto;
import com.abc.dtos.ContactDto;
import com.abc.dtos.NameDto;
import com.abc.dtos.PhoneDto;

public class TestUtils {

	public static ContactDto dummyContact() {
		ContactDto c = new ContactDto();
		c.setEmail("yadav.bastola@yahoo.com");
		c.setId(1l);

		NameDto name = new NameDto();
		name.setFirst("Yadav");
		name.setLast("Banstola");
		c.setName(name);

		Set<PhoneDto> phoneDtos = new HashSet<>();
		PhoneDto homePhone = new PhoneDto();
		homePhone.setNumber("302-532-9427");
		homePhone.setType("mobile");

		PhoneDto workPhone = new PhoneDto();
		homePhone.setNumber("302-611-9148");
		homePhone.setType("home");
		phoneDtos.add(homePhone);
		phoneDtos.add(workPhone);

		c.setPhone(phoneDtos);

		AddressDto addressDto = new AddressDto();
		addressDto.setStreet("2751 prosperity ave");
		addressDto.setCity("Cannon");
		addressDto.setState("Delaware");
		addressDto.setZip(19797);
		c.setAddress(addressDto);

		return c;
	}
	
	public static ContactDto dummyContactResponse() {
		ContactDto c = new ContactDto();
		c.setEmail("yadav.bastola@yahoo.com");
		c.setId(1l);

		NameDto name = new NameDto();
		name.setFirst("Yadav");
		name.setLast("Banstola");
		c.setName(name);

		Set<PhoneDto> phoneDtos = new HashSet<>();
		PhoneDto homePhone = new PhoneDto();
		homePhone.setNumber("302-532-9427");
		homePhone.setType("mobile");

		PhoneDto workPhone = new PhoneDto();
		homePhone.setNumber("302-611-9148");
		homePhone.setType("home");
		phoneDtos.add(homePhone);
		phoneDtos.add(workPhone);

		c.setPhone(phoneDtos);

		AddressDto addressDto = new AddressDto();
		addressDto.setStreet("2751 prosperity ave");
		addressDto.setCity("Cannon");
		addressDto.setState("Delaware");
		addressDto.setZip(19797);
		c.setAddress(addressDto);

		return c;
	}

	public static String dummyContactresponse() {

		return "{\n" + "\"id\": 1,\n" + "\"name\": {\n" + "\"first\": \"Yadav\",\n" + "\"last\": \"Bastola\",\n"
				+ "\"middle\": \"Francis\"\n" + "},\n" + "\"address\": {\n" + "\"street\": \"2751 prosperity ave\",\n"
				+ "\"city\": \"Cannon\",\n" + "\"state\": \"Delaware\",\n" + "\"zip\": 19797\n" + "},\n"
				+ "\"phone\": [\n" + "{\n" + "\"number\": \"302-532-9427\",\n" + "\"type\": \"mobile\"\n" + "},\n"
				+ "{\n" + "\"number\": \"302-611-9148\",\n" + "\"type\": \"home\"\n" + "}\n" + "],\n"
				+ "\"email\": \"yadav.gilkey@yahoo.com\"\n" + "}\n";
	}
	
	public static String dummyContactrequest() {

		return "{\n" + "\"name\": {\n" + "\"first\": \"Yadav\",\n" + "\"last\": \"Bastola\",\n"
				+ "\"middle\": \"Francis\"\n" + "},\n" + "\"address\": {\n" + "\"street\": \"2751 prosperity ave\",\n"
				+ "\"city\": \"Cannon\",\n" + "\"state\": \"Delaware\",\n" + "\"zip\": 19797\n" + "},\n"
				+ "\"phone\": [\n" + "{\n" + "\"number\": \"302-532-9427\",\n" + "\"type\": \"mobile\"\n" + "},\n"
				+ "{\n" + "\"number\": \"302-611-9148\",\n" + "\"type\": \"home\"\n" + "}\n" + "],\n"
				+ "\"email\": \"yadav.gilkey@yahoo.com\"\n" + "}\n";
	}

}
