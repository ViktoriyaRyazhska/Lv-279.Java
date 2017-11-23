package ua.softserve.service.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.softserve.persistence.entity.Profile;
import ua.softserve.service.ProfileService;

import java.beans.PropertyEditorSupport;


@Component
public class ProfileEditor extends PropertyEditorSupport {
    @Autowired
    ProfileService profileService;

    @Override
    public void setAsText(String id) throws IllegalArgumentException {
        int profileId = Integer.parseInt(id);
        Profile profile= profileService.findOne(profileId);
        setValue(profile);
    }
}

