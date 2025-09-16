-- Drop table if exists
DROP TABLE IF EXISTS t_good_receive_notes;

-- Drop indexes if exist
DROP INDEX IF EXISTS idx_good_receive_notes_created_at;
DROP INDEX IF EXISTS idx_good_receive_notes_updated_at;
DROP INDEX IF EXISTS idx_good_receive_notes_order_request_id;
DROP INDEX IF EXISTS idx_good_receive_notes_received_date;

-- Create table
CREATE TABLE t_good_receive_notes (
                                      id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                      order_request_id UUID NOT NULL,
                                      received_by VARCHAR,
                                      confirmed_by VARCHAR,
                                      received_date TIMESTAMP,
                                      received_qr_range_from VARCHAR,
                                      received_qr_range_to VARCHAR,
                                      received_qr_qty INT,
                                      received_qr_list_id UUID,
                                      received_status_id UUID,
                                      additional_information TEXT,
                                      created_by VARCHAR,
                                      created_at TIMESTAMP,
                                      updated_by VARCHAR,
                                      updated_at TIMESTAMP
);

-- Create indexes
CREATE INDEX idx_good_receive_notes_created_at ON t_good_receive_notes(created_at);
CREATE INDEX idx_good_receive_notes_updated_at ON t_good_receive_notes(updated_at);
CREATE INDEX idx_good_receive_notes_order_request_id ON t_good_receive_notes(order_request_id);
CREATE INDEX idx_good_receive_notes_received_date ON t_good_receive_notes(received_date);

-- CREATE EXTENSION
CREATE EXTENSION IF NOT EXISTS "pgcrypto";
