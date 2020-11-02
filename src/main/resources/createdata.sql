create table bloguser (
    userId int auto_increment,
    userName varchar(255) not null,
    userPassword varchar(255) not null,
    userDescription varchar(255) not null,
    userGender char(1),
    userCreateTime datetime not null,
    userBirthDay date,
    userBlogCount int default 0,
    userEmail varchar(255),
    userFollowCount int default 0,
    userFansCount int default 0,
    primary key(userId)
);

create table blogcategory(
    categoryId int auto_increment,
    categoryName varchar(255) not null,
    categoryDescription varchar(255),
    categoryCount int default 0,
    primary key(categoryId)
);

create table bloglabel(
    labelId int auto_increment,
    labelName varchar(255) not null,
    labelDescription varchar(255),
    primary key(labelId)
);

create table blog(
    blogId int auto_increment,
    blogTitle varchar(255) not null,
    blogContent MEDIUMTEXT not null,
    blogReadTimes int default 0,
    blogCommentTimes int default 0,
    blogEditTime datetime not null,
    blogUserId int not null,
    blogCategoryId int,
    primary key(blogId)
);

create table bloglabelmap(
    blogLabelId int auto_increment,
    blogId int not null,
    labelId int not null,
    primary key(blogLabelId)
);

CREATE TABLE blogcomment(
    blogCommentId INT AUTO_INCREMENT,
    blogCommentContents VARCHAR(4096) NOT NULL,
    blogCommentTime DATETIME NOT NULL,
    blogCommentUserId INT NOT NULL,
    blogCommentBlogId INT NOT NULL,
    blogCommentBlogSonId INT NOT NULL,
    blogCommentFather INT NOT NULL,
    PRIMARY KEY(blogCommentId)
);

create table followfanmap(
    followFanId int auto_increment,
    followUserId int not null,
    fanUserId int not null,
    primary key(followFanId)
);