# spring-kafka-api

Projeto de microsserviços usando Spring Boot 3.x, Kafka, JPA, PostgreSQL e JasperReports

# Requisitos para rodar o projeto
https://www.oracle.com/java/technologies/downloads/

Necessário  baixar o SDK e editar as variáveis de ambiente do sistema
Colocar o caminho do JDK na pasta Ex.: 'JAVA_HOME' - 'C:\Program Files\Java\jdk-21'
Adicionar mais uma variável no path '%JAVA_HOME%\bin'

'java -version' para verificar se está tudo certo, caso não apareça a versão reeinicie o computador

https://community.jaspersoft.com/download-jaspersoft/community-edition/

https://www.docker.com/products/docker-desktop/
# Imagem do Postgres para o Docker
https://hub.docker.com/_/postgres
Caso o Docker de problema necessário acessar 'Ativa ou Dasativar recursos do Windows' e habilitar ho Hyper V
Habilitar Virtualização na BIOS


# Dependências necessárias para o projeto
https://start.spring.io/

Spring WEB
JPA
Lombok
Postgre ou outro banco de dados

# usar para criar imagem dentro do Docker, usar na pasta database do prejeto servicos usando 'cd servicos/database/'
docker compose up -d

# para ver os containers rodando
docker ps

# Usar para realizar conexão sincrona com outros microsserviços
https://spring.io/projects/spring-cloud-openfeign

# Adicionar dependência no pom.xml

# Está disponivel apensa para Spring Boot 3.4.x

# Adicionar Apache Kafka no projeto 

Será necessário três imagens para rodar o Kafka no Docker

1 - Zookeeper - Para gerenciamento do Broker
https://hub.docker.com/r/confluentinc/cp-zookeeper

2 - Kafka Broker - Responsável por gerenciar as mensagens
https://hub.docker.com/r/confluentinc/cp-kafka

3 - Kafka UI - Interface web para monitoramento do Kafka
https://hub.docker.com/r/provectuslabs/kafka-ui

# Usar na pasta database do prejeto servicos usando 'cd servicos/kafka/'
docker compose up -d

Caso necessário alterar as portas, editar o arquivo compose.yaml

Usar 'docker compose down' para parar os containers

# Documentação do Confluent Kafka
https://docs.confluent.io/platform/current/installation/docker/config-reference.html#confluent-ak-configuration


docker pull confluentinc/cp-kafka:7.9.5

# Documentação do Spring Kafka
https://spring.io/projects/spring-kafka

netstat -ano | findstr "8050"

