package ubivis.teste.paradademaquinas.model.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MachineCreateDTO {

    @NotNull
    private String machineTag;

    @NotNull
    private LocalDateTime startTime;
}
