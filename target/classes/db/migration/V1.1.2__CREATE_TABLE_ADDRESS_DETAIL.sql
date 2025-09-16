-- Drop table if exists
DROP TABLE IF EXISTS t_address_detail;

-- Drop indexes if exist
DROP INDEX IF EXISTS idx_address_detail_created_at;
DROP INDEX IF EXISTS idx_address_detail_updated_at;
DROP INDEX IF EXISTS idx_address_detail_order_request_id;
DROP INDEX IF EXISTS idx_address_detail_qr_list_id;

-- Create table
CREATE TABLE t_address_detail (
                                  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                  order_request_id UUID NOT NULL,
                                  qr_list_id UUID,
                                  order_number INT,
                                  brand_id VARCHAR,
                                  brand_name VARCHAR,
                                  receiver VARCHAR,
                                  qr_range_from VARCHAR,
                                  qr_range_to VARCHAR,
                                  qr_qty VARCHAR,
                                  created_by VARCHAR,
                                  created_at TIMESTAMP,
                                  updated_by VARCHAR,
                                  updated_at TIMESTAMP
);

-- Create indexes
CREATE INDEX idx_address_detail_created_at ON t_address_detail(created_at);
CREATE INDEX idx_address_detail_updated_at ON t_address_detail(updated_at);
CREATE INDEX idx_address_detail_order_request_id ON t_address_detail(order_request_id);
CREATE INDEX idx_address_detail_qr_list_id ON t_address_detail(qr_list_id);

-- CREATE EXTENSION
CREATE EXTENSION IF NOT EXISTS "pgcrypto";
