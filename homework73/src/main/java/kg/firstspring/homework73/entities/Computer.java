package kg.firstspring.homework73.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Entity
@Table(name = "computers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "cpu_brand")
    String cpu;

    @Column(name = "gpu_brand")
    String gpu;

    @Column(name = "ram_capacity")
    String ramCapacity;

    @Column(name = "hdd_capacity")
    String hddCapacity;

    @Column(name = "power_supply_capacity")
    String powerSupplyCapacity;

    @Column(name = "monitor_brand")
    String monitor;


}
