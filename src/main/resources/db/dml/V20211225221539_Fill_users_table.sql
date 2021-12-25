INSERT INTO users(username, password, enabled)
VALUES ('alex', '{noop}alex', true),
       ('tom', '{noop}tom', true),
       ('admin', '{noop}admin', true);

INSERT INTO authorities(username, authority)
VALUES ('admin', 'MANAGER'),
       ('admin', 'HR'),
       ('admin', 'EMPLOYEE'),
       ('alex', 'MANAGER'),
       ('tom', 'EMPLOYEE');
