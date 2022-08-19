package ubivis.teste.paradademaquinas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubivis.teste.paradademaquinas.exception.ResourceNotFoundException;
import ubivis.teste.paradademaquinas.model.dto.MachineCreateDTO;
import ubivis.teste.paradademaquinas.model.dto.StopMachineHoltDTO;
import ubivis.teste.paradademaquinas.model.dto.MachineReasonDTO;
import ubivis.teste.paradademaquinas.model.entities.Machine;
import ubivis.teste.paradademaquinas.repository.MachineRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public Machine create(MachineCreateDTO machineCreateDTO) {
        Machine machine = new Machine();
        machine.setMachineTag(machineCreateDTO.getMachineTag());
        machine.setStartTime(machineCreateDTO.getStartTime());
        return machineRepository.save(machine);
    }

    public Machine findById(Integer id) {
        Optional<Machine> machine = machineRepository.findById(id);

        if (machine.isEmpty()) {
            throw new ResourceNotFoundException("Machine not found for ID: " + id);
        }

        return machine.get();
    }

    public List<Machine> listAll(String machineTag, LocalDateTime intervalStart, LocalDateTime intervalEnd) {

        return machineRepository.findByMachineTagAndStartTimeAfterAndEndTimeBefore(machineTag, intervalStart, intervalEnd);
    }

    public Machine stopMachineHalt(Integer id, StopMachineHoltDTO stopMachineHoltDTO) {
        Optional<Machine> machine = machineRepository.findById(id);

        if (machine.isEmpty()) {
            throw new ResourceNotFoundException("Machine not found for ID: " + id);
        }

        Machine newEndStop = machine.get();
        newEndStop.setEndTime(stopMachineHoltDTO.getEndTime());
        return machineRepository.save(newEndStop);
    }

    public Machine reasonStop(Integer id, MachineReasonDTO machineReasonDTO) {
        Optional<Machine> machine = machineRepository.findById(id);
        if (machine.isEmpty()) {
            throw new ResourceNotFoundException("Machine not found for ID: " + id);
        }
        Machine reasonStop = machine.get();
        reasonStop.setReason(machineReasonDTO.getReason());
        return machineRepository.save(reasonStop);
    }

    public void deleteAllStop() {
        machineRepository.deleteAll();
    }

    public void deleteById(Integer id) {
        machineRepository.deleteById(id);
    }
}