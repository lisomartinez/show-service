package cloud.liso.showservice.utils;

import cloud.liso.showservice.model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowFactory {


    public static int getShowId() {
        return 1;
    }

    public static int getSeasonId() {
        return 3;
    }


    public static Show getShowBase() {
        return Show.builder()
                .id(1)
                .name("Under the Dome")
                .tvMaze("http://www.tvmaze.com/shows/1/under-the-dome")
                .type("Scripted")
                .language("English")
                .runtime(60)
                .premiered(LocalDate.of(2013, 6, 24))
                .officialSite("http://www.cbs.com/shows/under-the-dome/")
                .imdb("https://www.imdb.com/title/tt1553656")
                .image("http://static.tvmaze.com/uploads/images/original_untouched/81/202627.jpg")
                .summary("Under the Dome is the story of a small town that is suddenly and inexplicably sealed off from the rest of the world by an enormous transparent dome. The town's inhabitants must deal with surviving the post-apocalyptic conditions while searching for answers about the dome, where it came from and if and when it will go away.")
                .build();
    }

    public static Show getShowWithGenreAndSchedule(LocalDateTime lastUpdate, String status) {
        Show show = getShowBase();
        show.setSchedule(getScheduleWithId());
        show.setGenres(getGenresWithId());
        show.setLastUpdate(lastUpdate);
        show.setStatus(status);
        return show;
    }

    private static List<Genre> getGenresWithId() {
        Genre drama = new Genre("Drama");
        Genre science_fiction = new Genre("Science-Fiction");
        Genre thriller = new Genre("Thriller");
        return Arrays.asList(drama, science_fiction, thriller);
    }

    private static Schedule getScheduleWithId() {
        return new Schedule(new ArrayList<>(Arrays.asList(DayOfWeek.of(DayOfWeek.THURSDAY))), LocalTime.of(22, 0));
    }

    public static Show getShowComplete(LocalDateTime lastUpdate, String status) throws IOException {
        Show show = getShowBase();
        show.setSchedule(getSchedule());
        show.setGenres(getGenres());
        show.setLastUpdate(lastUpdate);
        show.setStatus(status);

//        List<Season> seasons = getSeasons();
        //set seasons episodes
//        seasons.get(2).setEpisodes(getEpisodesFromSeason(3));
//        show.setSeasons(seasons);

        return show;
    }


    public static Show getShowWithOutSeasons(LocalDateTime lastUpdate, String status) throws IOException {
        Show show = getShowBase();
        show.setSchedule(getSchedule());
        show.setGenres(getGenres());
        show.setLastUpdate(lastUpdate);
        show.setStatus(status);
        List<Season> seasons = new ArrayList<>();
        show.setSeasons(seasons);
        return show;
    }

    public static Show getShowUptodateAiring() throws IOException {
        return getShowComplete(LocalDateTime.now(), "Airing");
    }

    public static Show getShowUptodateAiringWithoutSeasons() throws IOException {
        return getShowWithOutSeasons(LocalDateTime.now().withNano(0), "Airing");
    }

    public static Show getShowUptodateEnded() throws IOException {
        return getShowComplete(LocalDateTime.now().withNano(0), "Ended");
    }

    public static Show getShowUptodateEndedWithOutSeasons() throws IOException {
        return getShowWithOutSeasons(LocalDateTime.now().withNano(0), "Ended");
    }

    public static Show getShowOutdatedEndedWithOutSeasonsAsSavedInDB() throws IOException {
        Show show = getShowWithOutSeasons(LocalDateTime.now().withNano(0), "Ended");
//        show.getGenres().get(0).setId(1);
//        show.getGenres().get(1).setId(2);
//        show.getGenres().get(2).setId(3);
//        show.getSchedule().setId(1);
        show.getSchedule().setDays(new ArrayList<>(Arrays.asList(DayOfWeek.of(DayOfWeek.THURSDAY))));
        return show;

    }


    public static Show getShowOutdatedAiring() throws IOException {
        return getShowComplete(LocalDateTime.now().minusHours(2).minusNanos(0), "Airing");
    }

    public static Show getShowOutdatedAiringWithoutSeasons() throws IOException {
        return getShowWithOutSeasons(LocalDateTime.now().minusHours(2).withNano(0), "Airing");
    }

    public static Show getShowOutdatedEnded() throws IOException {
        return getShowComplete(LocalDateTime.now().minusHours(2).withNano(0), "Ended");
    }

    public static Show getShowOutdatedEndedWithoutSeasons() throws IOException {
        return getShowWithOutSeasons(LocalDateTime.now().minusHours(2).withNano(0), "Ended");
    }

    public static Schedule getSchedule() {
        return Schedule.of(new ArrayList<>(Arrays.asList(DayOfWeek.of(DayOfWeek.THURSDAY))), LocalTime.of(22, 0));
    }

    public static List<Genre> getGenres() {
        Genre drama = Genre.of("Drama");
        Genre science_fiction = Genre.of("Science-Fiction");
        Genre thriller = Genre.of("Thriller");
        return Arrays.asList(drama, science_fiction, thriller);
    }

    public static List<Season> getSeasons(Show show) {
        Season seasonOne = Season.builder()
                .id(1)
                .show(show)
                .number(1)
                .episodeOrder(13)
                .premiereDate(LocalDate.of(2013, 6, 24))
                .endDate(LocalDate.of(2013, 9, 16))
                .image("http://static.tvmaze.com/uploads/images/original_untouched/24/60941.jpg")
                .tvMaze("http://www.tvmaze.com/seasons/1/under-the-dome-season-1")
                .summary("N/A")
                .build();

        Season seasonTwo = Season.builder()
                .id(2)
                .show(show)
                .number(2)
                .episodeOrder(13)
                .premiereDate(LocalDate.of(2014, 6, 30))
                .endDate(LocalDate.of(2014, 9, 22))
                .image("http://static.tvmaze.com/uploads/images/original_untouched/24/60942.jpg")
                .tvMaze("http://www.tvmaze.com/seasons/2/under-the-dome-season-2")
                .summary("N/A")
                .build();

        Season seasonThree = Season.builder()
                .id(6233)
                .show(show)
                .number(3)
                .episodeOrder(13)
                .premiereDate(LocalDate.of(2015, 6, 25))
                .endDate(LocalDate.of(2015, 9, 10))
                .image("http://static.tvmaze.com/uploads/images/original_untouched/182/457332.jpg")
                .tvMaze("http://www.tvmaze.com/seasons/6233/under-the-dome-season-3")
                .summary("N/A")
                .build();

        List<Season> seasons = new ArrayList<>();
        seasons.add(seasonOne);
        seasons.add(seasonTwo);
        seasons.add(seasonThree);
        return seasons;
    }

//    public static Season getLastSeasonWithEpisodes(Show show) throws IOException {
//        return Season.builder()
//                .id(6233)
//                .show(show)
//                .number(3)
//                .episodeOrder(13)
//                .premiereDate(LocalDate.of(2015, 6, 25))
//                .endDate(LocalDate.of(2015, 9, 10))
//                .image("http://static.tvmaze.com/uploads/images/original_untouched/182/457332.jpg")
//                .tvMaze("http://www.tvmaze.com/seasons/6233/under-the-dome-season-3")
//                .summary("N/A")
//                .episodes(getEpisodesFromSeason(3))
//                .build();
//    }

    public static Season createLastSeasonWithoutEpisodes(Show show) throws IOException {
        return Season.builder()
                .id(6233)
                .show(show)
                .number(3)
                .episodeOrder(13)
                .premiereDate(LocalDate.of(2015, 6, 25))
                .endDate(LocalDate.of(2015, 9, 10))
                .image("http://static.tvmaze.com/uploads/images/original_untouched/182/457332.jpg")
                .tvMaze("http://www.tvmaze.com/seasons/6233/under-the-dome-season-3")
                .summary("N/A")
                .build();
    }
//
//    public static List<Episode> getEpisodesFromSeason(int id) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        File episodes = null;
//        switch(id) {
//            case 1:
//                episodes = JsonTestFiles.getSeason1Episodes();
//                break;
//            case 2:
//                episodes = JsonTestFiles.getSeason2Episodes();
//                break;
//            case 3:
//                episodes = JsonTestFiles.getSeason6233Episodes();
//                break;
//
//        }
//        List<TvMazeEpisodeDto> episodeDtoList = objectMapper.readValue(episodes, new TypeReference<List<TvMazeEpisodeDto>>() {
//        });
//        ModelMapper modelMapper = new ModelMapper();
//        return episodeDtoList.stream()
//                .map(ep -> modelMapper.map(ep, Episode.class))
//                .collect(Collectors.toList());
//    }

//    public static List<Season> getSeasonsWithEpisodes() throws IOException {
//        List<Season> seasons = getSeasons();
//        seasons.get(0).setEpisodes(getEpisodesFromSeason(1));
//        seasons.get(1).setEpisodes(getEpisodesFromSeason(2));
//        seasons.get(2).setEpisodes(getEpisodesFromSeason(3));
//        return seasons;
//    }
}
