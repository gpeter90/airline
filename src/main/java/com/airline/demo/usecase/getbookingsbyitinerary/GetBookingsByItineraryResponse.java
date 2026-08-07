package com.airline.demo.usecase.getbookingsbyitinerary;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
@ToString
public class GetBookingsByItineraryResponse {
    private List<Booking> bookingByItinerary;
}
