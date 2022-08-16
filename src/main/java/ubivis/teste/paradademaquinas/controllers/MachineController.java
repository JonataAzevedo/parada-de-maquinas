package ubivis.teste.paradademaquinas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubivis.teste.paradademaquinas.model.dto.MachineDTO;
import ubivis.teste.paradademaquinas.model.entities.Machine;
import ubivis.teste.paradademaquinas.repository.MachineRepository;
import ubivis.teste.paradademaquinas.service.MachineService;

import java.util.Optional;

@RestController
@RequestMapping("/machine-hal")
public class MachineController {

    @Autowired
    private MachineService machineService;

    @PostMapping
    public ResponseEntity<Machine> create(@RequestBody MachineDTO machineDTO){
        Machine machine = machineService.create(machineDTO);
        return new ResponseEntity<>(machine, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<Machine> findById(@PathVariable Integer id, MachineDTO machineDTO){
        return machineService.findById(id);
    }


}
