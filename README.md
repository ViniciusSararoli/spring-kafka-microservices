# spring-kafka-api

Financial control system to help people organize their money

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
<!-- <spring-cloud.version>2022.0.4</spring-cloud.version> -->
# Está disponivel apensa para Spring Boot 3.4.x

