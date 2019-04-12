package cloud.liso.showservice.controllers;

import cloud.liso.showservice.dto.ShowCardDto;
import cloud.liso.showservice.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private static final String ID = "/{id}";
    private static final String NAME = "/{name}";

    private GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping(NAME)
    @ResponseStatus(OK)
    public Page<ShowCardDto> getGenrePage(@PathVariable String name,
                                          @RequestParam(defaultValue = "1") int page,
                                          @RequestParam(defaultValue = "10") int size) {
        return genreService.getPageByGenre(name, page, size);
    }
}
