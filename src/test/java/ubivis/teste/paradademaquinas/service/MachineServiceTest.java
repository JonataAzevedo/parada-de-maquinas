package ubivis.teste.paradademaquinas.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import ubivis.teste.paradademaquinas.ParadaDeMaquinasApplicationTests;
import ubivis.teste.paradademaquinas.exception.ResourceNotFoundException;
import ubivis.teste.paradademaquinas.model.dto.MachineCreateDTO;
import ubivis.teste.paradademaquinas.model.entities.Machine;
import ubivis.teste.paradademaquinas.repository.MachineRepository;


import java.time.LocalDateTime;
import java.util.Optional;

@DisplayName("Machine service teste")
public class MachineServiceTest extends ParadaDeMaquinasApplicationTests {

    @Autowired
    private MachineService machineService;

    @MockBean
    private MachineRepository machineRepository;

    @BeforeEach
    public void init() {
        Machine machineMock = Machine.builder()
                .machineTag("TAG")
                .startTime(LocalDateTime.MIN)
                .id(13)
                .build();
        Machine machineToCreate = Machine.builder()
                .machineTag("TAG")
                .startTime(LocalDateTime.MIN)
                .build();

        Mockito.when(machineRepository.save(machineToCreate)).thenReturn(machineMock);
        Mockito.when(machineRepository.findById(13)).thenReturn(Optional.of(machineMock));
        Mockito.when(machineRepository.findById(15)).thenReturn(Optional.empty());
    }

    @Test
    public void test_create() {
        MachineCreateDTO machineCreateDTO = new MachineCreateDTO("TAG", LocalDateTime.MIN);

        Machine machine = machineService.create(machineCreateDTO);

        Assertions.assertThat(machine).isNotNull();
        Assertions.assertThat(machine.getEndTime()).isNull();
        Assertions.assertThat(machine.getMachineTag()).isEqualTo("TAG");
        Assertions.assertThat(machine.getId()).isNotNull();
    }

    @Test
    public void test_findById() {
        Machine machine = machineService.findById(13);

        Assertions.assertThat(machine).isNotNull();
        Assertions.assertThat(machine.getId()).isEqualTo(13);
        Assertions.assertThat(machine.getMachineTag()).isEqualTo("TAG");
    }

    @Test
    public void test_findById_NotFound() {
        try {
            machineService.findById(15);
        } catch (ResourceNotFoundException exception) {
            Assertions.assertThat(exception.getMessage()).isEqualTo("Machine not found for ID: 15");
        }
    }
}

