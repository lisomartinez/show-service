package cloud.liso.showservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "show_genre",
            joinColumns = @JoinColumn(name = "genres_genre_id"),
            foreignKey = @ForeignKey(name = "fk_show_genre_show")
    )
    private List<Show> shows;

    public Genre(String genre) {
        this.name = genre;
    }

    public static Genre of(String genre) {
        return new Genre(genre);
    }
}