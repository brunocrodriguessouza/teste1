CREATE TABLE beverage (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(50) NOT NULL,
    type VARCHAR(20) NOT NULL,
    volume DECIMAL(10,2) NOT NULL,    
    section_id BIGINT(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO beverage (description, type, volume, section_id) values ('Coca Cola', 'NON_ALCOHOLIC', 1.00, 1);
INSERT INTO beverage (description, type, volume, section_id) values ('Fanta', 'NON_ALCOHOLIC', 1.00, 1);
INSERT INTO beverage (description, type, volume, section_id) values ('Sprite', 'NON_ALCOHOLIC', 1.00, 1);
INSERT INTO beverage (description, type, volume, section_id) values ('Skol', 'ALCOHOLIC', 1.00, 1);
INSERT INTO beverage (description, type, volume, section_id) values ('Bavaria', 'NON_ALCOHOLIC', 1.00, 1);