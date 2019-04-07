package cloud.liso.showservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cards")
public class ShowCard {

    @Id
    @Column(name = "id")
    private String ShowCardId;

    @Column(name = "show_id")
    private int id;

    @Column(name = "genre_name")
    private String genre;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String image;

    @Column(name = "rating")
    private double rating;

    @Column(name = "seasons")
    private long seasons;

}
