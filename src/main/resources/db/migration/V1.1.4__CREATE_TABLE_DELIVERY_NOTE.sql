-- Drop table if exists
DROP TABLE IF EXISTS t_delivery_note;

-- Drop indexes if exist
DROP INDEX IF EXISTS idx_delivery_note_created_at;
DROP INDEX IF EXISTS idx_delivery_note_updated_at;
DROP INDEX IF EXISTS idx_delivery_note_order_request_id;
DROP INDEX IF EXISTS idx_delivery_note_airway_bill;

-- Create table
CREATE TABLE t_delivery_note (
                                 id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                 order_request_id UUID NOT NULL,
                                 third_pl_name VARCHAR,
                                 vehicle_type VARCHAR,
                                 courier_name VARCHAR,
                                 licence_plate VARCHAR,
                                 airway_bill VARCHAR,
                                 created_by VARCHAR,
                                 created_at TIMESTAMP,
                                 updated_by VARCHAR,
                                 updated_at TIMESTAMP
);

-- Create indexes
CREATE INDEX idx_delivery_note_created_at ON t_delivery_note(created_at);
CREATE INDEX idx_delivery_note_updated_at ON t_delivery_note(updated_at);
CREATE INDEX idx_delivery_note_order_request_id ON t_delivery_note(order_request_id);
CREATE INDEX idx_delivery_note_airway_bill ON t_delivery_note(airway_bill);

-- CREATE EXTENSION
CREATE EXTENSION IF NOT EXISTS "pgcrypto";
