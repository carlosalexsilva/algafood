insert into cozinha (nome)values('Chinesa');
insert into cozinha (nome)values('Japonesa');

insert into estado (nome)values('Paraná');
insert into estado (nome)values('São Paulo');

insert into cidade (nome, estado_id)values('Londrina', 1);
insert into cidade (nome, estado_id)values('Cambé', 1);
insert into cidade (nome, estado_id)values('Rolândia', 1);
insert into cidade (nome, estado_id)values('São Paulo', 2);
insert into cidade (nome, estado_id)values('Guarulhos', 2);

insert into restaurante (nome,taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, data_cadastro, data_atualizacao)values('Saiko',5, 2, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro', utc_timestamp, utc_timestamp);
insert into restaurante (nome,taxa_frete, cozinha_id, data_cadastro, data_atualizacao)values('JinJin', 7, 1, utc_timestamp, utc_timestamp);
insert into restaurante (nome,taxa_frete, cozinha_id, data_cadastro, data_atualizacao)values('China In Box', 10, 1, utc_timestamp, utc_timestamp);


insert into forma_pagamento (descricao)values('Cartão de Crédito');
insert into forma_pagamento (descricao)values('Cartão de Débito');
insert into forma_pagamento (descricao)values('Dinheiro');
insert into forma_pagamento (descricao)values('PIX');

insert into permissao (nome, descricao)values('ConsultarPedido', 'Consulta Pedidos de clientes');
insert into permissao (nome, descricao)values('ConfirmarPedido', 'Aceita pedido realizado pelo cliente');
insert into permissao (nome, descricao)values('EntregaPedido', 'Confirma a retirada do pedido no balcão e finaliza Entrega.');


insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id)values (1,1), (1,2), (1,3), (1,4), (2,1), (2,2), (3, 1);