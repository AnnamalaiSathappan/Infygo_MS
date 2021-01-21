/**
 * 
 */
package com.infy.irs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.irs.dto.LoginDetails;
import com.infy.irs.entity.Customer;
import com.infy.irs.exception.ExceptionConstants;
import com.infy.irs.exception.InfyGoServiceException;
import com.infy.irs.repository.CustomerRepository;

/**
 * The Class AadharService.
 */
@Service
public class LoginService {

	@Autowired
	private CustomerRepository customerRepository;

	public boolean isUserValid(LoginDetails customerLogin) throws InfyGoServiceException {

		Customer customer = customerRepository.findById(customerLogin.getUserId()).get();

		if (customer == null) {
			throw new InfyGoServiceException(ExceptionConstants.USER_NOT_FOUND.toString(), "User record not found");
		} else if (!(customer.getPassword().equals(customerLogin.getPassword()))) {
			throw new InfyGoServiceException(ExceptionConstants.USER_INVALID.toString(), "Invalid credentials");
		}
		return true;

	}

}
