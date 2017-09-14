/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.DVD;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author user
 */
public class DVDLibraryController {

    DVDLibraryView view;
    DVDLibraryDao dao;
    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            
            while (keepGoing) {
                
                menuSelection = getMenuSelection();
                
                
                switch (menuSelection) {
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        createDVD();
                        break;
                    case 3:
                        viewDVD();
                        break;
                    case 4:
                        removeDVD();
                        break;
                    case 5:
                        editDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getDvdId(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void listDVDs() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> DVDList = dao.getAllDVD();
        view.displayDVDList(DVDList);
    }

    private void viewDVD() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String dvdId = view.getDVDIdChoice();
        DVD dvd = dao.getDVD(dvdId);
        view.displayDVD(dvd);
    }

    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String dvdId = view.getDVDIdChoice();
        dao.removeDVD(dvdId);
        view.displayRemoveSuccessBanner();
    }
    
    private void editDVD() throws DVDLibraryDaoException {
        view.displayEditDVDBanner();
        String id = view.getDVDTitle();
        DVD editDvd = view.getNewDVDInfo();
        dao.removeDVD(id);
        dao.editDVD(editDvd.getDvdId(), editDvd);
        view.displayEditDVDSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }
}
