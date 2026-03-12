--table creation
create table vehicle(id serial primary key, vehiclenumber varchar(20), type varchar(20), capacity integer);
create table trip(id serial primary key, vehicle_id integer references vehicle(id), fuel_cost integer, revenue integer, trip_date date);

--data insertion in to the table
insert into vehicle values (1, 'AB59WI1234', 'Tanker', 20);
insert into vehicle values (2, 'AB59WI1235', 'Tanker', 14);
insert into vehicle values (3, 'AB59WI1236', 'Tanker', 20);
insert into vehicle values (4, 'AB59WI1237', 'Tanker', 20);
insert into vehicle values (5, 'AB59WI1238', 'Tanker', 20);
insert into vehicle values (6, 'AB59WI1239', 'Tanker', 22);

insert into trip values(1, 5, 3450, 50000, '2026-02-18');
insert into trip values(2, 1, 2450, 40000, '2026-02-18');
insert into trip values(3, 4, 3000, 45000, '2026-02-18');
insert into trip values(4, 3, 3250, 110000, '2026-02-18');
insert into trip values(5, 2, 2310, 100000, '2026-02-18');

--Displaying the data in the table
select * from vehicle;
select * from trip;

--Inner join -> only returns the data present in both the table
select * from vehicle inner join trip on vehicle.id = trip.vehicle_id;
--Left join -> returns all the data from the left table and null values from the records which does not match to the left table data
select * from vehicle left join trip on vehicle.id = trip.vehicle_id;
--Right join -> returns all the data from the right table if any value in present in the left table that does not match to the right table is skipped
select * from vehicle right join trip on vehicle.id = trip.vehicle_id;

--Group by -> group the values based on the record value
select vehicle_id, sum(revenue) from trip group by vehicle_id;
--Having -> filter the data after applying grouping to the data (aggregations can be used)
select vehicle_id, sum(revenue) from trip group by vehicle_id having sum(revenue) > 50000;
--Where -> filter the data before applying grouping (aggreations cannot be used)
select * from trip where fuel_cost > 3000;
--Aggregate functions -> does all kind of aggreations like min, max, sum, count in the data
select count (*) as trips_count, avg (fuel_cost) as fuel_expense, sum (revenue) as gross_revenue, max (revenue) as highest_revenue, min (fuel_cost) as minimum_fuel_cost from trip;

-- Sub queries -> used to fetch the data with specific condition and with the returned data is acting as the filter in the main query
select * from trip join vehicle on (vehicle.id = trip.vehicle_id)where revenue > (select avg(revenue) from trip);

-- CTE - Common table expression -> if the same sub querie need to be used multiple times we can have as the common table expression and use it where we needed just calling the expression instead of the entire sub query again
with vehicle_revenue as ( select vehicle.vehiclenumber, vehicle.id, sum(revenue) as total_revenue, avg(fuel_cost) as avg_fuel_cost, count(trip.id) as no_of_trip from trip join vehicle on vehicle.id = trip.vehicle_id group by vehicle.id), top_performing_vehicle as ( select * from vehicle_revenue where total_revenue = (select max ( total_revenue ) from vehicle_revenue)) select * from top_performing_vehicle;
-- Window functions
-- rank() -> used to rank the records based on our specific condition and if a tie between records occurs it will give the same number to those records and skip the next record rank to the next sequential order (if both record has tied it will give 2 for both them then the next rank will be 4)
select *, rank() over (order by revenue desc) as truck_revenue, sum (revenue) over (partition by trip.vehicle_id) from trip join vehicle on trip.vehicle_id = vehicle.id;
-- row_number() gives unique sequential number per partition
-- partition by resets counter for each vehicle
-- useful to get TOP 1 record per group using WHERE row_number = 1
select * from (select *, row_number() over (partition by trip.vehicle_id order by revenue desc) as row_number from trip join vehicle on vehicle.id = trip.vehicle_id) where row_number = 1;
-- lag -> returns the previous record's value returns null if it is first record
-- lead -> returns the next record's value returns null if it is the last record
-- partition -> performs our operation within the same vehicle_id here
select *, lag(trip.revenue) over(partition by vehicle_id order by trip_date), lead(trip.revenue) over(partition by vehicle_id order by trip_date) from trip join vehicle on vehicle.id = trip.vehicle_id;