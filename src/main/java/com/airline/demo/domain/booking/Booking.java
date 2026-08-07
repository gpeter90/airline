package com.airline.demo.domain.booking;

import java.time.LocalDateTime;

import com.airline.demo.common.domain.BaseEntity;
import com.airline.demo.common.util.DatabaseConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
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
