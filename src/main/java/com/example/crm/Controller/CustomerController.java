package com.example.crm.Controller;


import com.example.crm.entities.Customer;
import com.example.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepo;

    @GetMapping("/showCustomers")
    public ModelAndView showCustomers(){
        ModelAndView mav = new ModelAndView("Homepage");
        List<Customer> list = customerRepo.findAll();
        mav.addObject("customers", list);
        return mav;
    }

    @GetMapping("/addCustomerForm")
    public ModelAndView addCustomer(){
        ModelAndView mav = new ModelAndView("Customerform");
        Customer newCustomer = new Customer();
        mav.addObject("customer", newCustomer);
        return mav;
    }

}
