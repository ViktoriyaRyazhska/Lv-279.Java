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

import java.util.HashMap;
import java.util.Map;

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
