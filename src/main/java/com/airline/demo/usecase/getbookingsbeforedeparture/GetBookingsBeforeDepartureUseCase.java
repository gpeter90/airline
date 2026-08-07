package com.airline.demo.usecase.getbookingsbeforedeparture;

import com.airline.demo.common.usecase.UseCase;
import com.airline.demo.common.validator.MandatoryFieldValidator;
import com.airline.demo.common.validator.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@CommonsLog
@RequiredArgsConstructor
public class GetBookingsBeforeDepartureUseCase extends UseCase<
        GetBookingsBeforeDepartureRequest,
        GetBookingsBeforeDepartureResponse> {
    private final BookingRepository bookingRepository;
    private final MandatoryFieldValidator mandatoryFieldValidator;

    @Override
    protected Validator[] getValidators() {
        return new Validator[]{mandatoryFieldValidator};
    }

    @Override
    protected GetBookingsBeforeDepartureResponse executeBusinessLogic(
            GetBookingsBeforeDepartureRequest request) {

        List<Booking> departureBefore =
                bookingRepository.findByDepartureBefore(request.getDeparture());

        return GetBookingsBeforeDepartureResponse.builder()
                .bookingBefore(departureBefore)
                .build();
    }
}
