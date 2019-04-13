package cloud.liso.showservice.controllers;

import cloud.liso.showservice.dto.ShowDto;
import cloud.liso.showservice.services.SeasonService;
import cloud.liso.showservice.services.ShowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@Api(tags = "Shows")

@RestController
public class ShowController {

    public static final String SHOWS = "/shows";
    public static final String SHOW_ID = "/{id}";

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

    @GetMapping(SHOWS)
    @ResponseStatus(OK)
    @ApiOperation(value = "get show page")
    public Page<ShowDto> getShowPage(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "25") int size) {
        return showService.getShowPage(page, size).map(show -> modelMapper.map(show, ShowDto.class));
    }

}
