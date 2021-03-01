package ir.mostafa.semnani.energybill.controller;

import ir.mostafa.semnani.energybill.model.entity.Customer;
import ir.mostafa.semnani.energybill.model.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/user/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    @RequestMapping("/save")
    public String save (@ModelAttribute Customer customer){
        logger.info("customer save called.");
        customerService.save(customer);
        return "redirect:/user/customer/findAll";
    }

    @RequestMapping("/delete")
    public String delete (@RequestParam Long id){
        customerService.delete(id);
        return "redirect:/user/customer/findAll";
    }
    @RequestMapping("/update")
    public String update (@ModelAttribute Customer customer){
        customerService.update(customer);
        return "redirect:/user/customer/findAll";
    }

    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request) {
        logger.info("customer find all called.");
        request.setAttribute("customerList" , customerService.findAll());
        return "customer";
    }

    @RequestMapping("/findById" )
    public String findById(HttpServletRequest request ,@RequestParam Long id) {
        Customer customer = customerService.findOneById(id);
        request.setAttribute("customer", customer);
        return "customer_id";
    }
}
