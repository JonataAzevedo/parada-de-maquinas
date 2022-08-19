package ubivis.teste.paradademaquinas.exception;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@Getter
public class ResourceNotFoundDetails {

    private String title;

    private Integer status;

    private String detail;

    private long timestamp;

    private String developerMessage;

    private ResourceNotFoundDetails(){

    }
}
