package cloud.liso.showservice.controllers;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
class ShowController_ {
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private AccessTokenFactory tokenFactory;
//
//    @MockBean
//    private ShowService showService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    @Test
//    void getShow_ValidShowId_ShouldReturnShow() throws Exception {
//        String token = getToken();
//
//        Show show = ShowFactory.getShowUptodateAiring();
//        ShowDto showDto = modelMapper.map(show, ShowDto.class);
//        when(showService.getShowById(anyInt())).thenReturn(show);
//        MvcResult result = this.mockMvc.perform(get(ShowController.SHOWS + ShowController.SHOW_ID, show.getId())
//                .header("Authorization", "Bearer " + token))
//                .andExpect(status().isOk())
//                .andReturn();
//        ShowDto resultShow = objectMapper.readValue(result.getResponse().getContentAsString(), ShowDto.class);
//
//        assertThat(resultShow).isEqualTo(showDto);
//    }
//
//    private String getToken() throws Exception {
//        return tokenFactory.createValidTokenMock(userRepository, mockMvc);
//    }
//
//    @Test
//    void getShow_InvalidShowIßd_ShouldThrowShowNotFoundException() throws Exception {
//        String token = getToken();
//
//        when(showService.getShowById(anyInt())).thenThrow(new ShowNotFoundException());
//
//        this.mockMvc.perform(get(ShowController.SHOWS + ShowController.SHOW_ID, 0)
//                .header("Authorization", "Bearer " + token))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    void getSeason_validShowIdAndValidSeasonNumber_ShouldReturnSeason() throws Exception {
//        String token = getToken();
//
//        final int showId = 1;
//        final int seasonNumber = 3;
//
//        Season lastSeasonWithEpisodes = ShowFactory.getLastSeasonWithEpisodes();
//        SeasonDto seasonDto = modelMapper.map(lastSeasonWithEpisodes, SeasonDto.class);
//        when(showService.getSeasonById(showId, seasonNumber)).thenReturn(lastSeasonWithEpisodes);
//
//        MvcResult result = this.mockMvc.perform(get(ShowController.SHOWS + ShowController.SHOW_ID +
//                ShowController.SEASON + ShowController.SEASON_NUMBER, showId, seasonNumber)
//                .header("Authorization", "Bearer " + token))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn();
//
//
//        SeasonDto resultSeason = objectMapper.readValue(result.getResponse().getContentAsString(), SeasonDto.class);
//        assertThat(resultSeason).isEqualTo(seasonDto);
//    }
//
//    @Test
//    void getSeason_invalidShowId_ShouldThrowShowNotFoundException() throws Exception {
//        String token = getToken();
//
//        final int showId = 0;
//        final int seasonNumber = 3;
//
//        when(showService.getSeasonById(showId, seasonNumber)).thenThrow(new ShowNotFoundException());
//
//        this.mockMvc.perform(get(ShowController.SHOWS + ShowController.SHOW_ID +
//                ShowController.SEASON + ShowController.SEASON_NUMBER, showId, seasonNumber)
//                .header("Authorization", "Bearer " + token))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    void getSeason_validShowIdAndInvalidSeasonNumber_ShouldThrowSeasonNotFoundException() throws Exception {
//        String token = getToken();
//
//        final int showId = 1;
//        final int seasonNumber = 1;
//
//        when(showService.getSeasonById(showId, seasonNumber)).thenThrow(new SeasonNotFoundException());
//
//        this.mockMvc.perform(get(ShowController.SHOWS + ShowController.SHOW_ID +
//                ShowController.SEASON + ShowController.SEASON_NUMBER, showId, seasonNumber)
//                .header("Authorization", "Bearer " + token))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    void getEpisode_ValidShowAndValidSeasonAndValidEpisode_ShouldReturnEpisode() {
////        String token = getToken();
////
////        final int showId = 1;
////        final int seasonNumber = 1;
////        final int episodeNumber = 1;
////
////        when(showService.getLastEpisodeFromLastSeason(showId, seasonNumber, episodeNumber)).thenReturn()
//    }
}
