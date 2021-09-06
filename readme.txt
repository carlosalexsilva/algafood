CURSO DE ESPECIALISTA SPRING REST.
INICIO: 20/08/2021

Diagrama do modelo proposto
https://assets.algaworks.com/portal/content/especialista-spring-rest/images/diagrama-de-classes-de-dominio.jpg

- Java 12 (OpenJDK) openjdk.java.net para baixar.
- scripts-up-to-java17ea.zip utilizado para trocar a versao do java facilmente pelo cmd
--- Descompactar o arquivo zip no diretório C:\Program Files\Java\scripts
--- Incluir esse diretório no Path Windows (Edit environment variable)


-- Spring Boot não é um gerador de código, mas sim um gerenciador opinativo de configurações para utilizar os projetos do ecosistema Spring.
- JavaEE é baseado em especificações, não é o produto final, é a padronização de uma tecnologia.
-- Jpa é uma especificação baseada na implementação do Hibernete, sendo incorporado ao JavaEE.
-- Existem varias especificações dentro do JAVAEE.
-- Portabilidade, padronização e estabilidade são os pontos fortes do JAVA EE.

- SPRING - é uma plataforma inovadora.
-- SpringBoot é uma camada de abstração para simplificar o desenvolvimento de aplicações usando Spring.

-MAVEN
-- Ao rodar o maven, no goals 
	= package -> significa que ele vai empacotar o projeto.
	= clean -> limpa todos os arquivos do diretorio target que fica os compilados.
-- arquivo mvnw.cmd é utilizado para executar o maven, mesmo não tendo o maven instalado.
-- entrar no diretorio da api, e digitar no cmd: ./mvnw package (faz a mesma coisa que o run do eclipse)


-- Spring MVC é um projeto para desenvolver para WEB, controladores webs que recebem requisições http e que devolvem informações, tipo rest.

Algumas anotações
@Controller -> indica que a pagina irá trabalhar com requisições web.(incluida antes da classe)
@GetMapping("/hello") indica que se for uma chamada get no /hello irá chamar esse método.
@ResponseBody-> indica que o retorno da função vai no corpo.

@Component, defini para o spring que a Classe é um Bean e pode ser usado pelo Spring, @controller também é uma especie de Component.
@SpringBootApplication é a anotação que inicia todo o projeto spring, dentro dessa anotação ela utiliza a anotação @ComponentScan que varre nosso
projeto pra identificar todos os componentes que serão gerenciados pelo Spring.

@Configuration, indica que a classe é especifica para configurar inicializações de Beans que precisam de alguns parametros iniciais para serem
instanciadas. Assim a aplicação ao subir, passa pela classe e Inicia os beans com os parametros definidos, exemplo NotificadorEmail que já carrega 
o smtp que será utilizado.

@Autowired, notação defini um Construtor ou um método ou um atributo da Classe para ser a execução default na instanciação da Classe.
 -- Exemplo, quando classe AtivacaoClienteService é instanciada ela precisa saber qual notificador irá usar, por padrão o Construtor já esta recebendo
    o notificador, porém, se tivermos 2 construtores o Spring não sabe qual usar e assim utilizando o @Autowired dizemos pra ele qual deve ser 
    executado por default. Podemos definir como default também um metodo setter, tipo setNotificador com @Autowired o spring sabe que precisa 
    instanciar o notificador também, ou até mesmo definir o atributo notificar com o @Autowired.
    - O ideal é instanciar por default o Construtor.
@Autowired(required=false) indica que a injeção que esta sendo definida como default é opcional, não sendo preciso ser instanciada.

============COMECEI ANOTAR NA BRANCH AS DESCRIÇÕES DAS ANOTAÇÕES.
@Qualifier("email") identificação para qualificar nosso componente, passamos o email como nome do component, mas o ideal é usar algo que indica a relação com a utilização tipo urgente => sms, normal => email

