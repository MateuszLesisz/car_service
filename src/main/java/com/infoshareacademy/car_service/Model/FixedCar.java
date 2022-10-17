package com.infoshareacademy.car_service.Model;

import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = FixedCar.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FixedCar {

    public static final String TABLE_NAME = "fixed_car";

    public static final String COLUMN_PREFIX = "fc_";

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fixedId;

    @OneToOne
    @JoinColumn(name = "bc_id")
    private BrokenCar brokenId;

    @Column(name = "fixed", nullable = false)
    private boolean isFixed;
}
