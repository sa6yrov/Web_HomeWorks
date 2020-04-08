package kg.firstspring.homework73.services;

import kg.firstspring.homework73.entities.Computer;

import java.util.List;

public interface ComputerService {
    List<Computer> getAllComputers();

    Computer getById(Long id);

    Computer save(Computer computer);

    void delete(Long id);
}
