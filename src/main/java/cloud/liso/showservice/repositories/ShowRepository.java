package cloud.liso.showservice.repositories;

import cloud.liso.showservice.dto.ShowCardDto;
import cloud.liso.showservice.model.Show;
import cloud.liso.showservice.model.ShowCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShowRepository extends JpaRepository<Show, Integer>, QuerydslPredicateExecutor<Show> {

    @Query("SELECT new cloud.liso.showservice.dto.ShowCardDto(" +
            "show.id, show.name, show.image, show.rating, count(show.id)) " +
            "FROM Show show INNER JOIN Season season ON show.id = season.show" +
            " GROUP BY show.id ORDER BY show.id")
    Page<ShowCardDto> getShowCardPage(PageRequest pageRequest);

    @Query(value = "SELECT\n" +
            "       SH2.genre_name,\n" +
            "       SH1.show_id,\n" +
            "       SH1.name,\n" +
            "       SH1.image_url,\n" +
            "       SH1.rating,\n" +
            "       (SELECT count(*) FROM season SE1 WHERE SE1.show_id = SH1.show_id) as seasons\n" +
            "FROM shows SH1\n" +
            "INNER JOIN\n" +
            "    (SELECT genre_name, show_id\n" +
            "        FROM\n" +
            "            (SELECT SG1.genres_genre_id as genre_id,\n" +
            "                G2.name as genre_name,\n" +
            "                shows_show_id as show_id,\n" +
            "                dense_rank() over\n" +
            "                    (partition by SG1.genres_genre_id order by SG1.shows_show_id)\n" +
            "                    AS row_nums\n" +
            "            FROM genres G2\n" +
            "            INNER JOIN show_genre SG1 on G2.genre_id = SG1.genres_genre_id) AS genres\n" +
            "        WHERE genres.row_nums <= 5\n" +
            "    ) as SH2 on SH1.show_id = SH2.show_id\n" +
            "ORDER BY SH2.genre_name, SH1.show_id;", nativeQuery = true, name = "getShowCards")
    List<ShowCard> getShowCards();
}
