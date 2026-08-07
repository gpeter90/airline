package com.airline.demo.usecase.getbookingsbyitinerary;

import com.airline.demo.common.exception.InvalidParameterException;
import com.airline.demo.common.usecase.UseCase;
import com.airline.demo.common.usecase.UseCaseWithExtraValidation;
import com.airline.demo.common.validator.MandatoryFieldValidator;
import com.airline.demo.common.validator.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
@CommonsLog
@RequiredArgsConstructor
public class GetBookingsByItineraryUseCase extends UseCase<GetBookingsByItineraryRequest,
        GetBookingsByItineraryResponse>
        implements UseCaseWithExtraValidation<GetBookingsByItineraryRequest> {

    private static final Pattern ITINERARY_PATTERN =
            Pattern.compile("^[A-Z]{3}(→[A-Z]{3})+$");
    public static final String ITINERARY_MUST_FOLLOW_THE_IATA_FORMAT =
            "Itinerary must follow the IATA format: e.g. AMS→LHR";

    private final BookingRepository bookingRepository;
    private final MandatoryFieldValidator mandatoryFieldValidator;

    @Override
    public void validate(GetBookingsByItineraryRequest request) {
        if (!ITINERARY_PATTERN.matcher(request.getItinerary()).matches()) {
            throw new InvalidParameterException(ITINERARY_MUST_FOLLOW_THE_IATA_FORMAT);
        }
    }

    @Override
    protected Validator[] getValidators() {
        return new Validator[]{mandatoryFieldValidator};
    }

    @Override
    protected GetBookingsByItineraryResponse executeBusinessLogic(
            GetBookingsByItineraryRequest request) {
        List<Booking> itineraryContains =
                bookingRepository.findByItineraryContains(request.getItinerary());

        return GetBookingsByItineraryResponse.builder()
                .bookingByItinerary(itineraryContains)
                .build();
    }
}
