package com.airline.demo.domain.booking;

import com.airline.demo.common.domain.DomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService extends DomainService<BookingDto> {
    private final BookingRepository bookingRepository;

    @Override
    protected void update(BookingDto bookingDto) {
        bookingRepository.save(mapDtoToEntity(bookingDto));
    }

    private Booking mapDtoToEntity(BookingDto bookingDto) {
        return Booking.builder()
                .paxName(bookingDto.getPaxName())
                .departure(bookingDto.getDeparture())
                .itinerary(bookingDto.getItinerary())
                .build();
    }
}
