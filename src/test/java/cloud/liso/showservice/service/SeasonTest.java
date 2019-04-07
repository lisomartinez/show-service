package cloud.liso.showservice.service;

//@ExtendWith(MockitoExtension.class)
public class SeasonTest {

//    private ShowService showService;
//
//
//    //    private Show show;
//    @Mock
//    private ShowRepository showRepository;
//
//    @Mock
//    private TvMazeService tvMazeService;
//
//
//    @BeforeEach
//    void setUp() {
//        showService = new ShowServiceImpl(showRepository, tvMazeService);
//    }
//
//    @Test
//    void getSeason_UpToDateStatusNotEndedEmpty_ShouldReturnSeasonFromShowInDB() throws IOException {
//
//        Show show = ShowFactory.getShowUptodateAiringWithoutSeasons();
//
//        Season three = ShowFactory.getLastSeasonWithEpisodes();
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//        Season result = showService.getSeasonById(show.getId(), 3);
//        assertThat(result).isEqualTo(three);
//    }
//
//
//    @Test
//    void getSeason_UpToDateStatusEndedtNotEmpty_ShouldReturnSeasonFromDB() throws IOException {
//        Show show = ShowFactory.getShowUptodateEnded();
//        Season seasonThree = ShowFactory.getLastSeasonWithEpisodes();
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//        Season result = showService.getSeasonById(show.getId(), 3);
//        assertThat(result).isEqualTo(seasonThree);
//    }
//
//    @Test
//    void getSeason_UpToDateStatusEndedEmpty_ShouldReturnSeasonFromDB() throws IOException {
//        Show show = ShowFactory.getShowUptodateAiringWithoutSeasons();
//        Season seasonThree = ShowFactory.getLastSeasonWithEpisodes();
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//        Season result = showService.getSeasonById(show.getId(), 3);
//        assertThat(result).isEqualTo(seasonThree);
//    }
//
//    @Test
//    void getSeason_OutdatedNotEndedEmpty_ShouldCallTvMaze() throws IOException {
//
//        Show show = ShowFactory.getShowOutdatedAiringWithoutSeasons();
//
//        List<Season> seasons = ShowFactory.getSeasons();
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//
//        when(tvMazeService.getShowById(show.getId())).thenReturn(show);
//
//        when(tvMazeService.getSeasons(show.getId())).thenReturn(seasons);
//        when(showRepository.save(show)).thenReturn(show);
//
//        showService.getSeasonById(show.getId(), 3);
//
//        InOrder inOrder = Mockito.inOrder(tvMazeService);
//        inOrder.verify(tvMazeService).getShowById(show.getId());
//        inOrder.verify(tvMazeService).getSeasons(show.getId());
//    }
//
//    @Test
//    void getSeason_OutdatedNotEndedEmpty_ShouldReturnSeasonFromTvMazeService() throws IOException {
//
//        Show show = ShowFactory.getShowOutdatedAiringWithoutSeasons();
//
//        List<Season> seasons = ShowFactory.getSeasonsWithEpisodes();
//
////        seasons.stream().map(Season::getEpisodes).forEach(ep -> assertThat(ep.size()).isEqualTo(13));
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//
//        when(tvMazeService.getShowById(show.getId())).thenReturn(ShowFactory.getShowUptodateAiringWithoutSeasons());
//        when(showRepository.save(show)).thenReturn(show);
//
//        when(tvMazeService.getSeasons(show.getId())).thenReturn(seasons);
//        when(showRepository.save(ShowFactory.getShowUptodateAiring())).thenReturn(ShowFactory.getShowUptodateAiring());
//
//        Season lastSeason = showService.getSeasonById(show.getId(), 3);
//        assertThat(lastSeason).isEqualTo(ShowFactory.getLastSeasonWithEpisodes());
//
//    }
//
//
//    @Test
//    void getSeason_OutdatedNotEndedNotEmptyEqualsSeasons_ShouldCallTvMaze() throws IOException {
//
//        Show show = ShowFactory.getShowOutdatedAiring();
//
//        List<Season> seasons = ShowFactory.getSeasonsWithEpisodes();
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//
//        when(tvMazeService.getShowById(show.getId())).thenReturn(show);
//
//        when(tvMazeService.getSeasons(show.getId())).thenReturn(seasons);
//        when(showRepository.save(show)).thenReturn(show);
//
//        showService.getSeasonById(show.getId(), 3);
//
//        InOrder inOrder = Mockito.inOrder(tvMazeService);
//        inOrder.verify(tvMazeService).getShowById(show.getId());
//        inOrder.verify(tvMazeService).getSeasons(show.getId());
//    }
//
//    @Test
//    void getSeason_OutdatedNotEndedNotEmptyEqualsSeasons_ShouldReturnSeasonFromTvMazeService() throws IOException {
//
//        Show show = ShowFactory.getShowOutdatedAiring();
//
//        List<Season> seasons = ShowFactory.getSeasons();
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//
//        when(tvMazeService.getShowById(show.getId())).thenReturn(show);
//
//        when(tvMazeService.getSeasons(show.getId())).thenReturn(seasons);
//        when(showRepository.save(show)).thenReturn(show);
//
//        Season lastSeason = showService.getSeasonById(show.getId(), 3);
//        assertThat(lastSeason).isEqualTo(ShowFactory.getLastSeasonWithEpisodes());
//
//    }
//
//    @Test
//    void getSeason_OutdatedNotEndedNotEmptyLessSeasons_ShouldCallTvMaze() throws IOException {
//
//        Show show = ShowFactory.getShowOutdatedAiring();
//        show.getSeasons().remove(2);
//
//        List<Season> seasons = ShowFactory.getSeasons();
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//
//        when(tvMazeService.getShowById(show.getId())).thenReturn(show);
//
//        when(tvMazeService.getSeasons(show.getId())).thenReturn(seasons);
//        when(showRepository.save(show)).thenReturn(show);
//
//        showService.getSeasonById(show.getId(), 3);
//
//        InOrder inOrder = Mockito.inOrder(tvMazeService);
//        inOrder.verify(tvMazeService).getShowById(show.getId());
//        inOrder.verify(tvMazeService).getSeasons(show.getId());
//    }
//
//    @Test
//    void getSeason_OutdatedNotEndedNotEmptyLessSeason_ShouldReturnSeasonFromTvMazeService() throws IOException {
//
//        Show show = ShowFactory.getShowOutdatedAiring();
//        show.getSeasons().remove(2);
//
//        List<Season> seasons = ShowFactory.getSeasons();
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//
//        when(tvMazeService.getShowById(show.getId())).thenReturn(show);
//
//        when(tvMazeService.getSeasons(show.getId())).thenReturn(seasons);
//        when(showRepository.save(show)).thenReturn(show);
//
//        Season lastSeason = showService.getSeasonById(show.getId(), 3);
//        assertThat(lastSeason).isEqualTo(ShowFactory.getLastSeasonWithEpisodes());
//
//    }
//
//
///////
//@Test
//void getSeason_OutdatedEndedEmpty_ShouldCallTvMaze() throws IOException {
//
//    Show show = ShowFactory.getShowOutdatedEndedWithoutSeasons();
//
//    List<Season> seasons = ShowFactory.getSeasons();
//
//    when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//    when(tvMazeService.getSeasons(show.getId())).thenReturn(seasons);
//    when(showRepository.save(show)).thenReturn(show);
//
//    showService.getSeasonById(show.getId(), 3);
//
//    InOrder inOrder = Mockito.inOrder(tvMazeService);
//    inOrder.verify(tvMazeService).getSeasons(show.getId());
//}
//
//    @Test
//    void getSeason_OutdatedEndedEmpty_ShouldReturnSeasonFromTvMazeService() throws IOException {
//
//        Show show = ShowFactory.getShowOutdatedEndedWithoutSeasons();
//
//        List<Season> seasons = ShowFactory.getSeasons();
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//
//        when(tvMazeService.getShowById(show.getId())).thenReturn(show);
//
//        when(tvMazeService.getSeasons(show.getId())).thenReturn(seasons);
//        when(showRepository.save(show)).thenReturn(show);
//
//        Season lastSeason = showService.getSeasonById(show.getId(), 3);
//        assertThat(lastSeason).isEqualTo(ShowFactory.getLastSeasonWithEpisodes());
//
//    }
//
//
//    @Test
//    void getSeason_OutdatedEndedNotEmptyEqualsSeasons_ShouldReturnSeasonFromTvMazeService() throws IOException {
//
//        Show show = ShowFactory.getShowOutdatedEnded();
//
//        List<Season> seasons = ShowFactory.getSeasons();
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//
//        Season lastSeason = showService.getSeasonById(show.getId(), 3);
//        assertThat(lastSeason).isEqualTo(ShowFactory.getLastSeasonWithEpisodes());
//
//    }
//
//
//    @Test
//    void getSeason_OutdatedEndedNotEmptyLessSeason_ShouldReturnSeasonFromTvMazeService() throws IOException {
//
//        Show show = ShowFactory.getShowOutdatedEnded();
//        show.getSeasons().remove(2);
//
//        List<Season> seasons = ShowFactory.getSeasonsWithEpisodes();
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//
//        when(tvMazeService.getShowById(show.getId())).thenReturn(show);
//
//        when(tvMazeService.getSeasons(show.getId())).thenReturn(seasons);
//        when(showRepository.save(show)).thenReturn(show);
//
//        Season lastSeason = showService.getSeasonById(show.getId(), 3);
//        assertThat(lastSeason).isEqualTo(ShowFactory.getLastSeasonWithEpisodes());
//
//    }
//
//
//
//    @Test
//    void getSeason_InvalidSeasonNumberOfUptoDateShowWithStatusNotEnded_ShoudlThrowSeasonNotFoundException() throws IOException {
//        Show show = ShowFactory.getShowUptodateAiring();
//
//        final int inavlidSeasonNumber = Integer.MAX_VALUE;
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//        when(tvMazeService.getSeasons(show.getId())).thenThrow(TvMazeResourceNotFoundException.class);
//
//        assertThrows(TvMazeResourceNotFoundException.class, () -> showService.getSeasonById(show.getId(), inavlidSeasonNumber));
//    }
//
//    @Test
//    void getSeason_InvalidSeasonNumberOfOutdatedShowWithStatusNotEnded_ShoudlThrowSeasonNotFoundException() throws IOException {
//
//        Show show = ShowFactory.getShowOutdatedAiring();
//
//        final int inavlidSeasonNumber = Integer.MAX_VALUE;
//        when(showRepository.findById(anyInt())).thenReturn(Optional.empty());
//        when(tvMazeService.getSeasons(show.getId())).thenReturn(ShowFactory.getSeasons());
//        when(tvMazeService.getShowById(show.getId())).thenReturn(show);
//        when(showRepository.save(show)).thenReturn(show);
//
//        assertThrows(SeasonNotFoundException.class, () -> showService.getSeasonById(show.getId(), inavlidSeasonNumber));
//    }
//
//    @Test
//    void getSeason_ValidSeasonNumberOfOutDatedShowWithStatusEnded_ShouldReturnSeasonFromDB() throws IOException {
//        Show show = ShowFactory.getShowOutdatedEnded();
//        Season three = ShowFactory.getLastSeasonWithEpisodes();
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//        Season result = showService.getSeasonById(show.getId(), 3);
//        assertThat(result).isEqualTo(three);
//    }
}
