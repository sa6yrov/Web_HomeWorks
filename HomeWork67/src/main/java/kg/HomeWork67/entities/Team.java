package kg.HomeWork67.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "teams")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "logo_address", nullable = false)
    private String logoAddres;

    @Column(name = "official_site", nullable = false, unique = true)
    private String officialSite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sport_type", referencedColumnName = "id")
    private SportType sportType;

    public Team(String name, String logoAddres, String officialSite, SportType sportType) {
        this.name = name;
        this.logoAddres = logoAddres;
        this.officialSite = officialSite;
        this.sportType = sportType;
    }
}
