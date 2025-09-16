-- Drop table if exists
DROP TABLE IF EXISTS t_cancel_reason;

-- Drop indexes if exist
DROP INDEX IF EXISTS idx_cancel_reason_created_at;
DROP INDEX IF EXISTS idx_cancel_reason_updated_at;
DROP INDEX IF EXISTS idx_cancel_reason_order_request_id;

-- Create table
CREATE TABLE t_cancel_reason (
                          id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                          order_request_id UUID,
                          cancel_reason TEXT,
                          created_by VARCHAR,
                          created_at TIMESTAMP,
                          updated_by VARCHAR,
                          updated_at TIMESTAMP
);

-- Create indexes
CREATE INDEX idx_cancel_reason_created_at ON t_cancel_reason(created_at);
CREATE INDEX idx_cancel_reason_updated_at ON t_cancel_reason(updated_at);
CREATE INDEX idx_cancel_reason_order_request_id ON t_cancel_reason(order_request_id);

-- CREATE EXTENSION
CREATE EXTENSION IF NOT EXISTS "pgcrypto";