-- Dica para reiniciar a aplicação mais rapidamente
Adicionar o dev tools em botão direito no projeto e Add Dev Tools. (usado somente durante o desenvolvimento)
Ele não reinicia a aplicação toda, mas sim alguns classloader necessários para identificar as modificações.

-- Injeção de Dependências
--- é quando vc define que um serviço (classe) depende de uma Interface que é informada no parametro do construtor.
----- Essa dependencia é para que todas as atividades da outra classe no caso notificar fique alheia a classe ativarClienteService, 
	e os tipos de notificações fique por conta dela.
---- CLASSES -> NotificarSMS, NotificarEmail
---- INTERFACE -> Notificar, o método notificar recebe por polimorfismo tanto NotificarSMS ou NotificarEmail
---- CLASSES -> AtivarClienteService... 
  ======> exemplo prático em java puro no projeto exemplo-di
-- IoC, inversion order contract. Contrato de inversão de ordem.
--- Usar injeção define baixo acoplamento
-- Spring IoC Container -> responsavel por fazer toda mágica da injeção de dependencias no Spring.
-- É necessário definir um Bean para injeta-lo em outro Bean ou Classe.
-- Uma das formas de injetar dependencia no spring é criar um construtor na classe e passar para ele o outro Objeto Bean.
	private NotificadorEmail notificador;	
	public AtivacaoClienteService(NotificadorEmail notificador) {
		this.notificador = notificador;
		
		System.out.println("AtivacaoClienteService:" + notificador);
	}

-- Criar uma interface apartir de uma classe
--- Clicar botão direito => Refactor => Extract Interface, seleciona metodos e da nome a Interface.

--- Sempre pensar em diminuir o Acoplamento.
--- Usar interfaces somente quando necessário, não precisa sair criando interface em todo lugar, sempre analisar caso a caso.

Comando para substituir propriedade padrao definida no arquivo .properties pela linha de comando
	java -jar algafood-api-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev

Comando para substituir propriedade padrao definida no arquivo .properties por variavel de ambiente.
	set SPRING_PROFILES_ACTIVE=dev
	

======== PERSISTENCIA DE DADOS =============

ORM - Object Relational Mapping - é uma técnica para mapeamento de classes de um objeto para tabela de um banco de dados
 - Você defini através de notações JPA na Classe (Entity) o nome da tabela @Table, o nome do atributo @Column com a coluna da tabela.

JPA - Java Persistence API, é uma especificação JEE não é um produto, especificação descreve como algo deve funcionar, não é o produto final.
Hibernate - é uma implementação da especificação JPA, ou seja ele implementa a solução de acordo com a descrição/especificação.
EclipseLink também é uma implementação de JPA.

Senha mysql local: liv150281

StarUML - utilizado para criar diagrama de classes.

