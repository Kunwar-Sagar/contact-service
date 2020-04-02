package com.abc.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.dtos.ContactDto;
import com.abc.services.ContactService;

@RestController
@RequestMapping(path = "/contacts")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/{id}")
	public ResponseEntity<ContactDto> getContacts(@PathVariable("id") Long id) {
		return new ResponseEntity<>(contactService.getEntity(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Set<ContactDto>> getAllContacts() {
		return new ResponseEntity<>(contactService.getAllEntities(),HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ContactDto> saveContacts(@RequestBody ContactDto contact) {
		return new ResponseEntity<>(contactService.saveContact(contact), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ContactDto> updateContacts(@PathVariable("id") Long id, @RequestBody ContactDto contact) {
		return new ResponseEntity<>(contactService.updateContact(id, contact), HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteContact(@PathVariable("id") Long id) {
		contactService.deleteEntity(id);
		return new ResponseEntity(HttpStatus.OK);
	}

}
