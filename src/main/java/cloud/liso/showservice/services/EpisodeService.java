package cloud.liso.showservice.services;

import cloud.liso.showservice.model.Episode;

public interface EpisodeService {
    Episode getEpisode(int showId, int seasonNumber, int episodeNumber);

    Episode getLastEpisode(int showId);
}
