-- Drop the client table if it exists
DROP TABLE IF EXISTS transaction;

-- Create the `transaction` table
CREATE TABLE IF NOT EXISTS transaction (
                                           transaction_id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,     -- Primary key for transaction
    transaction_uuid VARCHAR(255) NOT NULL,                   -- UUID of the transaction
    sender_uuid VARCHAR(255) NOT NULL,                        -- UUID of the sender
    receiver_uuid VARCHAR(255) NOT NULL,                      -- UUID of the receiver
    amount DOUBLE NOT NULL,                                   -- Amount of transaction
    transaction_status ENUM('NEW', 'CREATED', 'STARTED', 'COMPLETED', 'CANCELED', 'FAILED') NOT NULL,  -- Enum for transaction status
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,     -- Creation timestamp
    last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  -- Last update timestamp
    );