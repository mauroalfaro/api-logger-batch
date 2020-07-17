CREATE TABLE LogEvent  (
    sku integer NOT NULL PRIMARY KEY,
    name varchar(20),
    description varchar(20),
    longDescription varchar(80),
    category varchar(20),
    price integer,
    authorizedForSale varchar(20),
    dateImported date
);
