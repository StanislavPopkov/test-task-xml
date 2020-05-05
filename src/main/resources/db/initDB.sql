DROP TABLE IF EXISTS documents_type;

CREATE TABLE documents_type
(
    id               SERIAL PRIMARY KEY,
    type             VARCHAR(255)                 NOT NULL
    );
CREATE UNIQUE INDEX type_idx ON documents_type (type);