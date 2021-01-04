package firstProject.service;

import firstProject.Repository.CustomerRepository;
import firstProject.dto.PagerModel;
import firstProject.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Service
public class ViewService {

    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = { 5, 10};
    @Autowired
    private CustomerRepository customerRepository;

    public ModelAndView viewByPage(Optional<Integer> pageSize, Optional<Integer> page){
        ModelAndView modelAndView = new ModelAndView("customers");
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        Page<Account> customers =  customerRepository.getAllAccountActive(PageRequest.of(evalPage, evalPageSize));
//        System.out.println("client list get total pages" + clientlist.getTotalPages() + "client list get number " + clientlist.getNumber());
        PagerModel pager = new PagerModel(customers.getTotalPages(),customers.getNumber(),BUTTONS_TO_SHOW);
        // add clientmodel
        modelAndView.addObject("customers",customers);
        // evaluate page size
        modelAndView.addObject("selectedPageSize", evalPageSize);
        // add page sizes
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        // add pager
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

}
