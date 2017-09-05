/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    public static final String LIBRARY_FILE = "dvdlibrary.txt";
    public static final String DELIMITER = "::";

    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD addDVD(String dvdId, DVD dvd)
            throws DVDLibraryDaoException {
        DVD newDVD = dvds.put(dvdId, dvd);
        writeLibrary();
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVD()
            throws DVDLibraryDaoException {
        loadLibrary();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String dvdId)
            throws DVDLibraryDaoException {
        loadLibrary();
        return dvds.get(dvdId);
    }

    @Override
    public DVD removeDVD(String dvdId)
            throws DVDLibraryDaoException {

        DVD removedDVD = dvds.remove(dvdId);
        writeLibrary();
        return removedDVD;
    }

    private void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load roster data into memory.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            DVD currentDVD = new DVD(currentTokens[0]);

            currentDVD.setTitle(currentTokens[1]);
            currentDVD.setReleaseDate(currentTokens[2]);
            currentDVD.setMpaaRating(currentTokens[3]);
            currentDVD.setDirectorsName(currentTokens[4]);
            currentDVD.setStudio(currentTokens[5]);
            currentDVD.setUserRating(currentTokens[6]);

            dvds.put(currentDVD.getTitle(), currentDVD);
        }

        scanner.close();
    }

    private void writeLibrary() throws DVDLibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save dvd data.", e);
        }

        List<DVD> DVDList = this.getAllDVD();
        for (DVD currentDVD : DVDList) {

            out.println(currentDVD.getDvdId() + DELIMITER
                    + currentDVD.getTitle() + DELIMITER
                    + currentDVD.getReleaseDate() + DELIMITER
                    + currentDVD.getMpaaRating() + DELIMITER
                    + currentDVD.getDirectorsName() + DELIMITER
                    + currentDVD.getStudio() + DELIMITER
                    + currentDVD.getUserRating());

            out.flush();
        }

        out.close();
    }

}
