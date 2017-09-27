DELETE FROM roles;
INSERT INTO roles VALUES (1, 'ROLE_USER'),(2, 'ROLE_ADMIN');

INSERT INTO users (country, user_id, email, password, first_name) VALUES ('UK', 1, 'admin@gmail.com', 'admin1234', 'Admin');
INSERT INTO user_role (User_country, User_user_id, roles_role_pk) VALUES ('UK', 1, 2);
INSERT INTO users (country, user_id, email, password, first_name) VALUES ('UK', 2, 'user@gmail.com', 'user1234', 'User');
INSERT INTO user_role (User_country, User_user_id, roles_role_pk) VALUES ('UK', 2, 1);