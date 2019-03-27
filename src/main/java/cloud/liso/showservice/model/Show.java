package cloud.liso.showservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "show")
public class Show {

    @Id
    @Column(name = "show_id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "language", nullable = false)
    private String language;

    @ManyToMany
    @JoinTable(name = "show_genre",
            joinColumns = @JoinColumn(name = "show_id"),
            foreignKey = @ForeignKey(name = "fk_show_genre_genre"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"),
            inverseForeignKey = @ForeignKey(name = "fk_show_genre_show")
    )
    private List<Genre> genres;


    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "runtime", nullable = false)
    private int runtime;

    @Column(name = "premiered", nullable = false)
    private LocalDate premiered;

    @Column(name = "official_site_url", nullable = false)
    private String officialSite;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "schedule_id", foreignKey = @ForeignKey(name = "fk_show_schedule_id"),
            nullable = false,
            unique = true)
    private Schedule schedule;

    @Column(name = "imdb_url", nullable = false)
    private String imdb;

    @Column(name = "tv_maze_url", nullable = false)
    private String tvMaze;

    @Column(name = "image_url", nullable = false)
    private String image;

    @Column(name = "summary", nullable = false, length = 5000)
    private String summary;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "show")
    private List<Season> seasons;

    public void addSeason(Season season) {
        seasons.add(season);
        season.setShow(this);
    }

    public void removeSeason(Season season) {
        seasons.remove(season);
        season.setShow(null);
    }
}
    
