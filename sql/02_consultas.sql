-- EXERCÍCIO 3 — Consultas SQL

-- 1. Listar todo o acervo, com código, título, tipo e disponibilidade
SELECT codigo, titulo, tipo, disponivel 
FROM item;

-- 2. Listar os empréstimos em aberto, com o nome do usuário e o título do item
SELECT u.nome AS usuario, i.titulo AS item, e.data_retirada, e.data_devolucao_prevista
FROM emprestimo e
JOIN usuario u ON e.usuario_id = u.id
JOIN item i ON e.item_id = i.id
WHERE e.data_devolucao IS NULL;

-- 3. Calcular o total de multas acumuladas por usuário
SELECT u.nome AS usuario, SUM(e.valor_multa) AS total_multas
FROM usuario u
JOIN emprestimo e ON u.id = e.usuario_id
GROUP BY u.id, u.nome;

-- 4. Listar os itens que nunca foram emprestados (usando LEFT JOIN + IS NULL)
SELECT i.id, i.codigo, i.titulo, i.tipo
FROM item i
LEFT JOIN emprestimo e ON i.id = e.item_id
WHERE e.id IS NULL;