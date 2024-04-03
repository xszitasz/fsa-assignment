package sk.posam.fsa.jpa;

import jakarta.persistence.AttributeConverter;
import sk.posam.fsa.ReservationStatus;

public class ReservationStatusConverter implements AttributeConverter<ReservationStatus, String> {
    @Override
    public String convertToDatabaseColumn(ReservationStatus status) {
        if (status == null) {
            return null;
        }
        return status.name();
    }

    @Override
    public ReservationStatus convertToEntityAttribute(String status) {
        if (status == null) {
            return null;
        }
        try {
            return ReservationStatus.valueOf(status);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Invalid value for enum ReservationStatus: " + status);
        }
    }
}

