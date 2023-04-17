CREATE TABLE IF NOT EXISTS users.users
(
    id uuid not null
    constraint users_pkey primary key,
    telegram_id varchar,
    username varchar,
    first_name varchar,
    last_name varchar
);