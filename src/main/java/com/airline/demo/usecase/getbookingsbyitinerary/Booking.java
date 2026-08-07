package com.airline.demo.usecase.getbookingsbyitinerary;

import com.airline.demo.common.domain.BaseEntity;
import com.airline.demo.common.util.DatabaseConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity(name = "bookingByItinerary")
@Table(name = DatabaseConstants.TableName.BOOKING, schema = DatabaseConstants.SchemaName.AIRLINE)
@SuperBuilder
@NoArgsConstructor
@Getter
class Booking extends BaseEntity {

    @Column(name = DatabaseConstants.FieldName.Booking.PAX_NAME)
    private String paxName;

    @Column(name = DatabaseConstants.FieldName.Booking.DEPARTURE)
    private LocalDateTime departure;

    @Column(name = DatabaseConstants.FieldName.Booking.ITINERARY)
    private String itinerary;
}
