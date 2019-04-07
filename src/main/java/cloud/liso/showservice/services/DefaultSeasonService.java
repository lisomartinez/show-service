package cloud.liso.showservice.services;

import cloud.liso.showservice.model.Season;
import cloud.liso.showservice.repositories.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultSeasonService implements SeasonService {

    private SeasonRepository seasonRepository;

    @Autowired
    public DefaultSeasonService(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public List<Season> getAllSeasons(int showId) {
        return seasonRepository.findAllByShow(showId);
    }

    @Override
    public Season getSeasonByNumber(int showId, int seasonNumber) {
        return null;
    }
}
