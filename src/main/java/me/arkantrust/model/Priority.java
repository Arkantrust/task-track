package me.arkantrust.model;

public enum Priority {

    NONE(0, "None"),
    LOW(1, "Low"),
    MEDIUM(2, "Medium"),
    HIGH(3, "High");

    private int value;
    private String description;

    private Priority(int value, String description) {

        this.value = value;
        this.description = description;

    }

    public int value() {

        return this.value;

    }

    public String description() {

        return this.description;

    }

}
