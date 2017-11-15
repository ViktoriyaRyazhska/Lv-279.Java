/*
* GenericDAO
*
* Version 1.0-SNAPSHOT
*
* 15.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.repository.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, PK extends Serializable> {

    PK save(T o);

    void update(T o);

    T findById(PK id);

    List<T> findAll();

    void delete(T o);

}
