CREATE TABLE binary_contents
(
    id           UUID PRIMARY KEY,
    created_at   TIMESTAMP WITH TIME ZONE NOT NULL,
    file_name    VARCHAR(255)             NOT NULL,
    size         BIGINT                   NOT NULL,
    content_type VARCHAR(100)             NOT NULL,
    bytes        BYTEA                    NOT NULL
);

CREATE TABLE channels
(
    id          UUID PRIMARY KEY,
    created_at  TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at  TIMESTAMP WITH TIME ZONE,
    name        VARCHAR(100),
    description VARCHAR(500),
    type        VARCHAR(10)              NOT NULL CHECK ( type IN ('PUBLIC', 'PRIVATE'))
);

CREATE TABLE users
(
    id         UUID PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE,
    username   VARCHAR(50) UNIQUE       NOT NULL,
    email      VARCHAR(100) UNIQUE      NOT NULL,
    password   VARCHAR(60)              NOT NULL,
    profile_id UUID UNIQUE              REFERENCES binary_contents (id) ON DELETE SET NULL
);