package kg.itacademy.paymentSystem.Services;

import kg.itacademy.paymentSystem.entities.Client;

import java.util.List;

public interface ClientService extends BaseService<Client> {
    List<Client> findAllByName(String name);
}
