package kg.HomeWork67.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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
    private String logoAddress;

    @Column(name = "official_site", nullable = false, unique = true)
    private String officialSite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sport_type", referencedColumnName = "id")
    private SportType sportType;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "championship_teams",
            joinColumns = {@JoinColumn(name = "team_id")},
            inverseJoinColumns = {@JoinColumn(name = "championship_id")}
            )
    private List<Championship> championships;


    public Team(String name, String logoAddress, String officialSite, SportType sportType) {
        this.name = name;
        this.logoAddress = logoAddress;
        this.officialSite = officialSite;
        this.sportType = sportType;
    }

    public Team(String name, SportType sportType, List<Championship> championships){
        this.name = name;
        this.sportType = sportType;
        this.championships = championships;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logoAddress='" + logoAddress + '\'' +
                ", officialSite='" + officialSite + '\'' +
                ", sportType=" + sportType +
                ", championships=" + championships +
                '}';
    }
}
