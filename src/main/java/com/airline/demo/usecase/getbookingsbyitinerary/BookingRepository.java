package com.airline.demo.usecase.getbookingsbyitinerary;

import org.springframework.data.repository.Repository;

import java.time.LocalDateTime;
import java.util.List;

@org.springframework.stereotype.Repository("bookingByItineraryRepository")
interface BookingRepository extends Repository<Booking, Long> {
    List<Booking> findByItineraryContains(String itinerary);
}
