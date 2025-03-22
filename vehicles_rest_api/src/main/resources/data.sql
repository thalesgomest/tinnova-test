INSERT INTO vehicles (id, nome, marca, ano, cor, descricao, vendido, created_at, updated_at)
VALUES 
  (1, 'Fusion', 'FORD', 2020, 'Black', 'Ford Fusion 2020, modelo top de linha, excelente estado.', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (2, 'Cruze', 'CHEVROLET', 2021, 'White', 'Chevrolet Cruze 2021, muito bem conservado.', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (3,'Corolla', 'TOYOTA', 2022, 'Silver', 'Toyota Corolla 2022, completo, com baixo km.', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (4,'Civic', 'HONDA', 2021, 'Blue', 'Honda Civic 2021, novo e muito econômico.', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (5,'Palio', 'FIAT', 2018, 'Red', 'Fiat Palio 2018, ótimo para quem busca um carro compacto e econômico.', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (6,'Altima', 'NISSAN', 2019, 'Grey', 'Nissan Altima 2019, excelente conforto e desempenho.', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (7,'X1', 'BMW', 2021, 'White', 'BMW X1, 2021, premium, design moderno.', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (8,'A-Class', 'MERCEDES', 2020, 'Black', 'Mercedes-Benz A-Class, 2020, luxo e sofisticação.', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (9,'A3', 'AUDI', 2021, 'Green', 'Audi A3 2021, sedan compacto de alta performance.', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (10,'Gol', 'VOLKSWAGEN', 2019, 'Yellow', 'Volkswagen Gol, 2019, confiável e robusto.', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

ALTER TABLE vehicles ALTER COLUMN id RESTART WITH 11;
