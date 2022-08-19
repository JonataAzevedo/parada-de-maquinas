package ubivis.teste.paradademaquinas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubivis.teste.paradademaquinas.model.dto.MachineCreateDTO;
import ubivis.teste.paradademaquinas.model.dto.StopMachineHoltDTO;
import ubivis.teste.paradademaquinas.model.dto.MachineReasonDTO;
import ubivis.teste.paradademaquinas.model.entities.Machine;
import ubivis.teste.paradademaquinas.service.MachineService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/machine-halt")
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
        return new ResponseEntity<>(machineService.findById(id),HttpStatus.OK);
    }

    @GetMapping(path = "/list")
    public List<Machine> findAll(@RequestParam String machineTag,
                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime  intervalStart,
                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime intervalEnd){
        return machineService.listAll(machineTag, intervalStart, intervalEnd);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Machine> stopMachineHalt(@PathVariable Integer id, @RequestBody StopMachineHoltDTO stopMachineHoltDTO){
        return new ResponseEntity<>(machineService.stopMachineHalt(id, stopMachineHoltDTO), HttpStatus.OK);
    }

    @PutMapping(path = "/reason/{id}")
    public ResponseEntity<Machine> reasonStop(@PathVariable Integer id, @RequestBody MachineReasonDTO machineReasonDTO){
        return new ResponseEntity<>(machineService.reasonStop(id, machineReasonDTO), HttpStatus.OK);
    }

    @DeleteMapping(path = "/all")
    public ResponseEntity<?> deleteAllStop(){
         machineService.deleteAllStop();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        machineService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}