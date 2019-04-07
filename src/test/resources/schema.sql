create table days_of_week
(
	day_of_week_id integer primary key auto_increment,
	day            varchar(255) not null unique
);
create table genre
(
	genre_id integer primary key auto_increment,
	name     varchar(255) not null unique
);
create table schedule
(
	schedule_id  integer primary key auto_increment,
	time_of_show time
);
create table schedule_days_of_week
(
    schedule_id     integer not null,
    days_of_week_id integer not null,
    primary key (schedule_id, days_of_week_id),
    constraint fk_schedule_days_of_week_days_of_week foreign key (days_of_week_id) references days_of_week,
    constraint fk_schedule_days_of_week_schedule foreign key (schedule_id) references schedule
);


create table show
(
    show_id           integer PRIMARY KEY AUTO_INCREMENT,
    tvmaze_id         integer        not null unique,
    name              varchar(255)   not null,
    type              varchar(255)   not null,
    status            varchar(255)   not null,
    language          varchar(255)   not null,
    premiered         date           not null,
    runtime           integer        not null,
    schedule_id       integer        not null,
    image_url         varchar(255)   not null,
    imdb_url          varchar(255)   not null,
    official_site_url varchar(255)   not null,
    tv_maze_url       varchar(255)   not null,
    summary           varchar(10000) not null,
    last_update       timestamp      not null,
    rating            double         not null,
    constraint fk_show_schedule_id foreign key (schedule_id) references schedule
);

create index idxshow_name on show (name);

create table show_genre
(
    show_id  integer not null,
    genre_id integer not null,
    constraint fk_show_genre_show foreign key (genre_id) references genre,
    constraint fk_show_genre_genre foreign key (show_id) references show
);

create table season
(
    season_id     integer PRIMARY KEY AUTO_INCREMENT,
    show_id       integer,
    tvmaze_id     integer        not null unique,
    end_date      date           not null,
    episode_order integer        not null,
    image_url     varchar(255)   not null,
    number        integer        not null,
    premiere_date date           not null,
    summary       varchar(10000) not null,
    tvmaze_url    varchar(255)   not null,
    constraint fk_season_show foreign key (show_id) references show
);

create index idxseason on season (number);


create table episode
(
    episode_id integer PRIMARY KEY AUTO_INCREMENT,
    season_id  integer,
    tvmaze_id  integer not null unique,
    airdate    date,
    airtime    time,
    image_url  varchar(255),
    name       varchar(255),
    number     integer,
    runtime    integer,
    summary    varchar(10000),
    tvmaze_url varchar(255),
    constraint fk_episode_season foreign key (season_id) references season
);

create index idxepisode_name on episode (name);
create index idxepisode_number on episode (number);


create table users
(
	user_id           integer PRIMARY KEY AUTO_INCREMENT,
	username          VARCHAR(255),
	password          VARCHAR(255),
	registration_date TIMESTAMP,
	active            BOOLEAN,
	email             VARCHAR(255)
);

create table users_roles
(
    id integer primary key AUTO_INCREMENT,
    user_id integer      NOT NULL,
    role    varchar(255) NOT NULL,
    constraint fk_users_users_roles foreign key (user_id) references users
);

