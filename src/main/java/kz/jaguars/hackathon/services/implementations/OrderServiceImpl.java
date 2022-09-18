package kz.jaguars.hackathon.services.implementations;

import kz.jaguars.hackathon.exceptions.NotFoundException;
import kz.jaguars.hackathon.models.Account;
import kz.jaguars.hackathon.models.Booking;
import kz.jaguars.hackathon.repositories.OrderRepository;
import kz.jaguars.hackathon.services.AccountService;
import kz.jaguars.hackathon.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final AccountService accountService;

    @Override
    public Booking save(Booking entity) {
        return orderRepository.save(entity);
    }

    @Override
    public void delete(Long aLong) {
        orderRepository.deleteById(aLong);
    }

    @Override
    public Booking update(Booking entity) {
        Booking updated = findById(entity.getId());
        updated.setCompleted(entity.getCompleted());
        updated.setPrice(entity.getPrice());
        updated.setDate(entity.getDate());
        return updated;
    }

    @Override
    public Booking findById(Long aLong) {
        return orderRepository.findById(aLong).orElseThrow(
                () -> new NotFoundException("Order <" + aLong + "> not found"));
    }

    @Override
    public List<Booking> findByCustomer() {
        Account account = accountService.findByEmail(accountService.isLogged());
        return orderRepository.findAllByAccount(account);
    }
}
