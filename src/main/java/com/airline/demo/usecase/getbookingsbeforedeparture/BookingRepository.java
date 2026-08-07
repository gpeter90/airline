package com.airline.demo.usecase.getbookingsbeforedeparture;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository("bookingBeforeDepartureRepository")
interface BookingRepository extends Repository<Booking, Long> {
    List<Booking> findByDepartureBefore(LocalDateTime departure);
}
