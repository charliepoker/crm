package com.example.crm.Controller;


import com.example.crm.entities.Customer;
import com.example.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepo;

    @GetMapping({ "/list", "/"})
    public ModelAndView showCustomers(){
        ModelAndView mav = new ModelAndView("Homepage");
        List<Customer> list = customerRepo.findAll();
        mav.addObject("customers", list);
        return mav;
    }

    @GetMapping("/addCustomerForm")
    public ModelAndView addCustomerForm(){
        ModelAndView mav = new ModelAndView("Customerform");
        Customer newCustomer = new Customer();
        mav.addObject("customer", newCustomer);
        return mav;
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer){
        customerRepo.save(customer);
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long customerId) {
        ModelAndView mav = new ModelAndView("Customerform");
        Customer customer = customerRepo.findById(customerId).get();
        mav.addObject("customer", customer);
        return mav;
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam Long customerId) {
        customerRepo.deleteById(customerId);
        return "redirect:/list";
    }

}
