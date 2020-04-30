package kg.firstspring.homework73.controller;

import kg.firstspring.homework73.entities.Computer;
import kg.firstspring.homework73.services.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/computer")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping("/list")
    public List<Computer> getAll(){
        return computerService.getAllComputers();
    }

    @PostMapping
    public Computer create(@RequestBody Computer computer){
        return computerService.save(computer);
    }

    @GetMapping("/{id}")
    public Computer getById(@PathVariable Long id){
        return computerService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){

    }
}
