package kg.firstspring.homework73.services;

import kg.firstspring.homework73.entities.Computer;
import kg.firstspring.homework73.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerServiceImpl implements ComputerService {
    @Autowired
    private ComputerRepository computerRepository;

    @Override
    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

    @Override
    public Computer getById(Long id) {
        Optional<Computer> computer = computerRepository.findById(id);
        return computer.orElse(new Computer());
    }

    @Override
    public Computer save(Computer computer) {
        return computerRepository.save(computer);
    }

    @Override
    public void delete(Long id) {
        computerRepository.deleteById(id);
    }
}
