package kg.HomeWork67.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "championships")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Championship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_country", referencedColumnName = "id")
    private Country country;

    @Column(name = "championship_name", nullable = false, unique = true)
    private String ChampionshipName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sport_type", referencedColumnName = "id")
    private SportType sportType;

    public Championship(Country country, String championshipName, SportType sportType) {
        this.country = country;
        ChampionshipName = championshipName;
        this.sportType = sportType;
    }
}
