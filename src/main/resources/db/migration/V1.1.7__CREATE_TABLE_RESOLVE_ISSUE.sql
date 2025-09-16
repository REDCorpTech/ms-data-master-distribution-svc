-- Drop table if exists
DROP TABLE IF EXISTS t_resolve_issue;

-- Drop indexes if exist
DROP INDEX IF EXISTS idx_resolve_issue_created_at;
DROP INDEX IF EXISTS idx_resolve_issue_updated_at;
DROP INDEX IF EXISTS idx_resolve_issue_order_request_id;

-- Create table
CREATE TABLE t_resolve_issue (
                                 id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                 order_request_id UUID,
                                 resolve_note TEXT,
                                 created_by VARCHAR,
                                 created_at TIMESTAMP,
                                 updated_by VARCHAR,
                                 updated_at TIMESTAMP
);

-- Create indexes
CREATE INDEX idx_resolve_issue_created_at ON t_resolve_issue(created_at);
CREATE INDEX idx_resolve_issue_updated_at ON t_resolve_issue(updated_at);
CREATE INDEX idx_resolve_issue_order_request_id ON t_resolve_issue(order_request_id);

-- CREATE EXTENSION
CREATE EXTENSION IF NOT EXISTS "pgcrypto";