============ DDD ================
 DDD é uma abordagem de desenvolvimento de software que nos ajuda a criar softare de alta qualidade com foco no dominio, ou seja foco no negócio.
 -- Aggregate é um grupo de objetos de dominio que podem ser tratados como unica unidade.
 -- Cada Aggregate possui somente um AggregateRoot
 -- Se um objeto externo fizer referencia a um Aggregate é recomendado que este faça referencia a classe AggregateRoot.
 para mais informações ler  =>> https://martinfowler.com/bliki/DDD_Aggregate.html 

 -- O PADRÃO PARA CRIAÇÃO DE REPOSITÓRIO É CRIAR UM REPOSITORIO POR AGGREGATEROOT E NÃO UM REPOSITORY POR ENTITY.
 ---- Exemplo tenho Pedido e ItemPedido, vou criar um PedidoRepository que irá tratar as duas entities. 
 
 
 =========== O QUE É REST ===========
 Representational State Transfer => é um estilo arquitetural para desenvolvimento de web services.
 Melhores práticas são chamadas de Constrants.
 
 Por que REST?
 - Separação entre cliente e servidor
 - Escalabilidade
 - Independente de linguagem
 - Mercado, demanda
 
 ==> CONSTRAINTS DO REST
 - Cliente-Servidor, precisa de um cliente consumidor para um servidor que evoluem totalmente independente
 - Stateless, aplicação não pode ter estado, na requisição tudo tem que ser enviado para que a Api consiga processar seus dados, cada requisição é única.
 - Cache, a api pode fazer caching das respostas das requisições, exemplo uma lista de cidades que nao fica alterado, uma vez consultado pode ficar em cache a resposta no cliente.
		quando o cliente fazer uma nova requisição o cliente já sabe que tem no cache a lista de cidades.
 - Interface uniforme, um conjunto de operações bem definidas no sistema. Devemos identificar coisas do sistema usando URI. Resumindo, a api deve ser desenvolvida usando os verbos
		http corretamente de forma que a interface funcione como um contrato onde o cliente e servidor possam se comunicar de forma mais previsivel.
 - Sistema e camadas, diz que entre o cliente e o servidor podem existir outras camadas como caching, balanceamento de cargas e etc. o cliente não sabe quantdas camadas tem até checar no server.
 - Código sob demanada, o servidor poderia retornar um script que pdoeria ser executado no cliente, tipo um código javascript enviado pelo server para ser executado pelo cliente.
 
 Diferença entre REST vs RESTful
 A diferença entre os dois termos é conceitual, REST é o estilo arquitetural que possui as constraints ou seja a especificação. 
 RestFul é uma API desenvolvida em conformidade com as constrainsts, ou seja são desenvolvidas religiosamente seguindos as conformidades das constraints.
 Se a API sofreu alguma quebra das constrains não deve ser considerada uma RestFul API.
 
 Dev Puristas vs Pragmáticos
 - Puristas são os dev que defendem todas as constrainst da RestFul e não abrem mao disso, tem que ser do jeito descrito
 - Pragmáticos são devs que dependendo da situação abrem mão de alguma regra de especificação se no entendimento dele não faz sentido e pode ser prático fazer de outra forma.
 
 ==> PROTOCOLO HTTP
 
 ==> Usando o protocolo HTTP
 - telnet usado para testar uma conexão
   telnet www.uol.com.br 80
   
 - Verbo PATCH é utilizado para atualizar um recurso no banco parcialmente, só incluimos os campos que queremos atualizar, no PUT se eu não colocar todos os campos eles ficam NULL.
 
 - modelo de requisição HTTP
	POST /cozinhas HTTP/1.1 => ONDE : POST(verbo, acao executada), /cozinhas => URI, 1.1 => VERSAO DO HTTP.
	Content-Type: application/json => ONDE: content-type é o tipo de conteudo que esta sendo enviado.
	{
		"nome": "Brasileira"  => este conteudo  é o payload (corpo com os atributos que serão enviados ao servidor)
	}
 
- gnutls, aplicativo tipo telnet que é usado para fazer testes de conexoes http. gnutls.org

==> RECURSOS DO REST
- Recurso é qualquer coisa exposto na internet, uma imagem, um catalogo de produto, um unico produto, uma nota fiscal, pagamento.
- SingletonResource, ou recurso único...
- CollectionResource, ou recurso de coleções, vários resources fazem parte daquela coleção.

-- IDENTIFICANDO UM RECURSO
- URI -> Uniform Resource Identifier, da um endereço para um recurso
- URL é um tipo de URI
-- /listarProdutos  é uma CollectionResource, a url completa seria https://api.algamarket.com.br/produtos, mas não é uma boa prática identificar um recurso dessa forma.
-- O ideal seria identificar não como listarProdutos mas sim como produtos.
-- /produto/{codigo} é uma SingletonResource, a url completa poderia ser https://api.algamarket.com.br/produto/331
-- O ideal é sempre usar o nome do recurso no plural, mesmo que seja um recurso unico o correto é https://api.algamarket.com.br/produtos/331

