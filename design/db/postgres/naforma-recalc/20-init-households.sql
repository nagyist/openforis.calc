SET search_path TO naforma1_se, public;

------------------------------------------------------------
--- HOUSEHOLDS
------------------------------------------------------------

-- Copy table
DROP TABLE IF EXISTS _household;

CREATE TABLE _household AS 
SELECT * 
FROM household;

alter table _household
drop column district;

alter table _household
add column cnt integer;

update _household
set cnt = 1;

-- Convert household locations to PostGIS points in WGS84 
ALTER TABLE _household
ADD COLUMN location Geometry(Point,4326);

UPDATE _household
SET location = ST_Transform(
        ST_SetSRID(ST_Point(location_x, location_y), substring(location_srs from '[0-9]+$')::integer)
        , 4326);

-- Assign district to households
ALTER TABLE _household
ADD COLUMN district_id INTEGER;

UPDATE _household
SET district_id = a.aoi_id
FROM calc.aoi a 
WHERE ST_Contains(a.aoi_shape, location)
AND a.aoi_hierarchy_level_id = 3;

-- Report unmatched households
SELECT count(*)
FROM _household 
WHERE district_id IS NULL;

-- Assign region to households
ALTER TABLE _household
ADD COLUMN region_id INTEGER;

UPDATE _household
SET region_id = a.aoi_parent_id
FROM calc.aoi a 
WHERE a.aoi_id = district_id;

-- Assign zone to households
ALTER TABLE _household
ADD COLUMN zone_id INTEGER;

UPDATE _household
SET zone_id = a.aoi_parent_id
FROM calc.aoi a 
WHERE a.aoi_id = region_id;

-- Assign country to households
ALTER TABLE _household
ADD COLUMN country_id INTEGER;

UPDATE _household
SET country_id = a.aoi_parent_id
FROM calc.aoi a 
WHERE a.aoi_id = zone_id;

-- Report unmatched plots
SELECT COUNT(*)
FROM _household
WHERE country_id IS NULL;

-- Household counts per AOI

DROP TABLE IF EXISTS _households_per_district CASCADE;

CREATE TABLE _households_per_district AS 
SELECT 
    h.district_id,
    aoi.aoi_label AS district_name,
    count(*) as household_cnt
FROM
    _household h
INNER JOIN
    calc.aoi ON aoi.aoi_id = h.district_id
WHERE
    h.distance_to_forest >= 10
GROUP BY
    h.district_id,
    aoi.aoi_label
;
COMMENT ON TABLE _households_per_district IS 'No. of households interviewed within at least 10km of forest, by district';

DROP TABLE IF EXISTS _households_per_region CASCADE;

CREATE TABLE _households_per_region AS 
SELECT 
    h.region_id,
    aoi.aoi_label AS region_name,
    count(*) as household_cnt
FROM
    _household h
INNER JOIN
    calc.aoi ON aoi.aoi_id = h.region_id
WHERE
    h.distance_to_forest >= 10
GROUP BY
    h.region_id,
    aoi.aoi_label
;
COMMENT ON TABLE _households_per_region IS 'No. of households interviewed within at least 10km of forest, by region';


DROP TABLE IF EXISTS _households_per_zone CASCADE;

CREATE TABLE _households_per_zone AS 
SELECT 
    h.zone_id,
    aoi.aoi_label AS zone_name,
    count(*) as household_cnt
FROM
    _household h
INNER JOIN
    calc.aoi ON aoi.aoi_id = h.zone_id
WHERE
    h.distance_to_forest >= 10
GROUP BY
    h.zone_id,
    aoi.aoi_label
;
COMMENT ON TABLE _households_per_zone IS 'No. of households interviewed within at least 10km of forest, by zone';


DROP TABLE IF EXISTS _households_per_country CASCADE;

CREATE TABLE _households_per_country AS 
SELECT 
    h.country_id,
    aoi.aoi_label AS country_name,
    count(*) as household_cnt
FROM
    _household h
INNER JOIN
    calc.aoi ON aoi.aoi_id = h.country_id
WHERE
    h.distance_to_forest >= 10
GROUP BY
    h.country_id,
    aoi.aoi_label
;
COMMENT ON TABLE _households_per_country IS 'No. of households interviewed within at least 10km of forest, by region';

alter table _household
add column distance_to_forest_km numeric;

update _household
set distance_to_forest_km = distance_to_forest / 1000;

alter table _household
add column distance_to_forest_km numeric;

alter table _household
add column distance_to_forest_class integer;

update _household
set distance_to_forest_class = distance_to_forest_km::integer;


-- Clean household heads
DROP TABLE IF EXISTS _head;

create table _head 
as 
select * from head;

-- Set default genders if age specified or interviewed by missing
update _head
    set gender='0',
        gender_code_id = (select gender_code_id from gender_code where gender='0')
where 
    gender='NA' and position='head' and
    (interviewed='TRUE' or education_code_id != -1 or age is not null);

update _head
    set gender='1',
        gender_code_id = (select gender_code_id from gender_code where gender='1')
where 
    gender='NA' and position='spouse' and
    (interviewed='TRUE' or education_code_id != -1 or age is not null);


--alter table _household
--drop column head_gender;
--
--alter table _household
--drop column head_gender_code_id;

-- Add household head
alter table _household
add column head_gender varchar(255);

alter table _household
add column head_gender_code_id integer;

update _household
set 
    head_gender = head.gender,
    head_gender_code_id = head.gender_code_id
from 
    _head head
where
    _household.household_id = head.household_id AND head.position='head';


-- Default to spouse's gender when head is not specified
update _household
set 
    head_gender = head.gender, 
    head_gender_code_id = head.gender_code_id
FROM
    _head head
where
    head.household_id = _household.household_id 
and 
    head.position='spouse'
and 
    _household.head_gender='NA';    
    