package com.abc.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.abc.dtos.ContactDto;
import com.abc.dtos.PhoneDto;
import com.abc.entities.ContactEntity;
import com.abc.exceptions.EntityNotFoundException;
import com.abc.repositories.ContactRepository;
import com.abc.utils.ContactMapper;

@Service
public class ContactService {

	@Autowired
	private ValidationService validationService;
	@Autowired
	private ContactRepository contactRepository;
	

	public void deleteEntity(Long id) {
		contactRepository.deleteById(id);
	}

	public Set<ContactDto> getAllEntities() {

		List<ContactEntity> contactDtos = contactRepository.findAll();		
		if (contactDtos == null) {
			throw new EntityNotFoundException();
		}
		return contactDtos
				.stream()
				.map(d -> ContactMapper.mapContactFromEntity(d))
				.collect(Collectors.toSet());		

	}
	

	public ContactDto getEntity(Long id) {
		Optional<ContactEntity> resp = contactRepository.findById(id);
		if(!resp.isPresent()) {
			throw new EntityNotFoundException();			
		}
		return ContactMapper.mapContactFromEntity(resp.get());

	}

	public ContactDto saveContact(ContactDto contactDetails) {
		validationService.validatePhone(contactDetails);
		ContactEntity contact = ContactMapper.mapContactToEntity(contactDetails);
		return ContactMapper.mapContactFromEntity(contactRepository.save(contact));

	}
	
	public ContactDto updateContact(Long id, ContactDto contactDetails) {
		validationService.validatePhone(contactDetails);
		ContactDto resp = getEntity(id);
		update(contactDetails, resp);
		ContactEntity contactEntity = ContactMapper.mapContactToEntity(resp);
		return ContactMapper.mapContactFromEntity(contactRepository.save(contactEntity));

	}
	
	public void update(ContactDto source, ContactDto dest) {

		if (!StringUtils.isEmpty(source.getEmail())) {
			dest.setEmail(source.getEmail());
		}

		if (source.getAddress() != null) {
			if (dest.getAddress() == null) {
				dest.setAddress(source.getAddress());
			} else {
				if (!StringUtils.isEmpty(source.getAddress().getStreet())) {
					dest.getAddress().setStreet(source.getAddress().getStreet());
				}
				if (!StringUtils.isEmpty(source.getAddress().getState())) {
					dest.getAddress().setState(source.getAddress().getState());
				}
				if (!StringUtils.isEmpty(source.getAddress().getZip())) {
					dest.getAddress().setZip(source.getAddress().getZip());
				}
				if (!StringUtils.isEmpty(source.getAddress().getCity())) {
					dest.getAddress().setCity(source.getAddress().getCity());
				}
			}
		}

		if (source.getName() != null) {
			if (dest.getName() == null) {
				dest.setName(source.getName());
			} else {
				if (!StringUtils.isEmpty(source.getName().getFirst())) {
					dest.getName().setFirst(source.getName().getFirst());
				}
				if (!StringUtils.isEmpty(source.getName().getMiddle())) {
					dest.getName().setMiddle(source.getName().getMiddle());
				}
				if (!StringUtils.isEmpty(source.getName().getLast())) {
					dest.getName().setLast(source.getName().getLast());
				}
			}
		}

		if (source.getPhone() != null) {
			if (dest.getPhone() == null) {
				dest.setPhone(source.getPhone());
			} else {
				Set<PhoneDto> phone = source.getPhone();
				for (PhoneDto p : phone) {
					PhoneDto oldPhone = getPhoneFromType(dest.getPhone(), p.getType());
					if (oldPhone != null) {
						oldPhone.setNumber(p.getNumber());
					} else {
						dest.getPhone().add(p);
					}

				}
			}
		}

	}

	public PhoneDto getPhoneFromType(Set<PhoneDto> phoneSet, String type) {
		for (PhoneDto p : phoneSet) {
			if (p.getType().equals(type)) {
				return p;
			}
		}
		return null;

	}
}
