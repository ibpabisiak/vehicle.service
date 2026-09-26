-- Enable UUID generation support used by later migrations and dummy data
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- Create vehicles table
CREATE TABLE IF NOT EXISTS vehicles (
    id UUID PRIMARY KEY,
    manufacturer VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    year INTEGER,
    vin VARCHAR(255) UNIQUE,
    color VARCHAR(255),
    mileage INTEGER,
    engine_size INTEGER,
    fuel_type VARCHAR(255),
    transmission VARCHAR(255),
    plate_number VARCHAR(255) UNIQUE,
    status VARCHAR(255)
);

-- Create index for faster queries
CREATE INDEX IF NOT EXISTS idx_plate_number ON vehicles(plate_number);
CREATE INDEX IF NOT EXISTS idx_status ON vehicles(status);

