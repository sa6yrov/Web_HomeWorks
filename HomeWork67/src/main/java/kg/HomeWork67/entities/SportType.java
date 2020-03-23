package kg.HomeWork67.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "type_of_sport")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SportType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type", nullable = false, length = 56)
    private String type;

    public SportType(String type) {
        this.type = type;
    }
}
