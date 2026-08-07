package com.airline.demo.usecase.getbookingsbyitinerary;

import com.airline.demo.common.validator.MandatoryField;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@RequiredArgsConstructor
@Getter
@ToString
@Valid
public class GetBookingsByItineraryRequest {
    @MandatoryField
    private String itinerary;
}
