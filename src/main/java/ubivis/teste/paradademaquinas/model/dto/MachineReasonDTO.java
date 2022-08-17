package ubivis.teste.paradademaquinas.model.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MachineReasonDTO {

    @NotNull
    Integer id;

    @NotNull
    String reason;
}
