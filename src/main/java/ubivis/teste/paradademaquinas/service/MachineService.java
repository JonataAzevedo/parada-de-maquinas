package ubivis.teste.paradademaquinas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ubivis.teste.paradademaquinas.model.dto.MachineCreateDTO;
import ubivis.teste.paradademaquinas.model.dto.MachineEndStopDTO;
import ubivis.teste.paradademaquinas.model.dto.MachineReasonDTO;
import ubivis.teste.paradademaquinas.model.entities.Machine;
import ubivis.teste.paradademaquinas.repository.MachineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public Machine create(MachineCreateDTO machineCreateDTO){
        Machine machine = new Machine();
        machine.setMachineTag(machineCreateDTO.getMachineTag());
        machine.setStartTime(machineCreateDTO.getStartTime());
        return machineRepository.save(machine);
    }

    public ResponseEntity<Machine> findById(Integer id){
        Optional<Machine> machine = machineRepository.findById(id);

        if(machine.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(machine.get());
    }

    public List<Machine> machineListAll(){
        return machineRepository.findAll();
    }

    public Machine endStop(Integer id, MachineEndStopDTO machineEndStopDTO){
        Optional<Machine> machine = machineRepository.findById(id);
        if(machine.isEmpty()){
            return null;
        }
        Machine newEndStop = machine.get();
        newEndStop.setEndTime(machineEndStopDTO.getEndTime());
        return machineRepository.save(newEndStop);
    }

    public Machine reasonStop(Integer id, MachineReasonDTO machineReasonDTO){
        Optional<Machine> machine = machineRepository.findById(id);
        if(machine.isEmpty()){
            return null;
        }
        Machine reasonStop = machine.get();
        reasonStop.setReason(machineReasonDTO.getReason());
        return machineRepository.save(reasonStop);
    }

    public void deleteAllStop(){
        machineRepository.deleteAll();
    }

    public void  deleteById(Integer id){
        machineRepository.deleteById(id);
    }
}