package ubivis.teste.paradademaquinas.paradademaquinas.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import ubivis.teste.paradademaquinas.ApplicationConfigTest;
import ubivis.teste.paradademaquinas.model.dto.MachineCreateDTO;
import ubivis.teste.paradademaquinas.model.entities.Machine;
import ubivis.teste.paradademaquinas.repository.MachineRepository;
import ubivis.teste.paradademaquinas.service.MachineService;

import java.time.LocalDateTime;

@DisplayName("Machine service teste")
public class MachineServiceTest extends ApplicationConfigTest {

    @MockBean
    private MachineRepository repository;

    @Autowired
    private MachineService service;

    @Test
    @DisplayName("Deve salvar parada")
    void salvarParada(){

        //arrange
        LocalDateTime now = LocalDateTime.now();
        MachineCreateDTO machine = new MachineCreateDTO();

        machine.setMachineTag("Teste parada");
        machine.setStartTime(now);

        //action
        Machine machineCreated = service.create(machine);

        //assertions

        Assertions.assertThat(machineCreated.getStartTime()).isNotNull();
        Assertions.assertThat(machineCreated.getMachineTag()).isNotNull();
    }
}
