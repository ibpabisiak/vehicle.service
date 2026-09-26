-- Insert 107 dummy vehicles
INSERT INTO vehicles (id, manufacturer, model, year, vin, color, mileage, engine_size, fuel_type, transmission, plate_number, status)
SELECT
    gen_random_uuid(),
    (ARRAY['Toyota', 'Ford', 'Honda', 'Chevrolet', 'Nissan', 'BMW', 'Audi', 'Kia', 'Hyundai', 'Mercedes',
           'Volkswagen', 'Mazda', 'Lexus', 'Subaru', 'Jeep', 'Tesla', 'Volvo', 'Peugeot', 'Renault', 'Fiat'])[ ((i-1) % 20) + 1 ],
    (ARRAY['Model X', 'Model Y', 'Model Z', 'Sedan', 'SUV', 'Hatchback', 'Convertible', 'Coupe', 'Wagon', 'Crossover'])[ ((i-1) % 10) + 1 ],
    2010 + ((i-1) % 15),
    '1HGCM82633A' || LPAD((100000 + (i-1))::text, 6, '0'),
    (ARRAY['Red', 'Blue', 'Black', 'White', 'Gray', 'Silver', 'Green', 'Yellow', 'Orange', 'Brown'])[ ((i-1) % 10) + 1 ],
    30000 + ((i-1) * 5000),
    1600 + (((i-1) % 5) * 200),
    (ARRAY['Petrol', 'Diesel', 'Hybrid', 'Electric'])[ ((i-1) % 4) + 1 ],
    (ARRAY['Manual', 'Automatic'])[ ((i-1) % 2) + 1 ],
    'PLT' || LPAD((100 + (i-1))::text, 3, '0'),
    (ARRAY['Available', 'Rented', 'Maintenance'])[ ((i-1) % 3) + 1 ]
FROM generate_series(1, 107) AS t(i)
ON CONFLICT (vin) DO NOTHING;

