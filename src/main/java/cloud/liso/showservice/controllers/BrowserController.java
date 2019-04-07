package cloud.liso.showservice.controllers;

import cloud.liso.showservice.dto.GenreDto;
import cloud.liso.showservice.dto.ShowCardDto;
import cloud.liso.showservice.model.ShowCard;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.Entry;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/browser")
public class BrowserController {
    private static final String BROWSER = "/browser";
    private static final String PORTAL = "/portal";

    private BrowserService browserService;

    private ModelMapper modelMapper;

    public BrowserController(BrowserService browserService, ModelMapper modelMapper) {
        this.browserService = browserService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(PORTAL)
    @ResponseStatus(OK)
    public Map<GenreDto, List<ShowCardDto>> getPortal() {
        return browserService.getPortal().entrySet()
                .stream()
                .map(this::convertToDto)
                .collect(toMap(Entry::getKey, Entry::getValue));
    }

    private Map.Entry<GenreDto, List<ShowCardDto>> convertToDto(Map.Entry<String, List<ShowCard>> card) {
        return new HashMap.SimpleImmutableEntry<>(GenreDto.of(card.getKey()),
                card.getValue().stream()
                        .map(show -> modelMapper.map(show, ShowCardDto.class))
                        .collect(toList()));
    }
}
