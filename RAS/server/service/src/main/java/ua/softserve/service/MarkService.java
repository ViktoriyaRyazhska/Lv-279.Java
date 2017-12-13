package ua.softserve.service;

import ua.softserve.persistence.entity.Mark;

import java.util.List;

public interface MarkService {
    /**
     * Returns all marks from DB.
     *
     * @return list of marks.
     */
    List<Mark> findAll();
}
