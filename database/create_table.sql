use newjdbc1month2020;

CREATE TABLE role (
	id bigint NOT NULL PRIMARY KEY auto_increment,
    name varchar(255) NOT NULL,
    code varchar(255) NOT NULL,
    created_date TIMESTAMP NULL,
    modified_date TIMESTAMP NULL,
    created_by VARCHAR(255) NULL,
    modified_by VARCHAR(255) NULL
);


CREATE TABLE user(
	id bigint NOT NULL PRIMARY KEY auto_increment,
    name varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    fullname varchar(255) NUll,
    status int not null,
    roleid bigint not null,
    created_date TIMESTAMP NULL,
    modified_date TIMESTAMP NULL,
    created_by VARCHAR(255) NULL,
    modified_by VARCHAR(255) NULL
);

ALTER TABLE user ADD constraint fk_user_role foreign key (roleid) references role(id);

CREATE TABLE news(
	id bigint NOT NULL PRIMARY KEY auto_increment,
    title varchar(255) NULL,
    thumbnail varchar(255) NULL,
    categoryid bigint not null,
    short_desc text  NULL,
    content text  NULL,
    created_date TIMESTAMP NULL,
    modified_date TIMESTAMP NULL,
    created_by VARCHAR(255) NULL,
    modified_by VARCHAR(255) NULL
);

CREATE TABLE category(
	id bigint NOT NULL PRIMARY KEY auto_increment,
    name varchar(255) NOT NULL,
    code varchar(255) NOT NULL,
    created_date TIMESTAMP NULL,
    modified_date TIMESTAMP NULL,
    created_by VARCHAR(255) NULL,
    modified_by VARCHAR(255) NULL
);

ALTER TABLE news ADD constraint fk_news_category foreign key (categoryid) references category(id);



CREATE TABLE comment (
	id bigint NOT NULL PRIMARY KEY auto_increment,
    content text not null,
    user_id bigint not null,
    new_id bigint not null,
	created_date TIMESTAMP NULL,
    modified_date TIMESTAMP NULL,
    created_by VARCHAR(255) NULL,
    modified_by VARCHAR(255) NULL
);

ALTER TABLE comment ADD constraint fk_comment_user foreign key (user_id) references user(id);
ALTER TABLE comment ADD constraint fk_comment_news foreign key (new_id) references news(id);