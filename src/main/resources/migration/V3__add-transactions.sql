-- Example insert statements (optional) for testing purposes
INSERT INTO transactions (transaction_uuid, sender_uuid, receiver_uuid, amount, transaction_status)
VALUES ('123e4567-e89b-12d3-a456-426614174001', '123e4567-e89b-12d3-a456-23423423', '3840ade4-f8ad-4829-a7af-b88192d52243', 100.00, 'NEW');

INSERT INTO transactions (transaction_uuid, sender_uuid, receiver_uuid, amount, transaction_status)
VALUES ('123e4567-e89b-12d3-a456-426614174000', '123e4567-e89b-12d3-a456-42661417qweqwe', '3840ade4-f8ad-4829-a7af-b88192d52243', 50.00, 'COMPLETED');