package ua.softserve.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.GroupInfo;

import java.util.List;

@Getter
@Setter
@ToString
public class GroupOverviewDropDownLists extends DropDownLists{
    List<GroupInfo> groupNames;
}
