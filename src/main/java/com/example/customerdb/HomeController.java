package com.example.customerdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    CompanyRepository  companyRepository;

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/")
    public String companydetails(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "list";
    }


    @GetMapping("/search")
    public String getSearch()
    {

        return "customerform";
    }

//state search
    @GetMapping("/statesearch")
    public String getstatesearch()
    {

        return "stateform";
    }


    @GetMapping("/add")
    public String customerForm(Model model) {
        return "customerform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Customer customer, BindingResult result, HttpServletRequest request,Model model) {
        if (result.hasErrors()) {
            return "customerform";
        }
       String search = request.getParameter("lastname");
        model.addAttribute("listResult",customerRepository.findByLastnameIgnoreCase(search));
        return "customerform";
    }

    @PostMapping("/stateprocess")
    public String processState(@Valid Customer customer, BindingResult result, HttpServletRequest request,Model model) {
        if (result.hasErrors()) {
            return "stateform";
        }
        String search1 = request.getParameter("state");
        model.addAttribute("liststate", customerRepository.findAllByState(search1));
        return "stateform";
    }





}
