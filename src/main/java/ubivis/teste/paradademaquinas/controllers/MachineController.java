package ubivis.teste.paradademaquinas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubivis.teste.paradademaquinas.model.dto.MachineCreateDTO;
import ubivis.teste.paradademaquinas.model.dto.MachineDTO;
import ubivis.teste.paradademaquinas.model.dto.MachineEndStopDTO;
import ubivis.teste.paradademaquinas.model.dto.MachineReasonDTO;
import ubivis.teste.paradademaquinas.model.entities.Machine;
import ubivis.teste.paradademaquinas.service.MachineService;

import java.util.List;

@RestController
@RequestMapping("/machine-hal")
public class MachineController {

    @Autowired
    private MachineService machineService;

    @PostMapping
    public ResponseEntity<Machine> create(@RequestBody MachineCreateDTO machineCreateDTO){
        Machine machine = machineService.create(machineCreateDTO);
        return new ResponseEntity<>(machine, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Machine> findById(@PathVariable @RequestBody Integer id){
        return machineService.findById(id);
    }

    @GetMapping("/list")
    public List<Machine> findAll(){
        return machineService.machineListAll();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Machine> endStop(@PathVariable Integer id, @RequestBody MachineEndStopDTO machineEndStopDTO){
        return new ResponseEntity<>(machineService.endStop(id, machineEndStopDTO), HttpStatus.OK);
    }

    @PutMapping(path = "/reason/{id}")
    public ResponseEntity<Machine> reasonStop(@PathVariable Integer id, @RequestBody MachineReasonDTO machineReasonDTO){
        return new ResponseEntity<>(machineService.reasonStop(id, machineReasonDTO), HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public void deleteAllStop(){
         machineService.deleteAllStop();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Integer id){
        machineService.deleteById(id);
    }
}