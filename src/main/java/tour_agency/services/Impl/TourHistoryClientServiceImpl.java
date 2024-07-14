package tour_agency.services.Impl;

import tour_agency.repositories.BookingRepository;
import tour_agency.services.TourHistoryClientService;

import java.util.Set;

public class TourHistoryClientServiceImpl implements TourHistoryClientService {
    private final BookingRepository bookingRepositoryRepository;

    public TourHistoryClientServiceImpl(BookingRepository bookingRepositoryRepository) {
        this.bookingRepositoryRepository = bookingRepositoryRepository;
    }
}
