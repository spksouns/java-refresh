-- ============================================
-- SQL PERFORMANCE & INDEXES
-- ============================================

-- TABLE CREATION
create table vehicle(id serial primary key, vehiclenumber varchar(20), type varchar(20), capacity integer);
create table trip(id serial primary key, vehicle_id integer references vehicle(id), fuel_cost integer, revenue integer, trip_date date);

-- DATA INSERTION
insert into vehicle values (1, 'AB59WI1234', 'Tanker', 20);
insert into vehicle values (2, 'AB59WI1235', 'Tanker', 14);
insert into vehicle values (3, 'AB59WI1236', 'Tanker', 20);
insert into vehicle values (4, 'AB59WI1237', 'Tanker', 20);
insert into vehicle values (5, 'AB59WI1238', 'Tanker', 20);
insert into vehicle values (6, 'AB59WI1239', 'Tanker', 22);

INSERT INTO trip (vehicle_id, fuel_cost, revenue, trip_date)
VALUES
    (5, 3450, 50000, '2026-02-18'),
    (1, 2450, 40000, '2026-02-18'),
    (4, 3000, 45000, '2026-02-18'),
    (3, 3250, 110000, '2026-02-18'),
    (2, 2310, 100000, '2026-02-18');

-- 1000 random rows for performance testing
INSERT INTO trip (vehicle_id, fuel_cost, revenue, trip_date)
SELECT
    (random() * 4 + 1)::int,
    (random() * 5000 + 1000)::int,
    (random() * 100000 + 10000)::int,
    '2026-01-01'::date + (random() * 365)::int
FROM generate_series(1, 1000);

-- Fix sequence after manual inserts
SELECT setval('trip_id_seq', (SELECT MAX(id) FROM trip));

-- ============================================
-- INDEXES
-- ============================================

-- Single column index
create index on trip(revenue);

-- Composite index - vehicle_id must be first (left prefix rule)
create index on trip(vehicle_id, trip_date);

-- ============================================
-- EXPLAIN ANALYZE - execution plan demos
-- ============================================

-- Index Scan (primary key - 1 row)
explain analyze select * from trip where id = 3;

-- Bitmap Scan (revenue index - multiple rows possible)
explain analyze select * from trip where revenue = 110000;

-- BEFORE composite index: Seq Scan, 1005 rows removed
-- AFTER composite index: Index Scan, 0 rows wasted
explain analyze select * from trip
                where vehicle_id = 3 and trip_date = '2026-01-01';