package cloud.liso.showservice.services;

import cloud.liso.showservice.model.ShowCard;

import java.util.List;
import java.util.Map;

public interface BrowserService {
    Map<String, List<ShowCard>> getPortal();
}
