package dev.personal.planner.models;

public enum Priority {
    LOW,
    MEDIUM,
    HIGH,
    URGENT;

    public static Priority fromString(String priority) {
        try {
            return Priority.valueOf(priority.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // or throw an exception if you prefer
        }
    }
}
