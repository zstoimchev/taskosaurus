package dev.personal.planner.models.enums;

public enum Status {
    PENDING,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED,
    ON_HOLD,
    ARCHIVED;

    public static Status fromString(String status) {
        try {
            return Status.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // or throw an exception if you prefer
        }
    }
}
