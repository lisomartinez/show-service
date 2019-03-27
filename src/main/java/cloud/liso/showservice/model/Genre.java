package cloud.liso.showservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public Genre(String genre) {
        this.name = genre;
    }

    public static Genre of(String genre) {
        return new Genre(genre);
    }
}