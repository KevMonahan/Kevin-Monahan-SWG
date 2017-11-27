package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.service.ServiceLayer;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author user
 */
@Controller
public class VendingMachineController {   
    private ServiceLayer serviceLayer;
    
    @Inject
    public VendingMachineController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("wallet", serviceLayer.getWallet());
        model.addAttribute("selection", serviceLayer.getSelection());
        model.addAttribute("currentChange", serviceLayer.getCurrentChange());
        model.addAttribute("junkFood", serviceLayer.getJunkFood());
        model.addAttribute("message", serviceLayer.getMessage());
        return "index";
    }
    
    @RequestMapping(value="/addMoney/{amount}", method=RequestMethod.GET)
    public String addMoney(@PathVariable String amount) {
        serviceLayer.addMoney(amount);
        return "redirect:/";
    }
    
    @RequestMapping(value="/makePurchase", method=RequestMethod.GET)
    public String makePurchase() {
        serviceLayer.makePurchase();
        return "redirect:/";
    }
    
    @RequestMapping(value="/returnChange", method=RequestMethod.GET)
    public String changeReturn() {
        serviceLayer.changeReturn();
        return "redirect:/";
    }
    
    @RequestMapping(value="/makeSelection/{id}", method=RequestMethod.GET)
    public String makeSelection(@PathVariable("id") int id) {
        serviceLayer.setSelection(id);
        return "redirect:/";
    }
}