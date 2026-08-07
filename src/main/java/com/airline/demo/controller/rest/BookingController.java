package com.airline.demo.controller.rest;

import com.airline.demo.usecase.addbooking.AddBookingRequest;
import com.airline.demo.usecase.addbooking.AddBookingUseCase;
import com.airline.demo.usecase.getbookingsbeforedeparture.GetBookingsBeforeDepartureRequest;
import com.airline.demo.usecase.getbookingsbeforedeparture.GetBookingsBeforeDepartureResponse;
import com.airline.demo.usecase.getbookingsbeforedeparture.GetBookingsBeforeDepartureUseCase;
import com.airline.demo.usecase.getbookingsbyitinerary.GetBookingsByItineraryRequest;
import com.airline.demo.usecase.getbookingsbyitinerary.GetBookingsByItineraryResponse;
import com.airline.demo.usecase.getbookingsbyitinerary.GetBookingsByItineraryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(BookingController.BOOKING_API_PATH)
public class BookingController {
    public static final String BOOKING_API_PATH = "booking";

    private final AddBookingUseCase addBookingUseCase;
    private final GetBookingsBeforeDepartureUseCase getBookingsBeforeDepartureUseCase;
    private final GetBookingsByItineraryUseCase getBookingsByItineraryUseCase;

    @PostMapping(value = "addBooking", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Void> addBooking(@RequestBody AddBookingRequest request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(addBookingUseCase.execute(request));
    }

    @GetMapping(value = "getBookingsBeforeDeparture")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<GetBookingsBeforeDepartureResponse> getBookingsBeforeDeparture(
            @RequestBody GetBookingsBeforeDepartureRequest request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(getBookingsBeforeDepartureUseCase.execute(request));
    }

    @GetMapping(value = "getBookingsByItinerary")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<GetBookingsByItineraryResponse> getBookingsByItinerary(
            @RequestBody GetBookingsByItineraryRequest request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(getBookingsByItineraryUseCase.execute(request));
    }
}
