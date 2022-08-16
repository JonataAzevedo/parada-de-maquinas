package ubivis.teste.paradademaquinas.model.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String machineTag;

    @NotNull
    @Column(nullable = false)
    private LocalDate startTime;

    @NotNull
    @Column(nullable = false)
    private Date endTime;

    @NotNull
    @Column(nullable = false)
    private String reason;
}
