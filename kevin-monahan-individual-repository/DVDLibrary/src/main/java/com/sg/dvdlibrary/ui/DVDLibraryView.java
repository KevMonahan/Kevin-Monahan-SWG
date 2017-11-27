/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.DVD;
import java.util.List;

/**
 *
 * @author user
 */
public class DVDLibraryView {

    UserIO io;

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVD IDs");
        io.print("2. Create New DVD");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Edit a DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public DVD getNewDVDInfo() {
        String dvdId = io.readString("Please enter DVD Id");
        String title = io.readString("Please enter DVD Title");
        String releaseDate = io.readString("Please enter DVD Release Date");
        String mpaaRating = io.readString("Please enter the DVD's MPAA Rating");
        String directorsName = io.readString("Please enter the name of the DVD's Director");
        String studio = io.readString("Please enter the name of the Studio that released the DVD");
        String userRating = io.readString("Please enter your rating of the DVD");
        DVD currentDVD = new DVD(dvdId);
        currentDVD.setTitle(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirectorsName(directorsName);
        currentDVD.setStudio(studio);
        currentDVD.setUserRating(userRating);
        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }
    
    public void displayEditDVDSuccessBanner() {
        io.print("You have successfully edited your DVD");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            io.print(currentDVD.getDvdId() + ": "
                    + currentDVD.getTitle() + " "
                    + currentDVD.getReleaseDate() + " "
                    + currentDVD.getMpaaRating() + " "
                    + currentDVD.getDirectorsName() + " "
                    + currentDVD.getStudio() + " "
                    + currentDVD.getUserRating());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD ===");
    }

    public String getDVDIdChoice() {
        return io.readString("Please enter the DVD ID.");
    }
    
    

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getDvdId());
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorsName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRating());
            io.print("");
        } else {
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("DVD successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
    public void displayEditDVDBanner() {
        io.print("===You have chosen to edit a DVD ===");
    }
    
    public String getDVDTitle() {
        return io.readString("Please enter the ID of the DVD you would like to edit.");
    }
}
