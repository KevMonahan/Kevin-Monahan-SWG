/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.VendingMachineController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author user
 */
public class App {
    public static void main(String[] args) {
//        UserIO myIo = new UserIOConsoleImpl();
//    VendingMachineView myView = new VendingMachineView(myIo);
//    VendingMachineDao myDao = new VendingMachineDaoImpl();
//    
//    VendingMachineServiceLayer myService = new VendingMachineServiceImpl(myDao);
//    VendingMachineController controller = new VendingMachineController(myService, myView);
//    controller.run();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller = ctx.getBean("controller", VendingMachineController.class);
        controller.run();

}
}
