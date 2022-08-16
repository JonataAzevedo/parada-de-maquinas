package ubivis.teste.paradademaquinas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ubivis.teste.paradademaquinas.model.dto.MachineDTO;
import ubivis.teste.paradademaquinas.model.entities.Machine;
import ubivis.teste.paradademaquinas.repository.MachineRepository;

import java.util.Optional;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public Machine create(MachineDTO machineDTO){
    Machine machine = new Machine();
    machine.setMachineTag(machineDTO.getMachineTag());
        return machineRepository.save(machine);
    }

    public ResponseEntity<Machine> findById(Integer id){
        Optional<Machine> machine = machineRepository.findById(id);
        if(machine.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(machine.get());
    }
}
