CREATE SCHEMA IF NOT EXISTS airline;

CREATE TABLE IF NOT EXISTS airline.booking(
    id BIGSERIAL NOT NULL,
    pax_name VARCHAR(100),
    departure TIMESTAMP NOT NULL,
    itinerary VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (pax_name, departure)
);