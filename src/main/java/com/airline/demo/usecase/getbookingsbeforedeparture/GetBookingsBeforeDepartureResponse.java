package com.airline.demo.usecase.getbookingsbeforedeparture;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
@ToString
public class GetBookingsBeforeDepartureResponse {
    private List<Booking> bookingBefore;
}
