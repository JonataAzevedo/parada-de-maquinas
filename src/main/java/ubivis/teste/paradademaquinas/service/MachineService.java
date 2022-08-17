package ubivis.teste.paradademaquinas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ubivis.teste.paradademaquinas.model.dto.MachineDTO;
import ubivis.teste.paradademaquinas.model.entities.Machine;
import ubivis.teste.paradademaquinas.repository.MachineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public Machine create(MachineDTO machineDTO){
        Machine machine = new Machine();
        machine.setMachineTag(machineDTO.getMachineTag());
        machine.setStartTime(machineDTO.getStartTime());
        return machineRepository.save(machine);
    }

    public ResponseEntity<Machine> findById(Integer id){
        Optional<Machine> machine = machineRepository.findById(id);
        if(machine.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(machine.get());
    }

    public List<Machine> machineList(){
        return machineRepository.findAll();
    }

    public Machine endstop(Integer id, MachineDTO machineDTO){
        Optional<Machine> machine = machineRepository.findById(id);
        if(machine.isEmpty()){
            return null;
        }
        Machine newMachine = machine.get();
        newMachine.setEndTime(machineDTO.getEndTime());
        return machineRepository.save(newMachine);
    }
}