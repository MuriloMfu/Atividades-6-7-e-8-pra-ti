-- EXERCÍCIO 2 — Modelagem do Banco de Dados (PostgreSQL)

CREATE TABLE item (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    titulo VARCHAR(150) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('livro', 'revista')),
    autor VARCHAR(100),
    edicao VARCHAR(20),
    disponivel BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE usuario (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('aluno', 'professor')),
    limite_itens INT NOT NULL
);

CREATE TABLE emprestimo (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id INT NOT NULL REFERENCES item(id),
    usuario_id INT NOT NULL REFERENCES usuario(id),
    data_retirada DATE NOT NULL DEFAULT CURRENT_DATE,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10, 2) DEFAULT 0.00
);

-- Dados de Teste
INSERT INTO usuario (nome, tipo, limite_itens) VALUES
('Carlos Santos', 'aluno', 3),
('Dra. Maria Fernandes', 'professor', 5);

INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel) VALUES
('L01', 'Java para Iniciantes', 'livro', 'Herbert Schildt', '11ª Ed.', false),
('L02', 'Estruturas de Dados', 'livro', 'Robert Lafore', '2ª Ed.', true),
('L03', 'Arquitetura Clean', 'livro', 'Robert C. Martin', '1ª Ed.', true),
('R01', 'Tech Monthly', 'revista', 'Editora Tech', 'Ed. 45', true);

INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa) VALUES
(2, 1, '2026-08-01', '2026-08-15', '2026-08-22', 3.50),
(1, 1, '2026-09-01', '2026-09-15', NULL, 0.00);