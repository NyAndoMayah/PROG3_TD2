create table if not exists team
(
    id     serial
    constraint team_pk primary key,
    "name" varchar not null
);

create table if not exists player
(
    id      serial
    constraint player_fk primary key,
    "name"  varchar not null,
    number  int     not null,
    id_team int     not null,
    constraint fk_team foreign key (id_team) references team (id)
    );

create table if not exists sponsor
(
    id     serial
    constraint sponsor_pk primary key,
    "name" varchar not null
);

create table if not exists have_sponsor
(
    id         serial
    constraint have_sponsor_pk primary key,
    id_team    int not null,
    constraint fk_have_sponsor_team foreign key (id_team) references team (id),
    id_sponsor int not null,
    constraint fk_have_sponsor_sponsor foreign key (id_sponsor) references sponsor (id)
    );

create table if not exists play_against
(
    id          serial
    constraint play_against_pk primary key,
    datetime    date    not null,
    stadium     varchar not null,
    constraint unique_datetime_stadium unique (datetime, stadium),
    id_home     int     not null,
    constraint fk_id_home foreign key (id_home) references team (id),
    id_opponent int     not null,
    constraint fk_id_opponent foreign key (id_opponent) references team (id)
    );