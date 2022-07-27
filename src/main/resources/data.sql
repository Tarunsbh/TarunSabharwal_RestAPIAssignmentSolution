INSERT INTO users (id, username, password) VALUES 
(1, 'admin', '$2a$12$1oSt91dY/1S5dQlCWbTuwuwvxbwYI5SOU4GtdEJZggQnyouBeWmo2');
INSERT INTO users (id, username, password) VALUES 
(2, 'user', '$2a$12$7EJpz4nHY4Aimy3IqZa75.5fzG.06cLQewy0DI42baL0d2nOGK17G');

INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE');


INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);


INSERT INTO EMPLOYEE (id, email, first_name, last_name) VALUES 
(1, 'ankit@ankit.com', 'Ankit', 'Kumar'),
(2, 'tarun@tarun.com', 'Tarun', 'Sabharwal'),
(3, 'joseph@joseph.com', 'Joseph', 'Paul');