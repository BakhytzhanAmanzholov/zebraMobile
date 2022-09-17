package kz.jaguars.hackathon.repositories;

import kz.jaguars.hackathon.models.Preference;
import org.springframework.data.repository.CrudRepository;

public interface PreferenceRepository extends CrudRepository<Preference, Long> {

}
