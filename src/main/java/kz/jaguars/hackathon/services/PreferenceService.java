package kz.jaguars.hackathon.services;


import kz.jaguars.hackathon.models.Preference;

import java.util.List;

public interface PreferenceService extends CrudService<Preference, Long>{
    List<Preference> findAll();

    void addPreferenceToUser(Long id);


}
