package com.posam.fsaassignment.enums;

public enum Race {
    LABRADOR(AnimalType.DOG),
    SHEPHERD(AnimalType.DOG),
    RETRIEVER(AnimalType.DOG),
    BULLDOG(AnimalType.DOG),
    BEAGLE(AnimalType.DOG),
    POODLE(AnimalType.DOG),
    ROTTWEILER(AnimalType.DOG),
    YORKSHIRE(AnimalType.DOG),
    SIAMESE(AnimalType.CAT),
    MAINE(AnimalType.CAT),
    RAGDOLL(AnimalType.CAT),
    BENGAL(AnimalType.CAT),
    SPHYNX(AnimalType.CAT),
    BRITISH(AnimalType.CAT),
    SCOTTISH(AnimalType.CAT),
    ABYSSINIAN(AnimalType.CAT),
    PERSIAN(AnimalType.CAT);

    private final AnimalType type;

    Race(AnimalType type) {
        this.type = type;
    }

    public AnimalType getType() {
        return type;
    }
}
