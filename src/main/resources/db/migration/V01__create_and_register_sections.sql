CREATE TABLE section (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(50) NOT NULL,
    type VARCHAR(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO section (description, type) values ('Corredor A', 'NON_ALCOHOLIC');
INSERT INTO section (description, type) values ('Corredor B', 'NON_ALCOHOLIC');
INSERT INTO section (description, type) values ('Corredor C', 'NON_ALCOHOLIC');
INSERT INTO section (description, type) values ('Corredor D', 'ALCOHOLIC');
INSERT INTO section (description, type) values ('Corredor E', 'NON_ALCOHOLIC');

