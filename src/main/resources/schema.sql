DROP TABLE IF EXISTS notes CASCADE;
CREATE TABLE notes (
    id bigserial PRIMARY KEY NOT NULL,
    name varchar(255) DEFAULT NULL,
    note text NOT NULL,
    creation_date date NOT NULL
);

CREATE INDEX idx_notes_name ON notes(name);
CREATE INDEX idx_notes_creation_date ON notes(creation_date);

DROP TABLE IF EXISTS hashtags CASCADE;
CREATE TABLE hashtags (
    id bigserial PRIMARY KEY NOT NULL,
    note_id bigint NOT NULL,
    hashtag varchar(255) NOT NULL,
    CONSTRAINT fk_hashtags_notes FOREIGN KEY (note_id) REFERENCES notes (id)
);