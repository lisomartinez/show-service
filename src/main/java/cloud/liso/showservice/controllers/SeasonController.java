package cloud.liso.showservice.controllers;

import cloud.liso.showservice.dto.EpisodeDto;
import cloud.liso.showservice.dto.MinSeasonDto;
import cloud.liso.showservice.dto.SeasonDto;
import cloud.liso.showservice.model.Season;
import cloud.liso.showservice.services.SeasonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class SeasonController {

    public static final String SHOWS = "/shows";
    public static final String SHOW_ID = "/{id}";
    public static final String SEASON = "/seasons";
    public static final String SEASON_NUMBER = "/{seasonNumber}";

    private SeasonService seasonService;

    private ModelMapper mm;

    @Autowired
    public SeasonController(SeasonService seasonService, ModelMapper mm) {
        this.seasonService = seasonService;
        this.mm = mm;
    }

    @GetMapping(SHOWS + SHOW_ID + SEASON)
    @ResponseStatus(OK)
    public List<MinSeasonDto> getAllSeasons(@PathVariable int id) {
        return seasonService.getAllSeasons(id).stream()
                .map(season -> mm.map(season, MinSeasonDto.class))
                .collect(toList());
    }

    @GetMapping(SHOWS + SHOW_ID + SEASON + SEASON_NUMBER)
    @ResponseStatus(OK)
    public SeasonDto getSeasonByShowIdAndSeasonNumber(@PathVariable int id, @PathVariable int seasonNumber) {
        return mapToDto(seasonService.getSeasonByNumber(id, seasonNumber));
    }

    private SeasonDto mapToDto(Season season) {
        return SeasonDto.builder()
                .id(season.getId())
                .showId(season.getShow().getId())
                .number(season.getNumber())
                .episodes(season.getEpisodes().stream().map(e -> mm.map(e, EpisodeDto.class)).collect(toList()))
                .build();
    }
}
