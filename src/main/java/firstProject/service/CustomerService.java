package firstProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import firstProject.Repository.CustomerRepository;
import firstProject.base.BaseErrorCode;
import firstProject.base.BusinessException;
import firstProject.dto.CustomerUpdateDto;
import firstProject.entity.Account;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Object getAllCustomer() throws BusinessException {
		throw new BusinessException(BaseErrorCode.NOT_FOUND);
		//return customerRepository.findAll();
	}
	public Object updateCustomer(CustomerUpdateDto customerUpdateDto) throws BusinessException {
		Account customer = customerRepository.findById(customerUpdateDto.getId()).orElseThrow(()-> new BusinessException(BaseErrorCode.NOT_FOUND));
		if(customerUpdateDto.getName()!=null) customer.setName(customerUpdateDto.getName());
		if(customerUpdateDto.getBirthDay()!=null) customer.setBirthDay(customerUpdateDto.getBirthDay());
		if(customerUpdateDto.getAddress()!=null) customer.setAddress(customerUpdateDto.getAddress());
		if(customerUpdateDto.getPhone()!=null) customer.setPhone(customerUpdateDto.getPhone());
		if(customerUpdateDto.getSex()!=null) customer.setSex(customerUpdateDto.getSex());
		return customerRepository.save(customer);
	}
	
	public Object getCustomerById(Long id) {
		return customerRepository.findById(id);
	}
}
