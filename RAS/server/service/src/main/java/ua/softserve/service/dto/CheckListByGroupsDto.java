/*
 * CheckListByGroupsDto
 *
 * Version 1.0-SNAPSHOT
 *
 * 30.11.17
 *
 * All rights reserved by DoubleO Team (Team#1)
 * */

package ua.softserve.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.softserve.persistence.entity.EnglishLevel;
import ua.softserve.persistence.entity.GroupInfoTeachers;
import ua.softserve.persistence.entity.Student;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static ua.softserve.persistence.constants.ConstantsFromDb.ENGLISH_LEVEL_PRE_INTERMEDIATE_ID;

@Getter
@Setter
@NoArgsConstructor
public class CheckListByGroupsDto {

    private String groupName;
    private String cityName;
    private String status;
    private String teachers;
    private String experts;
    private Map<String, Integer> report = new HashMap<>();

    private double total;

}
