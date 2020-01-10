-- Include table data insertion, updation, deletion and select scripts

-- -------------------------------------------------------------------
-- Inserting values into Movie Item Table
-- -------------------------------------------------------------------

insert into movie_item 
values
(1, 'Avatar', 2787965087, 'Yes', '2017-07-15',
					'Science Fiction', 'Yes'),
(2, 'The Avengers', 1518812988, 'Yes', '2017-12-23',
					'Super Hero', 'No'),
(3, 'Titanic', 2187463944, 'Yes', '2017-08-21', 'Romance', 'No'),
(4, 'Jurrasic World', 1671713208, 'No', '2017-07-02',
					'Science Fiction', 'Yes'),
(5, 'Avengers: End Game', 2750760348, 'Yes', '2022-11-02',
					'Super Hero', 'Yes');
                    
-- ---------------------------------------------------------------------
-- Retrieving Admin Movie Items
-- ---------------------------------------------------------------------

select 
mv_id Movie_Id ,
mv_title Title ,
mv_box Box_Office ,
mv_active Active , 
mv_date_of_launch Date_Of_Launch ,
mv_genre Genre ,
mv_teaser Has_Teaser
from movie_item;

-- ----------------------------------------------------------------------
-- Updating Admin Movie Item
-- Edit Movie Item
-- ----------------------------------------------------------------------

update movie_item
set mv_title = "Frozen"
where mv_id = 2;


update movie_item
set 
mv_title = "Frozen",
mv_box = 221548785 ,
mv_active = 'No' ,
mv_date_of_launch = '2019-11-30' ,
mv_genre = 'Super Hero',
mv_teaser = 'Yes'
where mv_id = 2;

-- -----------------------------------------------------------------------
-- Inserting into User Table
-- -----------------------------------------------------------------------

insert into user
values
(1,'Ajay'),
(2,'Bindhu');

-- ------------------------------------------------------------------------
-- Inserting into Favorite table
-- ------------------------------------------------------------------------

insert into favorite (fv_user_id , fv_mv_id)
values
(1,2),
(1,4),
(1,5),
(2,1),
(2,5);

-- -------------------------------------------------------------------------
-- Retrieving User Movie List
-- Customer Movie List
-- -------------------------------------------------------------------------

select 
mv_title as Title ,
mv_box as Box_Office ,
mv_genre as Genre ,
mv_teaser as Has_Teaser
from movie_item
where 
mv_active='Yes' and mv_date_of_launch < current_date();


select
mv_title as Title ,
mv_box as Box_Office ,
mv_genre as Genre ,
mv_teaser as Has_Teaser
from movie_item m
join favorite f on (m.mv_id = f.fv_mv_id)
where f.fv_user_id=1;

-- ---------------------------------------------------------------------------
-- No of favorites
-- ---------------------------------------------------------------------------

select count(mv_title) No_Of_Favorites
from movie_item m
join favorite f on (m.mv_id = f.fv_mv_id)
where f.fv_user_id=2;

-- ----------------------------------------------------------------------------
-- Delete from Favorites
-- ----------------------------------------------------------------------------

delete from favorite
where fv_user_id = 2 and fv_mv_id = 1;

-- ----------------------------------------------------------------------------
-- 
-- ----------------------------------------------------------------------------