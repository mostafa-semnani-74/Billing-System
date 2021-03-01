package ir.mostafa.semnani.energybill.controller;

import ir.mostafa.semnani.energybill.model.entity.Bill;
import ir.mostafa.semnani.energybill.model.entity.Customer;
import ir.mostafa.semnani.energybill.model.service.BillService;
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
@RequestMapping ("/user/bill")
public class BillController {
    @Autowired
    BillService billService;
    @Autowired
    CustomerService customerService;

    private static final Logger logger = LogManager.getLogger(BillController.class);

    @RequestMapping("/save")
    public String save (@ModelAttribute Bill bill){
        logger.info("bill save called.");
        Customer customer = new Customer();
        customer.setCustomerId(Long.valueOf(bill.getUiCustomerId()));
        bill.setCustomer(customer);
        billService.save(bill);
        return "redirect:/user/bill/findAll";
    }

    @RequestMapping("/delete")
    public String delete (@RequestParam Long id, HttpServletRequest request){
            billService.delete(id);
        return "redirect:/user/bill/findAll";
    }

    @RequestMapping("/update")
    public String update (@ModelAttribute Bill bill){
        billService.update(bill);
        return "redirect:/user/bill/findAll";
    }

    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request) {
        logger.info("bill find all called.");
        request.setAttribute("billList" , billService.findAll());
        request.setAttribute("customerList", customerService.findAll());
        return "bill";
    }

    @RequestMapping("/findById" )
    public String findOneById(HttpServletRequest request ,@RequestParam Long id) {
        try {
            Bill bill = billService.findOneById(id);
            request.setAttribute("customer", customerService.findOneById(bill.getCustomer().getCustomerId()));
            request.setAttribute("bill", bill);
            return "bill_id";
        }catch (Exception e){
            logger.error("Error happened while findOneById in Bill Controller called " + e.getMessage());
            request.setAttribute("err_msg", "Bill not found");
            return "bill";
        }

    }
}
