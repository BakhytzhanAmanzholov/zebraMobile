package kz.jaguars.hackathon.services;

import kz.jaguars.hackathon.models.Account;
import kz.jaguars.hackathon.models.Booking;

public interface AccountService extends CrudService<Account, Long>{
    Account findByEmail(String email);

    String isLogged();

    void addOrderToAccount(Booking booking, Long id);
}
