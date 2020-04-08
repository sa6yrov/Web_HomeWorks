package kg.firstspring.homework73.repository;

import kg.firstspring.homework73.entities.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long>{

}
