-- Drop table if exists
DROP TABLE IF EXISTS t_order_request;

-- Drop indexes if exist
DROP INDEX IF EXISTS idx_order_request_json_created_at;
DROP INDEX IF EXISTS idx_order_request_json_updated_at;

-- Create table
CREATE TABLE t_order_request (
                                                                    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                                                    order_request_details JSONB,
                                                                    good_received_notes_details JSONB,
                                                                    delivery_notes_details JSONB,
                                                                    request_destroy_details JSONB,
                                                                    resolve_issue_details JSONB,
                                                                    cancel_details JSONB,
                                                                    order_request_status VARCHAR,
                                                                    is_gri BOOLEAN,
                                                                    is_sticker_received BOOLEAN,
                                                                    gri_date TIMESTAMP,
                                                                    sticker_received_date TIMESTAMP,
                                                                    created_by VARCHAR,
                                                                    created_at TIMESTAMP,
                                                                    updated_by VARCHAR,
                                                                    updated_at TIMESTAMP
);

-- Create indexes
CREATE INDEX idx_order_request_json_created_at ON t_order_request(created_at);
CREATE INDEX idx_order_request_json_updated_at ON t_order_request(updated_at);

-- CREATE EXTENSION
CREATE EXTENSION IF NOT EXISTS "pgcrypto";
