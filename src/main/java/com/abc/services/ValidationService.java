package com.abc.services;


import org.springframework.stereotype.Service;

import com.abc.dtos.ContactDto;
import com.abc.dtos.PhoneDto;
import com.abc.exceptions.ContactValidationException;
import com.abc.utils.ConstantUtils;

@Service
public class ValidationService {

	public void validatePhone(ContactDto contactDetails) {

		if (contactDetails != null && contactDetails.getPhone() != null) {
			for (PhoneDto p : contactDetails.getPhone()) {
				if (!ConstantUtils.PHONETYPES.contains(p.getType())) {
					throw new ContactValidationException("Only mobile|home|work allowed for phone type");

				}
			}
		}

	}
}
