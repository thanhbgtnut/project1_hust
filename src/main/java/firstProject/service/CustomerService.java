package firstProject.service;

import java.util.Date;

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
//		throw new BusinessException(BaseErrorCode.NOT_FOUND);
		return customerRepository.findAll();
	}
	public Object updateCustomer(CustomerUpdateDto customerUpdateDto) throws BusinessException {
		Account customer = new Account();
		if(customerUpdateDto.getId()!=null) {
			customer = customerRepository.getAllAccountActive(customerUpdateDto.getId()).orElse(new Account());
		}
		if(customerUpdateDto.getName()!=null) customer.setName(customerUpdateDto.getName());
		if(customerUpdateDto.getBirthDay()!=null) customer.setBirthDay(customerUpdateDto.getBirthDay());
		if(customerUpdateDto.getAddress()!=null) customer.setAddress(customerUpdateDto.getAddress());
		if(customerUpdateDto.getPhone()!=null) customer.setPhone(customerUpdateDto.getPhone());
		if(customerUpdateDto.getSex()!=null) customer.setSex(customerUpdateDto.getSex());
		customer.setStatus(1L);
		customer.setCreatedDate(new Date());
		customer.setUpdatedDate(new Date());
		customer.setCreatedBy(1L);
		customer.setUpdatedBy(1L);
		return customerRepository.save(customer);
	}
	
	public Object getCustomerById(Long id) {
		return customerRepository.getAllAccountActive(id);
	}
	
	public Object deleteCustomer(Long id) throws BusinessException {
		Account account = customerRepository.getAllAccountActive(id).orElseThrow(()-> new BusinessException(BaseErrorCode.NOT_FOUND));
		account.setStatus(0L);
		return customerRepository.save(account);
	}
	
	
}
