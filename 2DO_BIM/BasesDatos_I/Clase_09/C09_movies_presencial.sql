use movies_db;
select * from movies;

-- ##### FUNCIONES DE AGREGACIÓN #####

-- ##### count() #####
select count(*) from movies; -- 21 registros

select count(id) from movies; -- 21 registros

select count(length) from movies; -- 17 registros, ignora campos nulos (null)

select count(created_at) from movies; -- 0

-- ##### avg(), sum() #####
select avg(rating) RatingAvg, sum(awards) AwardsSum from movies;

-- ##### min(), max() #####
select min(rating) MinRating, max(rating) MaxRating, min(release_date) OlderRelease, max(release_date) NewerRelease from movies;

-- Filtrando mediante el uso de where
select avg(rating) RatingAvg, sum(awards) AwardsSum from movies
where release_date >= "2000-01-01";

-- ##### group by #####
select genre_id, count(*) Total, avg(rating) RatingAvg, min(rating) MinRating, max(rating) MaxRating
from movies
group by genre_id;

select genre_id, count(*) Total, avg(rating) RatingAvg, sum(awards), max(release_date) NewerRelease
from movies
group by genre_id;

select year(release_date) ReleaseYear,genre_id, count(*) TotalReleases, avg(rating) RatingAvg from movies
group by ReleaseYear, genre_id
order by ReleaseYear; -- asc por default, puede ser tambien: desc

-- ##### having #####
select year(release_date) ReleaseYear, count(*) TotalReleases, avg(rating) RatingAvg, sum(awards) TotalAwards
from movies
group by ReleaseYear
-- having ReleaseYear >= 2000
-- having RatingAvg > 5
having RatingAvg > 5 and TotalAwards > 5
order by ReleaseYear;