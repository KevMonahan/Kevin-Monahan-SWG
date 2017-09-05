/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.DVD;
import java.util.List;

/**
 *
 * @author user
 */
public interface DVDLibraryDao {

    DVD addDVD(String dvdId, DVD dvd)
            throws DVDLibraryDaoException;

    List<DVD> getAllDVD()
            throws DVDLibraryDaoException;

    DVD getDVD(String dvdId)
            throws DVDLibraryDaoException;

    DVD removeDVD(String dvdId)
            throws DVDLibraryDaoException;
}
