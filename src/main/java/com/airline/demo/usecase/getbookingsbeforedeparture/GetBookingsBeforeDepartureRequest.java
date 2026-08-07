package com.airline.demo.usecase.getbookingsbeforedeparture;

import com.airline.demo.common.validator.MandatoryField;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@RequiredArgsConstructor
@Getter
@ToString
@Valid
public class GetBookingsBeforeDepartureRequest {
    @MandatoryField
    private LocalDateTime departure;
}
