-- Begin transaction
BEGIN;

-- Insert dummy data into the users table
INSERT INTO users (id, created, name, user_name, role) VALUES
    (1, '2023-01-01 12:00:00', 'John Doe', 'john.doe', 'ADMIN'),
    (2, '2023-01-02 10:00:00', 'Jane Smith', 'jane.smith', 'DOGWALKER'),
    (3, '2023-01-03 09:00:00', 'Alice Johnson', 'alice.johnson', 'DOGWALKER'),
    (4, '2023-01-04 08:00:00', 'Bob Brown', 'bob.brown', 'DOGWALKER'),
    (5, '2023-01-05 15:00:00', 'Charlie Davis', 'charlie.davis', 'DOGWALKER'),
    (6, '2023-01-06 14:00:00', 'David Wilson', 'david.wilson', 'DOGWALKER'),
    (7, '2023-01-07 13:00:00', 'Eva Garcia', 'eva.garcia', 'DOGWALKER'),
    (8, '2023-01-08 11:00:00', 'Frank Martinez', 'frank.martinez', 'DOGWALKER'),
    (9, '2023-01-09 10:00:00', 'Grace Anderson', 'grace.anderson', 'DOGWALKER'),
    (10, '2023-01-10 16:00:00', 'Henry Thompson', 'henry.thompson', 'DOGWALKER');

-- Insert dummy data into the animals table
INSERT INTO animals (id, name, race) VALUES
                                     (1, 'Rex', 'LABRADOR'),
                                     (2, 'Buddy', 'SHEPHERD'),
                                     (3, 'Max', 'RETRIEVER'),
                                     (4, 'Daisy', 'BULLDOG'),
                                     (5, 'Bailey', 'BEAGLE'),
                                     (6, 'Charlie', 'POODLE'),
                                     (7, 'Lucy', 'ROTTWEILER'),
                                     (8, 'Cooper', 'YORKSHIRE'),
                                     (9, 'Luna', 'SIAMESE'),
                                     (10, 'Milo', 'MAINE'),
                                     (11, 'Tiger', 'RAGDOLL'),
                                     (12, 'Simba', 'BENGAL'),
                                     (13, 'Sphinx', 'SPHYNX'),
                                     (14, 'Oliver', 'BRITISH'),
                                     (15, 'Loki', 'SCOTTISH'),
                                     (16, 'Cleo', 'ABYSSINIAN'),
                                     (17, 'Fluffy', 'PERSIAN');

-- Insert dummy data into the credits table (assuming it's not empty)
INSERT INTO credits (count, user_id) VALUES (100, 1), (50, 2);

-- Insert dummy data into the reservations table
INSERT INTO reservations (created, start_time, end_time, status, user_id, animal_id) VALUES
    ('2023-01-01 12:00:00', '2023-01-01 10:30:00', '2023-01-01 12:30:00', 'PENDING', 2, 7),
    ('2023-01-01 12:00:00', '2023-01-01 11:00:00', '2023-01-01 13:00:00', 'PENDING', 4, 6),
    ('2023-01-01 12:00:00', '2023-01-01 11:30:00', '2023-01-01 13:30:00', 'PENDING', 4, 2),
    ('2023-01-01 12:00:00', '2023-01-01 12:00:00', '2023-01-01 14:00:00', 'PENDING', 2, 2),
    ('2023-01-01 12:00:00', '2023-01-01 12:30:00', '2023-01-01 14:30:00', 'PENDING', 6, 1),
    ('2023-01-01 12:00:00', '2023-01-01 13:00:00', '2023-01-01 15:00:00', 'PENDING', 3, 4),
    ('2023-01-01 12:00:00', '2023-01-01 13:30:00', '2023-01-01 15:30:00', 'PENDING', 6, 4),
    ('2023-01-01 12:00:00', '2023-01-01 14:00:00', '2023-01-01 16:00:00', 'PENDING', 3, 7),
    ('2023-01-01 12:00:00', '2023-01-01 14:30:00', '2023-01-01 16:30:00', 'PENDING', 3, 7),
    ('2023-01-01 12:00:00', '2023-01-01 15:00:00', '2023-01-01 17:00:00', 'PENDING', 4, 5);

-- Commit transaction
COMMIT;
