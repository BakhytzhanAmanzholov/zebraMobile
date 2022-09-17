package kz.jaguars.hackathon.services.implementations;

import kz.jaguars.hackathon.exceptions.NotFoundException;
import kz.jaguars.hackathon.models.Account;
import kz.jaguars.hackathon.models.Preference;
import kz.jaguars.hackathon.repositories.PreferenceRepository;
import kz.jaguars.hackathon.services.AccountService;
import kz.jaguars.hackathon.services.PreferenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PreferenceServiceImpl implements PreferenceService {

    private final PreferenceRepository preferenceRepository;

    private final AccountService accountService;

    @Override
    public Preference save(Preference entity) {
        return preferenceRepository.save(entity);
    }

    @Override
    public void delete(Long aLong) {
        preferenceRepository.deleteById(aLong);
    }

    @Override
    public Preference update(Preference entity) {
        Preference preference = findById(entity.getId());
        preference.setDescription(entity.getDescription());
        preference.setTitle(entity.getTitle());
        return preference;
    }

    @Override
    public Preference findById(Long aLong) {
        return preferenceRepository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Preference <" + aLong + "> not found"));
    }

    @Override
    public List<Preference> findAll() {
        return (List<Preference>) preferenceRepository.findAll();
    }

    @Override
    public void addPreferenceToUser(Long id) {
        Preference preference = findById(id);
        Account account = accountService.findByEmail(accountService.isLogged());
        account.getPreferences().addAll(preference.getProducts());
    }
}
