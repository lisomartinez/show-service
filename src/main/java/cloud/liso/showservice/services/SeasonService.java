package cloud.liso.showservice.services;

import cloud.liso.showservice.model.Season;

import java.util.List;

public interface SeasonService {
    List<Season> getAllSeasons(int showId);

    Season getSeasonByNumber(int showId, int seasonNumber);
}
