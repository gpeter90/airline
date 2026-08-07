package com.airline.demo.common.util;

public class DatabaseConstants {

    public static final class SchemaName {
        public static final String AIRLINE = "airline";

    }

    public static final class TableName {

        public static final String BOOKING = "booking";
    }

    public static final class FieldName {
        public static final String ID = "id";


        public static final class Booking {
            public static final String PAX_NAME = "pax_name";
            public static final String DEPARTURE = "departure";
            public static final String ITINERARY = "itinerary";
        }
    }

}