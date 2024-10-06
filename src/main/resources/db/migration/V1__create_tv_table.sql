CREATE TABLE IF NOT EXISTS tv (
                    id SERIAL PRIMARY KEY,
                    brand VARCHAR(50) NOT NULL,
                    model VARCHAR(50) NOT NULL,
                    screen_size DECIMAL(5,2) NOT NULL,
                    resolution VARCHAR(20) NOT NULL,
                    price DECIMAL(10,2) NOT NULL,
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
