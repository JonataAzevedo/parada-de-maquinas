package ubivis.teste.paradademaquinas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubivis.teste.paradademaquinas.model.dto.MachineDTO;
import ubivis.teste.paradademaquinas.model.entities.Machine;
import ubivis.teste.paradademaquinas.service.MachineService;

import java.util.List;

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

    @GetMapping(path = "/{id}")
    public ResponseEntity<Machine> findById(@PathVariable @RequestBody Integer id){
        return machineService.findById(id);
    }

    @GetMapping("/list")
    public List<Machine> findAll(){
        return machineService.machineList();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Machine> endstop(@PathVariable Integer id, @RequestBody MachineDTO machineDTO){
        return new ResponseEntity<>(machineService.endstop(id, machineDTO), HttpStatus.OK);
    }
}
