package ua.softserve.persistence.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class HistoryDTO {
    private int id;
    private int crmGroup;
    private String academyName;
    private String nameForSite;
    private String location;
    private String sartDate;
    private String endDate;
    private String stage;
    private String direction;
    private String modifyDate;
    private String modifyBy;
}
