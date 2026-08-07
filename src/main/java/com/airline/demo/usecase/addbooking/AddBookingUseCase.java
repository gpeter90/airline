package com.airline.demo.usecase.addbooking;

import com.airline.demo.common.exception.InvalidParameterException;
import com.airline.demo.common.usecase.UseCase;
import com.airline.demo.common.usecase.UseCaseWithExtraValidation;
import com.airline.demo.common.validator.MandatoryFieldValidator;
import com.airline.demo.common.validator.Validator;
import com.airline.demo.domain.booking.BookingDto;
import com.airline.demo.domain.booking.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
@CommonsLog
@RequiredArgsConstructor
public class AddBookingUseCase extends UseCase<AddBookingRequest, Void>
        implements UseCaseWithExtraValidation<AddBookingRequest> {

    private static final Pattern ITINERARY_PATTERN =
            Pattern.compile("^[A-Z]{3}(→[A-Z]{3})+$");
    public static final String ITINERARY_MUST_FOLLOW_THE_IATA_FORMAT =
            "Itinerary must follow the IATA format: e.g. AMS→LHR or GVA→AMS→LHR";

    private final BookingService bookingService;
    private final MandatoryFieldValidator mandatoryFieldValidator;

    @Override
    public void validate(AddBookingRequest request) {
        if (!ITINERARY_PATTERN.matcher(request.getItinerary()).matches()) {
            throw new InvalidParameterException(ITINERARY_MUST_FOLLOW_THE_IATA_FORMAT);
        }
    }

    @Override
    protected Validator[] getValidators() {
        return new Validator[]{mandatoryFieldValidator};
    }

    @Override
    protected Void executeBusinessLogic(AddBookingRequest request) {
        bookingService.save(generateBookingDto(request));
        return null;
    }

    private BookingDto generateBookingDto(AddBookingRequest request) {
        return BookingDto.builder()
                .paxName(request.getPaxName())
                .departure(request.getDeparture())
                .itinerary(request.getItinerary())
                .build();
    }
}
