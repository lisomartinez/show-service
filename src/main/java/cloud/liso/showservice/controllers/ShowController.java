package cloud.liso.showservice.controllers;

import cloud.liso.showservice.dto.MinSeasonDto;
import cloud.liso.showservice.dto.ShowDto;
import cloud.liso.showservice.services.SeasonService;
import cloud.liso.showservice.services.ShowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@Api(tags = "Shows")

@RestController
public class ShowController {

    public static final String SHOWS = "/shows";
    public static final String SHOW_ID = "/{id}";
    public static final String SEASON = "/seasons";
    public static final String SEASON_NUMBER = "/{seasonNumber}";
    public static final String LAST_EPISODE_OF_SHOW = "/lastEpisode";
    private static final String CARDS = "/cards";
    private static final String INDEX = "/index";

    private ShowService showService;

    private SeasonService seasonService;

    private ModelMapper modelMapper;

    @Autowired
    public ShowController(ShowService showService, SeasonService seasonService, ModelMapper modelMapper) {
        this.showService = showService;
        this.seasonService = seasonService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(SHOWS + SHOW_ID)
    @ResponseStatus(OK)
    @ApiOperation(value = "get a show by id")
    public ShowDto getShow(@PathVariable int id) {
        return modelMapper.map(showService.getShowById(id), ShowDto.class);
    }

//    @GetMapping(SHOW_ID + SEASON + SEASON_NUMBER)
//    @ResponseStatus(HttpStatus.OK)
//    public MinSeasonDto getSeason(@PathVariable int id, @PathVariable int seasonNumber) {
//        return modelMapper.map(showService.getSeasonByNumber(id, seasonNumber), MinSeasonDto.class);
//    }

    @GetMapping(SHOWS)
    @ResponseStatus(OK)
    @ApiOperation(value = "get show page")
    public Page<ShowDto> getShowPage(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "25") int size) {
        return showService.getShowPage(page, size).map(show -> modelMapper.map(show, ShowDto.class));
    }

    @GetMapping(SHOWS + SHOW_ID + SEASON)
    @ResponseStatus(OK)
    public List<MinSeasonDto> getAllSeasons(@PathVariable int id) {
        return seasonService.getAllSeasons(id).stream()
                .map(season -> modelMapper.map(season, MinSeasonDto.class))
                .collect(Collectors.toList());
    }

//    @GetMapping(LAST_EPISODE_OF_SHOW)
//    public EpisodeDto getLastEpisode(@RequestParam int showId) {
//        return modelMapper.map(showService.getLastEpisode(showId), EpisodeDto.class);
//    }

}
