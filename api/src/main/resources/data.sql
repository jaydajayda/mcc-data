insert into CUSTOMERS (CUSTOMER_NAME, CUSTOMER_PASSWORD, CUSTOMER_EMAIL) VALUES ('SamBrinker', 'pass', 'sambrinker@mail.com');
insert into CUSTOMERS (CUSTOMER_NAME, CUSTOMER_PASSWORD, CUSTOMER_EMAIL) VALUES ('JaydaSchmidt', 'pass', 'jaydaschmidt@mail.com');
insert into CUSTOMERS (CUSTOMER_NAME, CUSTOMER_PASSWORD, CUSTOMER_EMAIL) VALUES ('JohnDoe', 'pass', 'johndoe@gmail.com');
insert into CUSTOMERS (CUSTOMER_NAME, CUSTOMER_PASSWORD, CUSTOMER_EMAIL) VALUES ('JaneDoe', 'pass', 'janedoe@gmail.com');

insert into EVENTS (EVENT_CODE, EVENT_TITLE, EVENT_DESCRIPTION) VALUES ('XMAS', 'Christmas', 'Merry Christmas!');
insert into EVENTS (EVENT_CODE, EVENT_TITLE, EVENT_DESCRIPTION) VALUES ('TKGV', 'Thanksgiving', 'Happy Thanksgiving!');

insert into REGISTRATIONS (EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, REGISTRATION_NOTES) VALUES (1, 1, '2022-12-25', 'Secret Santa gifts must be less than $25.');
insert into REGISTRATIONS (EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, REGISTRATION_NOTES) VALUES (2, 2, '2022-11-27', 'BYOD - Bring your own signature dish!');