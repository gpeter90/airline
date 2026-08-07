package com.airline.demo.usecase.addbooking;

import java.time.LocalDateTime;

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
public class AddBookingRequest {
    @MandatoryField
    private String paxName;
    @MandatoryField
    private LocalDateTime departure;
    @MandatoryField
    private String itinerary;
}
