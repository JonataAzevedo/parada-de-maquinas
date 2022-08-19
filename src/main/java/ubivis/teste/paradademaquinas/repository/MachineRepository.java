package ubivis.teste.paradademaquinas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ubivis.teste.paradademaquinas.model.entities.Machine;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Integer> {

    List<Machine> findByMachineTagAndStartTimeAfterAndEndTimeBefore(String machineTag, LocalDateTime intervalStart, LocalDateTime intervalEnd);
}
