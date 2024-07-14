package tour_agency.services.Impl;

import tour_agency.DTO.ClientDTO;
import tour_agency.entities.TourEntity;
import tour_agency.repositories.BookingRepository;
import tour_agency.repositories.TourRepository;
import tour_agency.services.TourHistoryClientService;

import java.util.Set;

public class TourHistoryClientServiceImpl implements TourHistoryClientService {
    private final TourRepository tourRepository;
    private final BookingRepository bookingRepository;

    public TourHistoryClientServiceImpl(TourRepository tourRepository, BookingRepository bookingRepository) {
        this.tourRepository = tourRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Set<TourEntity> historyClientTours(ClientDTO clientDTO) {
        Set<TourEntity> tourEntitySet = tourRepository.findToursByClientId(clientDTO.getId());
        return tourEntitySet;
    }
}
