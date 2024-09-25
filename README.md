
# Good Food

GoodFood é uma aplicação que provê um software de gerenciamento para uma lanchonete em expansão.

[![Java CI with Maven](https://github.com/carlosbridi/goodfood-postech/actions/workflows/maven.yml/badge.svg)](https://github.com/carlosbridi/goodfood-postech/actions/workflows/maven.yml)

# Desafio

As descrições dos desafios de cada fase estão na pasta /doc/tech-challenge.
As resoluções por fase estão nas tags do git fase1-*, fase2-*, etc.


# DDD

O DDD do projeto está disponibilizado no [Miro](https://miro.com/app/board/uXjVKTxXwGc=/?share_link_id=520536120828) ou na pasta /doc/ddd (baixa qualidade).


# Arquitetura Clean Architecture

![clean-arch](/doc/clean-architecture.jpg?raw=true)
- **Enterprise Business Rules**:
  - package `com.good.food.domain`
- **Application Business Rules**:
  - package `com.good.food.application`
- **Interface Adapters**:
  - package `com.good.food.adapter`
- **Frameworks & Drivers**:
  - package `com.good.food.driver`
  - PostgresSQL
  - Spring MVC

*Evitou-se o uso de frameworks nas camadas internas, como pro exemplo o Spring beans, para obter uma implementação mais pura da proposta da arquitetura.*

# Desenho da arquitetura
Desenho da arquitetura de infra utilizando o kubernetes
![Desenho da arquitetura](./doc/desenho_arquitetura.png?raw=true)


# Tecnologias

Tecnologias utilizadas
- Java;
- Springboot;
- Maven;
- Banco de dados:
- PostegreSQL 16


# Build
O projeto poderá ser empacotado e "buildado" através do arquivo [Dockerfile](https://github.com/carlosbridi/goodfood-postech/blob/main/Dockefile).

# Rodando o projeto

O repositório Git contém um arquivo [docker-compose.yml](https://github.com/carlosbridi/goodfood-postech/blob/main/docker-compose.yml), copie esse arquivo para um diretório local, certifique-se que contém o [Docker Compose](https://docs.docker.com/compose/install/) instalado.

Rodar o comando `docker-compose up -d`, assim que o download das imagens do banco e da aplicação forem finalizadas, o projeto estará rodando na porta 8080, sendo possível acessar o swagger atrás do link: http://localhost:8080/swagger-ui/index.html.

# Kubernetes 

Arquivos do K8S está na pasta "k8s".
 * **HPA** - hpa-goodfood-postech.yaml
 * **Deployment** - pod-goodfood-postech.yaml
 * **SVC Cluster IP DB** - svc-cluster-ip-postgres.yaml
 * **SVC DB** - svc-postgres.yaml
 * **LoadBalancer** - svc-goodfood-postech-loadbalancer.yaml
 
Para executar o projeto em um cluster, basta executar todos os arquivos acima com o comando `kubectl apply -f .`, obter o IP a partir do `kubectl get svc` e acessar a URL `http:\\<ip>/swagger-ui/index.html`

# Testes
Para rodar os testes, basta rodar o comando `mvn test` na raiz do projeto.
Atualmente os testes apenas validam as dependências entre os pacotes, garantindo a correta implementação da arquitetura clean architecture.

# Endpoints
Documentação no swagger: http://localhost:8080/swagger-ui/index.html (necessário rodar o projeto para acessar)

# Banco de dados
O banco de dados utilizado é o PostgreSQL, com a seguinte configuração:

![img.png](./doc/MER do banco.png?raw=true)

Optamos por utilizar o PostgreSQL por ser um banco de dados open source e ter uma comunidade ativa. Além disso, o PostgreSQL é um banco de dados relacional, o que facilita a modelagem de dados e a garantia da integridade referencial. O PostgreSQL também, caso necessário, é fácil de migrar para outro banco relacional e é altamente customizável.

Para o tech challenge 3, como melhoria para o nosso banco, foi removida a tabela de clientes/usuários do PostgreSQL e movemos para o AWS Cognito. Além disso, também adicionamos um banco Redis para guardar o cache da tabela produto. A escolha do Redis se deve ao seu desempenho na seleção de dados e à fácil escalabilidade, junto com a simplicidade da API em si, que permite a integração com várias outras linguagens e frameworks.
# Equipe
Carlos Bridi - RM355971  
Nicollas P. Eissmann - RM355576  
Daniel R. Martini - RM355054  
Roberto Debarba - RM355038  

