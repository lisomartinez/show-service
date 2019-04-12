create table days_of_week
(
    day_of_week_id int auto_increment
        primary key,
    day            varchar(255) not null,
    constraint day
        unique (day)
);

create table genres
(
    genre_id int auto_increment
        primary key,
    name     varchar(255) not null,
    constraint name
        unique (name)
);

create table schedule
(
    schedule_id  int auto_increment
        primary key,
    time_of_show time null
);

create table schedule_days_of_week
(
    schedule_id     int not null,
    days_of_week_id int not null,
    primary key (schedule_id, days_of_week_id),
    constraint fk_schedule_days_of_week_days_of_week
        foreign key (days_of_week_id) references days_of_week,
    constraint fk_schedule_days_of_week_schedule
        foreign key (schedule_id) references schedule
);

create table shows
(
    show_id           int auto_increment
        primary key,
    tvmaze_id         int unique     not null,
    name              varchar(255)   not null,
    type              varchar(255)   not null,
    status            varchar(255)   not null,
    language          varchar(255)   not null,
    premiered         date           not null,
    runtime           int            not null,
    schedule_id       int            not null,
    image_url         varchar(1000)  not null,
    imdb_url          varchar(1000)  not null,
    official_site_url varchar(1000)  not null,
    tv_maze_url       varchar(1000)  not null,
    summary           varchar(10000) not null,
    last_update       timestamp      not null,
    rating            double         not null,
    constraint fk_show_schedule_id
        foreign key (schedule_id) references schedule
);

create table season
(
    show_id       int            not null,
    tvmaze_id     int unique     not null,
    season_id     int auto_increment
        primary key,
    number        int            not null,
    episode_order int            not null,
    premiere_date date           not null,
    end_date      date           not null,
    summary       varchar(10000) not null,
    image_url     varchar(1000)  not null,
    tvmaze_url    varchar(1000)  not null,
    constraint fk_season_show
        foreign key (show_id) references shows
);

create table episode
(
    episode_id int auto_increment
        primary key,
    tvmaze_id  int unique     not null,
    season_id  int            null,
    number     int            null,
    name       varchar(255),
    airdate    date           null,
    airtime    time           null,
    runtime    int            null,
    summary    varchar(10000) null,
    image_url  varchar(1000)  null,
    tvmaze_url varchar(1000)  null,
    constraint fk_episode_season
        foreign key (season_id) references season
);

create index idxepisode_name
    on episode (name);

create index idxepisode_number
    on episode (number);

create index idxseason
    on season (number);

create table show_genre
(
    shows_show_id   int not null,
    genres_genre_id int not null,
    constraint fk_show_genre_genre
        foreign key (shows_show_id) references shows,
    constraint fk_show_genre_show
        foreign key (genres_genre_id) references genres
);

create index idxshow_name
    on shows (name);

create table users
(
    user_id           int auto_increment
        primary key,
    username          varchar(255) null,
    password          varchar(255) null,
    registration_date timestamp    null,
    active            tinyint(1)   null,
    email             varchar(255) null
);

create table users_roles
(
    id      int auto_increment
        primary key,
    user_id int          not null,
    role    varchar(255) not null,
    constraint fk_users_users_roles
        foreign key (user_id) references users
);


create table cards
(
    id         varchar(255) primary key,
    genre_name varchar(255),
    show_id    INTEGER,
    name       varchar(255),
    image_url  varchar(255),
    rating     double,
    seasons    bigint
)
