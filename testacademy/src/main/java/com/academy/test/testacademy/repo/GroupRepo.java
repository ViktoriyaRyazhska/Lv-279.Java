package com.academy.test.testacademy.repo;

import com.academy.test.testacademy.entity.GroupInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<GroupInfo, Integer> {
    GroupInfo findByAcademy_AcademyId(int id);
}
