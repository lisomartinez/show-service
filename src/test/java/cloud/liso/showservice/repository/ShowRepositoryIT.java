package cloud.liso.showservice.repository;

//@DataMongoTest
//@ActiveProfiles("test")
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ShowRepositoryIT {

//    @Autowired
//    private ShowRepository showRepository;
//
//
//    @Test
//    void save_validShow_returnsSaveShow() {
//
//        Schedule schedule = getSchedule();
//
//        List<Genre> genres = getGenres();
//
//        Schedule scheduleExpected = Schedule.of(schedule.getDays(), LocalTime.of(22, 0));
//
//        Show expected = ShowFactory.getShowWithGenreAndSchedule(LocalDateTime.of(LocalDate.of(2010, 3, 12), LocalTime.of(22, 11, 11)), "Ended");
//
//        Show toSave = ShowFactory.getShowBase();
//        toSave.setGenres(genres);
//        toSave.setSchedule(getSchedule());
//        toSave.setStatus("Ended");
//        toSave.setLastUpdate(LocalDateTime.of(LocalDate.of(2010, 3, 12), LocalTime.of(22, 11, 11)));
//
//        Show savedShow = showRepository.save(toSave);
//
//        assertThat(savedShow).isEqualTo(expected);
//    }
//
//
//    @Test
//    void saveMultipleShows_SameGenresAlreadySaved() {
//        List<Show> expectedList = new ArrayList<>();
//
//        List<Genre> genres = getGenres();
//
//        Show show1 = Show.builder()
//                .id(1)
//                .name("Under the Dome")
//                .tvMaze("http://www.tvmaze.com/shows/1/under-the-dome")
//                .type("Scripted")
//                .language("English")
//                .genres(genres)
//                .status("Ended")
//                .runtime(60)
//                .premiered(LocalDate.of(2013, 6, 24))
//                .officialSite("http://www.cbs.com/shows/under-the-dome/")
//                .schedule(getSchedule())
//                .imdb("https://www.imdb.com/title/tt1553656/")
//                .image("http://static.tvmaze.com/uploads/images/original_untouched/0/1.jpg")
//                .summary("Under the Dome is the story of a small town that is suddenly and inexplicably sealed off " +
//                        "of the rest of the world by an enormous transparent dome. The town's inhabitants must " +
//                        "deal with surviving the post-apocalyptic conditions while searching for answers about the " +
//                        "dome, where it came of and if and when it will go away.")
//                .lastUpdate(LocalDateTime.of(LocalDate.of(2010, 3, 12), LocalTime.of(22, 11, 11)))
//                .build();
//
//        expectedList.add(show1);
//
//        List<Show> savedShowLists = new ArrayList<>();
//
//        Show savedShow1 = showRepository.save(show1);
//        savedShowLists.add(savedShow1);
//
//        Show show2 = Show.builder()
//                .id(2)
//                .name("Person of Interest")
//                .tvMaze("http://www.tvmaze.com/shows/2/person-of-interest")
//                .type("Scripted")
//                .language("English")
//                .genres(genres)
//                .status("Ended")
//                .runtime(60)
//                .premiered(LocalDate.of(2011, 9, 22))
//                .officialSite("http://www.cbs.com/shows/under-the-dome/")
//                .schedule(getSchedule())
//                .imdb("https://www.imdb.com/title/tt1839578")
//                .image("\"http://static.tvmaze.com/uploads/images/original_untouched/163/407679.jpg")
//                .summary("<p>You are being watched. The government has a secret system, a machine that spies " +
//                        "on you every hour of every day. I know because I built it. I designed the Machine to detect " +
//                        "acts of terror but it sees everything. Violent crimes involving ordinary people. " +
//                        "People like you. Crimes the government considered \\\"irrelevant\\\". " +
//                        "They wouldn't act so I decided I would. But I needed a partner. Someone with the " +
//                        "skills to intervene. Hunted by the authorities, we work in secret. You'll never find us." +
//                        " But victim or perpetrator, if your number is up, we'll find you.</p>")
//                .lastUpdate(LocalDateTime.of(LocalDate.of(2010, 3, 12), LocalTime.of(22, 11, 11)))
//                .build();
//
//        expectedList.add(show2);
//
//        Show savedShow2 = showRepository.save(show2);
//        savedShowLists.add(savedShow2);
//    }
//
//    @Test
//    void findSeasonById() throws IOException {
//        Season seasonOne = ShowFactory.getSeasons().get(0);
//
//        Show show = ShowFactory.getShowComplete(LocalDateTime.now(), "Ended");
//        show.setSchedule(getSchedule());
//        show.setGenres(getGenres());
//        show = mongoTemplate.save(show);
//
//        Optional<Season> result = showRepository.findSeasonById(show.getId(), 1);
//
//        assertThat(result.get()).isEqualTo(seasonOne);
//    }
//
//    @Test
//    void getLastUpdate_ValidShowId_ShouldReturnLocalDateTime() {
//
//        LocalDateTime expected = LocalDateTime.of(LocalDate.of(2010, 3, 12), LocalTime.of(22, 11, 11));
//
//        Show show = ShowFactory.getShowBase();
//        show.setGenres(getGenres());
//        show.setSchedule(getSchedule());
//        show.setStatus("Ended");
//        show.setLastUpdate(LocalDateTime.of(LocalDate.of(2010, 3, 12), LocalTime.of(22, 11, 11)));
//
//        mongoTemplate.save(show);
//
//        LocalDateTime lastUpdate = showRepository.getShowLastUpdate(show.getId()).get();
//
//        assertThat(lastUpdate).isEqualTo(expected);
//    }
//
//    private Schedule getSchedule() {
//        return Schedule.of(new ArrayList<>(Arrays.asList("Thursday")), LocalTime.of(22, 0));
//    }
//
//    private List<Genre> getGenres() {
//        List<Genre> genres = ShowFactory.getGenres();
//        return genres.stream()
//                .map(mongoTemplate::save)
//                .collect(Collectors.toList());
//    }
}