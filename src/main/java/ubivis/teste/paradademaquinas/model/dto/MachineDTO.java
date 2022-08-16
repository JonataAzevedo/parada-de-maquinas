package ubivis.teste.paradademaquinas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MachineDTO {

    private String machineTag;

    LocalDate startTime = LocalDate.now();

    private Date endTime;

    private String reason;
}
