INSERT INTO vehicles (id, nome, marca, ano, cor, descricao, vendido, created_at, updated_at)
VALUES 
  (1, 'Fusion', 'FORD', 2020, 'Preto', 'Ford Fusion 2020, modelo top de linha, excelente estado.', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (2, 'Cruze', 'CHEVROLET', 2021, 'Branco', 'Chevrolet Cruze 2021, muito bem conservado.', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (3,'Corolla', 'TOYOTA', 2022, 'Prata', 'Toyota Corolla 2022, completo, com baixo km.', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (4,'Civic', 'HONDA', 2021, 'Azul', 'Honda Civic 2021, novo e muito economico.', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (5,'Palio', 'FIAT', 2018, 'Vermelho', 'Fiat Palio 2018, otimo para quem busca um carro compacto e economico.', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (6,'Altima', 'NISSAN', 2019, 'Cinza', 'Nissan Altima 2019, excelente conforto e desempenho.', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (7,'X1', 'BMW', 2021, 'Branco', 'BMW X1, 2021, premium, design moderno.', TRUE, CURRENT_TIMESTAMP - INTERVAL '10' DAY, CURRENT_TIMESTAMP),
  (8,'A-Class', 'MERCEDES', 2020, 'Preto', 'Mercedes-Benz A-Class, 2020, luxo e sofisticacao.', FALSE, CURRENT_TIMESTAMP - INTERVAL '12' DAY, CURRENT_TIMESTAMP),
  (9,'A3', 'AUDI', 2021, 'Verde', 'Audi A3 2021, sedan compacto de alta performance.', TRUE, CURRENT_TIMESTAMP - INTERVAL '8' DAY, CURRENT_TIMESTAMP),
  (10,'Gol', 'VOLKSWAGEN', 2019, 'Amarelo', 'Volkswagen Gol, 2019, confiavel e robusto.', FALSE, CURRENT_TIMESTAMP - INTERVAL '14' DAY, CURRENT_TIMESTAMP);




ALTER TABLE vehicles ALTER COLUMN id RESTART WITH 11;