==> Representações de recursos e content negotiation
- Negociação de conteudo é referenciado no header com o valor Accept, pois o cliente indica para o servidor o tipo de resposta que ele espera, exemplo application-json.
  Se o servidor estiver preparado para retornar json ele responde com json, mas se o cliente solicita um tipo diferente do que o servidor esta configurado, então é melhor
  o servidor retornar um erro para indicar essa divergencia, isso se chama Negociação de Conteúdo.
- É sempre necessário pensar no tipo de cliente que vai usar os recursos da APi para com base nisso saber os tipos de retornos que devem ser permitidos no servidor,
  normalmente json resolve.. mas pode ter outros tipo exemplo xml, jpg.
  
==> Implementando content negotiation para retornar JSON ou XML
- O SpringBoot por padrão já configura para a resposta padrão ser por json ou seja Application/json
- Se a requisição solicitar uma resposta em um tipo que não é permitido pelo servidor por padrão o status 406 Not Acceptable é retornado. 
- Dependencia abaixo permite que o xml seja suportado como retorno do servidor.
<dependency>
	<groupId>com.fasterxml.jackson.dataformat</groupId>
	<artifactId>jackson-dataformat-xml</artifactId>
</dependency>

 
 Status HTTP para collection resource vazia: qual usar?
 - Uma boa prática é manter o status 200 quando a lista não tiver conteudo, pois por mais que não tenha registro houve um conteudo uma lista, mesmo que vazia.
 
- DOMAIN SERVICE
-- É uma operação sem estado que realiza uma tarefa especifica do dominio, ou seja uma tarefa do negócio.
-- O ídeal é que métodos que alteram dados na base, sejam criados em uma camada de domain(negocios), os métodos delistar podem apartir do controller chamar o repositório
-- porém para os métodos que alteram dados, o ideal é ter outra camada de negocio para acessar o repositório.
-- Sempre que for criar uma classe de negócio, precisamos pensar como as pessoas falam os termos de negócio para usar isso nos códigos, exemplo, eles falam gastronomia ou cozinha?
-- Isso é conhecido como linguagem ubíqua, ou seja os códigos são referenciados pelo que o cliente usa no dia a dia, se fosse gastronomia diriamos CadastroGastronomiaService, 
-- mas no nosso exemplo eles fala cozinha, então a classe seria CadastroCozinhaService

- API de Reflections do Spring: é a capacidade que a gente tem de inspecionar objetos JAVA em tempo de execução e até alterar esses objetos chamando métodos, 
	alterando valores de atributos, tudo isso em tempo de execução quando a gente não sabe o nome dos atributos e quer fazer algo mais genérico, isso é REFLECTION.

==> Introdução ao Modelo de Maturidade de Richardson (RMM)
-- Richardson criou esses 4 niveis abaixo e para ser considerada RestAPI na teoria a aplicação deveria estar no nivel 3.
-- Mas existem vários programadores que trabalham até o nível 2 e consideram que suas aplicações são REST.
-- Abaixo do nível 2 não se pode considerar que é REST.
- Nivel 0: POX - Plain Old XML
	- Nesse nível não é considerado REST e ela serve mais para utilização do protocolo HTTP para envio das requisições e tanto faz se é GET, POST ou outro verbo.
	- Pois o que manda dizer o comando é a tag xml exemplo <cadastrarProduto><nome>Sabão</nome></cadastrarProduto>, ou até mesmo json é utilizado.
	- Só existe um EndPoint que sempre é chamado na requisição e seu status de retorno sempre será 200 se sucesso, independente se é para adicionar, deletar ou atualizar algo.
