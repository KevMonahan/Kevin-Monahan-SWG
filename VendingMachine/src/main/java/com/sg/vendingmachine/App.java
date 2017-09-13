/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.VendingMachineController;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoImpl;
import com.sg.vendingmachine.service.VendingMachineServiceImpl;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;

/**
 *
 * @author user
 */
public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
    // Instantiate the View and wire the UserIO implementation into it
    VendingMachineView myView = new VendingMachineView(myIo);
    // Instantiate the DAO
    VendingMachineDao myDao = new VendingMachineDaoImpl();
    
    // Instantiate the Service Layer and wire the DAO and Audit DAO into it
    VendingMachineServiceLayer myService = new VendingMachineServiceImpl(myDao);
    // Instantiate the Controller and wire the Service Layer into it
    VendingMachineController controller = new VendingMachineController(myService, myView);
    // Kick off the Controller
    controller.run();

}
}
