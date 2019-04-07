package cloud.liso.showservice.service;

//@ExtendWith(MockitoExtension.class)
//@Disabled
class ShowService_ {

//    private ShowService showService;
//
//
////    private Show show;
//    @Mock
//    private ShowRepository showRepository;
//
//
//    @Mock
//    private TvMazeService tvMazeService;
//
//    @BeforeEach
//    void setUp() {
//        showService = new ShowServiceImpl(showRepository, tvMazeService);
//    }
//
//    @Test
//    void getShow_ShowNotInDB_ReturnsShowFromTvMazeService() throws IOException {
//
//        Show show = ShowFactory.getShowUptodateEndedWithOutSeasons();
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.empty());
//        when(tvMazeService.getShowById(show.getId())).thenReturn(show);
//        when(showRepository.save(show)).thenReturn(show);
//        Show returnedShow = showService.getShowById(show.getId());
//
//        assertThat(returnedShow).isNotNull();
//        verify(tvMazeService, times(1)).getShowById(show.getId());
//        assertThat(returnedShow.getId()).isEqualTo(show.getId());
//    }
//
//    @Test
//    void getShow_ShowIdLessThanOne_ShouldThrowShowNotFoundException() {
//        assertThrows(ShowNotFoundException.class, () -> showService.getShowById(0));
//    }
//
//    @Test
//    void getShow_NotInDBAndNotInTvMaze_ShouldThrowShowNotFoundException() {
//        when(showRepository.findById(anyInt())).thenReturn(Optional.empty());
//        when(tvMazeService.getShowById(anyInt())).thenThrow(TvMazeShowNotFoundException.class);
//        assertThrows(ShowNotFoundException.class, () -> showService.getShowById(10));
//    }
//
//    @Test
//    void getShow_OutdatedEnded_ReturnsShowFromDB() throws IOException {
//        Show show = ShowFactory.getShowOutdatedEnded();
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//        Show returnedShow = showService.getShowById(show.getId());
//        assertThat(returnedShow).isEqualTo(show);
//    }
//
//    @Test
//    void getShow_OutdatedShowEnded_ShouldCallShowRepositoryGetById() throws IOException {
//        Show show = ShowFactory.getShowOutdatedEnded();
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//        showService.getShowById(show.getId());
//        verify(showRepository).findById(anyInt());
//    }
//
//
//    @Test
//    void getShow_OutdatedNotEnded_ReturnsShowFromTvMazeService() throws IOException {
//        Show show = ShowFactory.getShowOutdatedAiring();
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//        when(tvMazeService.getShowById(show.getId())).thenReturn(show);
//        when(showRepository.save(show)).thenReturn(show);
//
//        Show returnedShow = showService.getShowById(show.getId());
//
//        assertThat(returnedShow).isNotNull();
//    }
//
//    @Test
//    void getShow_OutdatedNotEnded_ShouldCallTvMazeService() throws IOException {
//        Show show = ShowFactory.getShowOutdatedAiring();
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//        when(tvMazeService.getShowById(show.getId())).thenReturn(show);
//        when(showRepository.save(show)).thenReturn(show);
//
//        showService.getShowById(show.getId());
//
//        verify(tvMazeService, times(1)).getShowById(show.getId());
//
//    }
//
//    @Test
//    void getShow_OutdatedNotEnded_ShouldCallShowRepositorySave() throws IOException {
//        Show show = ShowFactory.getShowOutdatedAiring();
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//        when(tvMazeService.getShowById(show.getId())).thenReturn(show);
//        when(showRepository.save(show)).thenReturn(show);
//        showService.getShowById(show.getId());
//        verify(showRepository, times(1)).save(show);
//
//    }
//
//
//    @Test
//    void getShow_UpToDateShowEnded_ShouldCallShowRepositoryGetById() throws IOException {
//        Show show = ShowFactory.getShowUptodateEnded();
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//        showService.getShowById(show.getId());
//        verify(showRepository).findById(anyInt());
//    }
//
//    @Test
//    void getShow_UpToDateShowNotEnded_ShouldCallShowRepositoryGetById() throws IOException {
//        Show show = ShowFactory.getShowUptodateAiring();
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//        showService.getShowById(show.getId());
//        verify(showRepository).findById(anyInt());
//    }
//
//    @Test
//    void getShow_UpToDateShowNotEnded_ShouldReturnInstanceFromDB() throws IOException {
//        Show show = ShowFactory.getShowUptodateAiring();
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//        Show response = showService.getShowById(show.getId());
//        assertThat(response).isEqualTo(show);
//    }
////
////    @Test
////    void getShow_OutdatedNotEnded_SaveReturnedShowFromTvMazeServiceInToDB() throws IOException {
////        Show show = ShowFactory.getShowOutdatedAiring();
////
////        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
////        when(tvMazeService.getShowById(show.getId())).thenReturn(show);
////        when(scheduleService.getScheduleWithSavedDays(show.getSchedule())).thenReturn(ShowFactory.getSchedule());
////        when(genreService.saveIfAbsent(show.getGenres())).thenReturn(ShowFactory.getGenres());
////        when(showRepository.save(show)).thenReturn(show);
////        showService.getShowById(show.getId());
////
////        verify(showRepository, times(1)).save(show);
//
////    }
//
//
//
//    @Test
//    void getEpisode_ValidShowWithValidSeasonAndValidEpisode_ShouldReturnEpisode() throws IOException {
//        List<Episode> episodeList = ShowFactory.getSeasonsWithEpisodes().get(2).getEpisodes();
//        Episode episode1 = episodeList.get(0);
//
//        Show show = ShowFactory.getShowUptodateEnded();
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//
//        Episode episode = showService.getEpisode(show.getId(), 3, 1);
//
//        LogManager.getLogger().info(episode);
//
//        assertThat(episode).isEqualTo(episode1);
//    }
//
//    @Test
//    void getAllSeasons_ValidShowId_ShouldReturnListOfSeasonsWithEpisodes() throws IOException {
//        List<Season> seasonWithEpisodes = ShowFactory.getSeasonsWithEpisodes();
//
//
//    }
//
//    @Test
//    void getEpisode_ValidShowWithValidSeasonAndInvalidEpisode_ShouldThrowEpisodeNotFoundException() throws IOException {
//
//        Show show = ShowFactory.getShowUptodateEnded();
//
//
//        final int invalidEpisodeNumber = Integer.MAX_VALUE;
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//
//        assertThrows(EpisodeNotFoundException.class, () -> showService.getEpisode(show.getId(), 3, invalidEpisodeNumber));
//    }
//
//    @Test
//    void getLastEpisode_ValidShowWithValidSeason_ShouldReturnLastEpisode() throws IOException {
//
//        Show show = ShowFactory.getShowUptodateAiring();
//
//        Episode lastEpisode = ShowFactory.getEpisodesFromSeason(3).get(12);
//
//        when(showRepository.findById(anyInt())).thenReturn(Optional.of(show));
//
//        Episode episode = showService.getLastEpisode(show.getId());
//
//        LogManager.getLogger().info(episode);
//
//        assertThat(episode).isEqualTo(lastEpisode);
//    }
}