- Nivel 1: Recursos
	- É muito semelhante com o Nível 0, pois ainda não controla corretamente os verbos e status de resposta para gerenciar a funcionalidade que será processada.
	- Nesse nível já é possível utilizar mais que um EndPoint para fazer requisições podesse usar /produtos, /produtos/12, mas ainda não se controla os verbos, ou seja as
	  duas uris podem ser chamadas pelo metodo GET ou POST.
	- O que continua indicando qual é a funcionalidade é as tags do corpo da requisição
- Nivel 2: Verbos HTTP (No ESR, estamos aqui nesse momento)
	- Introduz a utilização dos verbos HTTPs de acordo com sua semantica (funcionalidade)
	- O corpo (payload) já não indica mais a funcionalidade, mas sim é um objeto indicando os valores exemplo <produto><nome>Sabao</nome</produto>
	- Os status de retorno já são utilizados de acordo com suas necessidades, 201 - Created, 404 - Not Found entre outros.
	- Roy Field diz que isso ainda não é REST, mas a maioria do mercado já assume que isso é uma RESTAPI.
- Nivel 3: HATEOAS (Hypertext As The Engine Of Application State)
	- Links entre as páginas é considerado HyperMedia, html é HyperMedia
	- A ideia de Hateoas é justamente ajudar os consumidores da API descobrir as funcionalidades e o fluxo de navegação.
	- A API gerencia as regras de negócio para apresentação dos links, exemplo, em uma resposta do produto poderiamos ter o link para comprar, porém se não tem mais estoque
	  - esse link comprar não precisaria ser enviado na resposta, assim o CLIENTE/FRONT nao precisa se preocupar com essas regras de negócio.
	- É possível enviar nos links também o VERBO que o link será requisitado, porém se não informar, como no exemplo abaixo, o cliente/front que precisa saber qual verbo usar.
	- Atualmente a maioria da Apis estão no nível 2.
	- Exemplo de resposta com links que poderiam direcionar as próximas ações.
		{
			"id": 73,
			"nome": "MAcbook Pro 13",
			"preco": 15000,
			"links": {
				"inativar": "/pagamentos/73",
				"fornecedor": "/fornecedores/34"
			}
		}
		
 ==> Conhecendo o projeto Spring Data JPA (SDJ)
 - Repositorio genério é uma classe onde se define métodos comuns como salvar, deletar, atualizar, listar etc.
 - Spring Data JPA é um subprojeto do Spring Data, utilizado para criar os códigos borderplate acima.
 - Acabamos tendo apenas uma interface para cada repositorio sem classe implementando ela, por queo Spring Data JPA implementa elas.

 -KeyWords para usar na nomenclatura dos métodos
 - findTodasByNomeContaining => Containing é usado como like  
 - link para todas as keywords: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 - existe prefixos padrões que vão fazer o jpa interpretar corretamente o metodo
	- find, query, get, read.=> todos são a mesma coisa
	- findFirst => irá trazer o primeiro registro encontrado.
	
==> Conhecendo o uso do padrão Specifications (DDD) com SDJ	
- Specifications faz parte do DDD e o Spring Data JPA implementou. Ele encapsula uma restrição ou seja um filtro e pode ser combinado com outras specifications e assim
- forma uma relação de restrições.
- Criasse uma classe para cada condição, no caso exemplo var comFreteGratis = RestauranteComFreteGratisSpec, var comNomeSemelhante = RestauranteComNomeSemelhanteSpec e depois faz uma junção dessas classes para formar
- o where  restauranteRepository.findAll(comFreteGratis.and(comNomeSemelhante));
 
==> Definindo um pacote e classe com métodos estaticos, isso para que o eclipse já importe o método estatico para dentro da classe que esta usando o mesmo.
- No eclipse, menu Window -> Preferences -> Java -> Editor -> Content Assist -> Favorites -> New Type e insere o pacote com o nome da classe com métodos estaticos.
 -- com.algaworks.algafood.infrastructure.repository.spec.RestauranteSpecs

==> Ferramenta para gerar diagramas de Entidade-Relacionamento (DER)
genmymodel.com

