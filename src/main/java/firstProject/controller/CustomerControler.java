package firstProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import firstProject.base.BusinessException;
import firstProject.base.ResponseData;
import firstProject.dto.CustomerUpdateDto;
import firstProject.service.CustomerService;

@RequestMapping(path  = "/v1.0")
@RestController
public class CustomerControler {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/get/all-customer")
	ResponseEntity<ResponseData<Object>> getAllCustomer(@RequestParam(value = "page", required = false)Long page
			, @RequestParam(value = "size", required = false) Long size) throws BusinessException {
		return ResponseEntity.ok(new ResponseData().success(customerService.getAllCustomer(page, size)));
	}
	
	@PostMapping("/post/update-customer")
	ResponseEntity<ResponseData<Object>> updateCustomer(@RequestBody CustomerUpdateDto customerUpdateDto ) throws BusinessException {
		return ResponseEntity.ok(new ResponseData().success(customerService.updateCustomer(customerUpdateDto)));
	}
	
	@GetMapping("/get/customer-by-id")
	ResponseEntity<ResponseData<Object>> getCustomerById(@RequestParam Long id ) throws BusinessException {
		return ResponseEntity.ok(new ResponseData().success(customerService.getCustomerById(id)));
	}
	
	@DeleteMapping("/delete/customer-by-id")
	ResponseEntity<ResponseData<Object>> deleteCustomer(@RequestParam Long id ) throws BusinessException {
		return ResponseEntity.ok(new ResponseData().success(customerService.deleteCustomer(id)));
	}
}
