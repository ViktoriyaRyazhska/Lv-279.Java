package ua.softserve.service;

import ua.softserve.persistence.entity.Mark;

import java.util.List;
/**
 * Mark Service.
 */
public interface MarkService {
    /**
     * Returns all feedbacks marks from DB.
     *
     * @return list of marks.
     */
    List<Mark> findAll();
}
