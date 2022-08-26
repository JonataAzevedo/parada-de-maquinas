package ubivis.teste.paradademaquinas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ubivis.teste.paradademaquinas.model.entities.Machine;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Integer> {

    List<Machine> findByMachineTagAndStartTimeAfterAndEndTimeBefore(String machineTag, LocalDateTime intervalStart, LocalDateTime intervalEnd);

    @Query(value = "SELECT * FROM machine WHERE machine_tag LIKE :machineTag ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Optional<Machine> findMastRecentByMachineTag(String machineTag);


    Optional<Machine> findByMachineTag(String machineTag);
}
