package cloud.liso.showservice.controllers;

import cloud.liso.showservice.services.imdb.ImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/shows/imdb")
public class ImdbController {
    public static final String SHOWS = "/shows";
    public static final String IMDB = "/shows/imdb";
    public static final String ID = "/{id}";
    private ImdbService imdbService;

    @Autowired
    public ImdbController(ImdbService imdbService) {
        this.imdbService = imdbService;
    }

    @GetMapping(value = ID, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(OK)
    public String getImdbUrl(@PathVariable int id) {
        return imdbService.getImdbVideoLink(id);
    }

}
