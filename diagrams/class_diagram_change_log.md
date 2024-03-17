## Class Diagram changelog

### Removals
- `read()` removed from `ReservationRepository`
- `Dogwalker` & `Admin` class removed
- Interface `Dogwalker` removed
- `TimeManagerRepository` removed
- `approveReservation()`, `rejectReservation()`, `cancelReservation()` removed from `UserInterface`

### Additions
- `findByAnimal()` added in `ReservationRepository`
- `UserRole` added as enumeration
- Methods `approve()`, `cancel()`, & `reject()` added in `Reservation`

### Renames
- `findById()` in `ReservationRepository` renamed to `read(long)`
- `findById()` in `TimeManagerRepository` renamed to `read(long)` 
- `findById()` in `UserRepository` renamed to `read(long)`
- `findById()` in `AnimalRepository` renamed to `read(long)`
- `IAdmin` renamed to `UserInterface`
- `read()` methods renamed to `read(long)`
- `TimeManager` renamed to `AnimalService`
- `createPending()` renamed to `create()` in `ReservationFactory`
- `getAnimalAvailability(LocalDateTime)` renamed to `findAvailableAnimals(AnimalRepository, LocalDateTime)`

### Associations
- Association between `Animal` and `Reservation` inverted
- Association between `Race` and `AnimalType` added
- Association between `Animal` and `AnimalType` removed
