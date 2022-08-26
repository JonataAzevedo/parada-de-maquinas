package ubivis.teste.paradademaquinas.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@AllArgsConstructor
@Getter
public class ResourceConflictDetails {

    private String title;

    private Integer status;

    private String detail;

    private long timestamp;

    private String message;

    private ResourceConflictDetails(){

    }
}
