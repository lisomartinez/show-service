package cloud.liso.showservice.services;

import cloud.liso.showservice.model.Episode;
import cloud.liso.showservice.repositories.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultEpisodeService implements EpisodeService {

    private EpisodeRepository episodeRepository;

    @Autowired
    public DefaultEpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public Episode getEpisode(int showId, int seasonNumber, int episodeNumber) {
        return null;
    }

    @Override
    public Episode getLastEpisode(int showId) {
        return null;
    }
}
