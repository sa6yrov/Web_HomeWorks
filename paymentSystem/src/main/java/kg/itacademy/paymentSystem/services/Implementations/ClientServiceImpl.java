package kg.itacademy.paymentSystem.services.Implementations;

import kg.itacademy.paymentSystem.services.ClientService;
import kg.itacademy.paymentSystem.entities.Client;
import kg.itacademy.paymentSystem.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client getById(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.get();
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client save(Client item) {
        return clientRepository.save(item);
    }

    @Override
    public List<Client> findAllByName(String name) {
        return null;
    }
}
