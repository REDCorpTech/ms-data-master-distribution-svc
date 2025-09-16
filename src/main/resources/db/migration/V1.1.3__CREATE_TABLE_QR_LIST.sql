-- Drop table if exists
DROP TABLE IF EXISTS t_qr_list;

-- Drop indexes if exist
DROP INDEX IF EXISTS idx_qr_list_created_at;
DROP INDEX IF EXISTS idx_qr_list_updated_at;
DROP INDEX IF EXISTS idx_qr_list_order_request_id;
DROP INDEX IF EXISTS idx_qr_list_qr_code;

-- Create table
CREATE TABLE t_qr_list (
                           id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                           order_request_id UUID NOT NULL,
                           qr_code INT,
                           created_by VARCHAR,
                           created_at TIMESTAMP,
                           updated_by VARCHAR,
                           updated_at TIMESTAMP
);

-- Create indexes
CREATE INDEX idx_qr_list_created_at ON t_qr_list(created_at);
CREATE INDEX idx_qr_list_updated_at ON t_qr_list(updated_at);
CREATE INDEX idx_qr_list_order_request_id ON t_qr_list(order_request_id);
CREATE INDEX idx_qr_list_qr_code ON t_qr_list(qr_code);

-- CREATE EXTENSION
CREATE EXTENSION IF NOT EXISTS "pgcrypto";
