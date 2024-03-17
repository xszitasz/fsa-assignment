package com.posam.fsaassignment.enums;

public enum Race {
    HUSKY(AnimalType.DOG),
    LABRADOR(AnimalType.DOG),
    PERSIAN(AnimalType.CAT);

    private final AnimalType type;

    Race(AnimalType type) {
        this.type = type;
    }

    public AnimalType getType() {
        return type;
    }
}
