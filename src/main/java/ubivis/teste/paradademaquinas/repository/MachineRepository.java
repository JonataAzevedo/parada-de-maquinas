package ubivis.teste.paradademaquinas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ubivis.teste.paradademaquinas.model.entities.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Integer> {
}
