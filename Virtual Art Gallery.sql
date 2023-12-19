-- Create database
create database VirtualArtGallery;

use VirtualArtGallery;

-- 1. Create artwork table
create table artwork (artwork_id int PRIMARY KEY,title varchar(255),description TEXT,creation_date DATE,medium varchar(100),image_url varchar(255));
alter table artwork add column artist_id int;
alter table artwork add foreign key(artist_id) references artist(artist_id);


-- 2. Create artist table
create table artist (artist_id int PRIMARY KEY,name varchar(255),biography text,birth_date DATE,nationality varchar(100),website varchar(255),contact_information varchar(255));

-- 3. Create user table
create table user (user_id INT PRIMARY KEY,username varchar(50),password varchar(255),email varchar(100),first_name varchar(50),last_name varchar(50),date_of_birth DATE,
    profile_picture varchar(255));

-- 4. Create gallery table
create table gallery (gallery_id INT PRIMARY KEY,name varchar(255),description TEXT,location varchar(255),curator int,opening_hours varchar(255),FOREIGN KEY (curator) REFERENCES artist(artist_id)
);

-- 5. Create user_favorite_artwork junction table
create table user_favorite_artwork (user_id INT,artwork_id int,PRIMARY KEY (user_id, artwork_id),FOREIGN KEY (user_id) references user(user_id),FOREIGN KEY (artwork_id) references artwork(artwork_id)
);

select * from user_favorite_artwork;
select * from artwork_gallery;

-- Create artwork_gallery junction table
create table artwork_gallery (artwork_id INT,gallery_id int,PRIMARY KEY (artwork_id, gallery_id),FOREIGN KEY (artwork_id) references artwork(artwork_id),FOREIGN KEY (gallery_id) references gallery(gallery_id)
);

-- Insert values into artwork table
insert artwork values
(1, 'painting 1', 'beautiful painting 1', '2023-01-01', 'oil on canvas', 'image_url_1', 1),
(2, 'sculpture 1', 'amazing sculpture 1', '2023-02-01', 'marble', 'image_url_2', 2),
(3, 'drawing 1', 'intricate drawing 1', '2023-03-01', 'pencil on paper', 'image_url_3', 3),
(4, 'digital art 1', 'innovative digital art 1', '2023-04-01', 'digital', 'image_url_4', 4),
(5, 'mixed media 1', 'creative mixed media art 1', '2023-05-01', 'various', 'image_url_5', 5),
(6, 'photography 1', 'captivating photography 1', '2023-06-01', 'photograph', 'image_url_6', 6),
(7, 'pottery 1', 'unique pottery 1', '2023-07-01', 'clay', 'image_url_7', 7),
(8, 'printmaking 1', 'exquisite printmaking 1', '2023-08-01', 'print on paper', 'image_url_8', 8),
(9, 'textile art 1', 'beautiful textile art 1', '2023-09-01', 'fabric', 'image_url_9', 9),
(10, 'woodwork 1', 'skillful woodwork 1', '2023-10-01', 'wood', 'image_url_10', 10);

select * from artwork;
select * from artist;
select * from user;
select * from gallery;
-- Insert values into artist table
INSERT INTO artist VALUES
(1, 'rajan sharma', 'talented artist 1', '1990-05-15', 'indian', 'www.rajansharma.com', 'contact_info_1'),
(2, 'priya verma', 'talented artist 2', '1985-12-10', 'indian', 'www.priyaverma.com', 'contact_info_2'),
(3, 'arjun singh', 'skilled artist 1', '1988-08-25', 'indian', 'www.arjunsingh.com', 'contact_info_3'),
(4, 'ananya roy', 'creative artist 1', '1993-03-05', 'indian', 'www.ananyaroy.com', 'contact_info_4'),
(5, 'vikram patel', 'innovative artist 1', '1992-06-18', 'indian', 'www.vikrampatel.com', 'contact_info_5'),
(6, 'deepika shah', 'expressive artist 1', '1987-11-30', 'indian', 'www.deepikashah.com', 'contact_info_6'),
(7, 'arjun mehta', 'experimental artist 1', '1995-04-12', 'indian', 'www.arjunmehta.com', 'contact_info_7'),
(8, 'neha gupta', 'versatile artist 1', '1991-09-08', 'indian', 'www.nehagupta.com', 'contact_info_8'),
(9, 'rohan kumar', 'inspiring artist 1', '1989-02-22', 'indian', 'www.rohankumar.com', 'contact_info_9'),
(10, 'anika singh', 'passionate artist 1', '1994-07-14', 'indian', 'www.anikasingh.com', 'contact_info_10');


-- Insert values into user table
insert into user values(1, 'user1', 'password1', 'user1@email.com', 'john', 'doe', '1995-08-20', 'profile_picture_1'),(2, 'user2', 'password2', 'user2@email.com', 'jane', 'smith', '1992-03-12', 'profile_picture_2'),
(3, 'user3', 'password3', 'user3@email.com', 'samir', 'ahuja', '1990-11-05', 'profile_picture_3'),(4, 'user4', 'password4', 'user4@email.com', 'priya', 'sharma', '1988-04-30', 'profile_picture_4'),
(5, 'user5', 'password5', 'user5@email.com', 'rahul', 'verma', '1993-07-18', 'profile_picture_5'),(6, 'user6', 'password6', 'user6@email.com', 'ananya', 'patel', '1991-02-15', 'profile_picture_6'),
(7, 'user7', 'password7', 'user7@email.com', 'vikram', 'shah', '1994-09-28', 'profile_picture_7'),(8, 'user8', 'password8', 'user8@email.com', 'deepika', 'mehta', '1987-06-22', 'profile_picture_8'),
(9, 'user9', 'password9', 'user9@email.com', 'arjun', 'gupta', '1992-12-14', 'profile_picture_9'),(10, 'user10', 'password10', 'user10@email.com', 'neha', 'kumar', '1989-05-07', 'profile_picture_10');

-- Insert 10 values into gallery table
insert gallery values(1, 'art gallery 1', 'great gallery 1', 'new delhi', 1, '9 am - 6 pm'),(2, 'modern art space', 'contemporary art gallery', 'mumbai', 2, '10 am - 8 pm'),
(3, 'creative gallery', 'innovative art space', 'bangalore', 3, '11 am - 7 pm'),(4, 'vibrant art studio', 'colorful studio', 'chennai', 4, '10:30 am - 6:30 pm'),
(5, 'urban gallery', 'city-inspired gallery', 'kolkata', 5, '10 am - 7 pm'),(6, 'serene art hub', 'peaceful art center', 'hyderabad', 6, '9:30 am - 5:30 pm'),
(7, 'experimental gallery', 'bold art space', 'pune', 7, '11 am - 8 pm'),(8, 'traditional art house', 'classic art venue', 'ahmedabad', 8, '10 am - 6 pm'),
(9, 'inspiration gallery', 'motivational art spot', 'jaipur', 9, '10:30 am - 7:30 pm'),(10, 'passionate art studio', 'enthusiastic studio', 'lucknow', 10, '10 am - 5 pm');

