-- Drop table if exists
DROP TABLE IF EXISTS t_request_qr_destroy;

-- Drop indexes if exist
DROP INDEX IF EXISTS idx_request_qr_destroy_created_at;
DROP INDEX IF EXISTS idx_request_qr_destroy_updated_at;
DROP INDEX IF EXISTS idx_request_qr_destroy_order_request_id;

-- Create table
CREATE TABLE t_request_qr_destroy (
                                      id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                      order_request_id UUID,
                                      brand_id VARCHAR,
                                      request_destroy_status VARCHAR,
                                      request_destroy_range_from VARCHAR,
                                      request_destroy_range_to VARCHAR,
                                      request_destroy_note TEXT,
                                      created_by VARCHAR,
                                      created_at TIMESTAMP,
                                      updated_by VARCHAR,
                                      updated_at TIMESTAMP
);

-- Create indexes
CREATE INDEX idx_request_qr_destroy_created_at ON t_request_qr_destroy(created_at);
CREATE INDEX idx_request_qr_destroy_updated_at ON t_request_qr_destroy(updated_at);
CREATE INDEX idx_request_qr_destroy_order_request_id ON t_request_qr_destroy(order_request_id);

-- CREATE EXTENSION
CREATE EXTENSION IF NOT EXISTS "pgcrypto";
