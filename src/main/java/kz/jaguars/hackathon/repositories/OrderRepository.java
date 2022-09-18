package kz.jaguars.hackathon.repositories;

import kz.jaguars.hackathon.models.Account;
import kz.jaguars.hackathon.models.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Booking, Long> {
    List<Booking> findAllByAccount(Account account);
}
