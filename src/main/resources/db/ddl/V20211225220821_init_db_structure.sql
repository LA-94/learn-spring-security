CREATE TABLE users
(
    username VARCHAR(15) PRIMARY KEY,
    password VARCHAR(68),
    enabled  boolean
);

CREATE TABLE authorities
(
    username  VARCHAR(15),
    authority VARCHAR(25),

    CONSTRAINT authorities_username_fk FOREIGN KEY (username) REFERENCES users (username)
);
