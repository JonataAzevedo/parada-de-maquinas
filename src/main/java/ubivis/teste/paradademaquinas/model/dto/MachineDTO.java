package ubivis.teste.paradademaquinas.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MachineDTO {

    private String machineTag;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String reason;
}
