insert into cozinha (nome)values('Chinesa');
insert into cozinha (nome)values('Japonesa');
insert into restaurante (nome,taxa_frete, cozinha_id)values('Saiko',5, 2);
insert into restaurante (nome,taxa_frete, cozinha_id)values('JinJin', 7, 1);

insert into forma_pagamento (descricao)values('Cartão de Crédito');
insert into forma_pagamento (descricao)values('Cartão de Débito');
insert into forma_pagamento (descricao)values('Dinheiro');
insert into forma_pagamento (descricao)values('PIX');

insert into permissao (nome, descricao)values('ConsultarPedido', 'Consulta Pedidos de clientes');
insert into permissao (nome, descricao)values('ConfirmarPedido', 'Aceita pedido realizado pelo cliente');
insert into permissao (nome, descricao)values('EntregaPedido', 'Confirma a retirada do pedido no balcão e finaliza Entrega.');

insert into estado (nome)values('Paraná');
insert into estado (nome)values('São Paulo');

insert into cidade (nome, estado_id)values('Londrina', 1);
insert into cidade (nome, estado_id)values('Cambé', 1);
insert into cidade (nome, estado_id)values('Rolândia', 1);
insert into cidade (nome, estado_id)values('São Paulo', 2);
insert into cidade (nome, estado_id)values('Guarulhos', 2);