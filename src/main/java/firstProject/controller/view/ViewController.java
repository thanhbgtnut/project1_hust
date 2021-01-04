package firstProject.controller.view;

import java.util.List;
import java.util.Optional;

import firstProject.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import firstProject.base.BusinessException;
import firstProject.entity.Account;
import firstProject.service.CustomerService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private ViewService viewService;


	@GetMapping(value = { "/", "/home" })
	public String home(Model model) throws BusinessException {
		List<Account> accounts = customerService.getAllCustomer(null, null);
		model.addAttribute("customers",accounts);
		return "home";
	}

	@GetMapping(value = {"/customer"})
	public ModelAndView homepage(@RequestParam("pageSize") Optional<Integer> pageSize,
								 @RequestParam("page") Optional<Integer> page){
		return viewService.viewByPage(pageSize, page);
	}
	@GetMapping("/edit")
	public String edit(){
		return "edit";
	}
}
