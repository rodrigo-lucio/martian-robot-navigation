# Desafio de exploração dos Robôs em Marte 🚀

## O Problema 📚
- Um time de robôs devem ser colocados pela NASA para explorar um terreno em Marte 🔴. 
- Esse terreno, que é retangular, precisa ser navegado pelos robôs de tal forma que suas câmeras acopladas possam obter uma visão completa da região, enviando essas imagens novamente para a Terra.
- A posição de cada robô é representada pela combinação de coordenadas cartesianas (x, y) e por uma letra, que pode representar uma das quatro orientações: NORTH, SOUTH, EAST e WEST. 
- Para simplificar a navegação, a região "marciana" a ser explorada foi subdividida em sub-regiões retangulares.
- Uma posição válida de um robô, seria (0, 0, N), que significa que o robô está posicionado no canto esquerdo inferior do terreno, voltado para o Norte.
- Para controlar cada robô, a NASA envia uma string simples, que pode conter as letras ‘L’, ‘R’ e ‘M’. As letras ‘L’ e ‘R’ fazem o robô rotacionar em seu próprio eixo 90 graus para esquerda ou para direita, respectivamente, sem se mover da sua posição atual. A letra ‘M’ faz o robô deslocar-se uma posição para frente.
- Assume-se que um robô se movimenta para o NORTE em relação ao eixo y. Ou seja, um passo para o NORTE da posição (x,y), é a posição (x, y+1).

## Stack 🚀

O desafio foi desenvolvido utilizando as seguintes tecnologias:
- Java 17
- [Spring Boot](https://spring.io/projects/spring-boot)
- [MockMvn](https://docs.spring.io/spring-framework/reference/testing/spring-mvc-test-framework.html) e [JUnit5](https://junit.org/junit5/) para testes unitários.
- [Docker](https://www.docker.com/get-started)
Foram criados testes unitários para todas as camadas da aplicação.

## Para rodar o projeto:
## Via docker 🐋
1. Verifique se o Docker está instalado e funcionando no seu computador, pode ser via WSL ou Docker desktop.
2.  Execute o seguinte comando:
   ```bash
   docker run -p 8080:8080 rodrigolucio/mars-robot-manager
   ```
3. O projeto estará rodando com sucesso na porta em [http://localhost:8080](http://localhost:8080), e aguardando para receber as requisições.

## Via sua IDE de preferência 💻
1. Verifique se o JDK 17 está instalado e funcionando corretamente em seu computador.
2. Importe o projeto na sua IDE
3. Execute a aplicação na [classe main](https://github.com/rodrigo-lucio/martian-robot-navigation/blob/main/src/main/java/br/com/contazul/martianrobotnavigation/MartianRobotNavigationApplication.java).

## Documentação 📑

### 1. Movimento do robô com rotação para direita:
- **Requisição**:
   ```bash
   curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM
   ```
- **Resposta**:
  ```json
  {
      "robotId": "2b8b4ce5-90e2-41ca-a002-eb52a4a9f7a9",
      "positionX": 2,
      "positionY": 0,
      "direction": "S"
  } 
### 2. Movimento do robô com rotação para esquerda:
- **Requisição**:
   ```bash
   curl -s --request POST http://localhost:8080/rest/mars/MML
   ```
- **Resposta**:
  ```json
  {
      "robotId": "2b8b4ce5-90e2-41ca-a002-eb52a4a9f7a9",
      "positionX": 2,
      "positionY": 0,
      "direction": "W"
  }
### 3. Repetição da requisição com movimento para esquerda:
- **Requisição**:
   ```bash
   curl -s --request POST http://localhost:8080/rest/mars/MML
   ```
- **Resposta**:
  ```json
  {
      "robotId": "2b8b4ce5-90e2-41ca-a002-eb52a4a9f7a9",
      "positionX": 2,
      "positionY": 0,
      "direction": "W"
  }
### 4. Comando inválido:
- **Requisição**:
   ```bash
   curl -s --request POST http://localhost:8080/rest/mars/MML
   ```
- **Resposta**:
  ```json
  {
      "status": 400,
      "reason": "Bad Request",
      "message": "Invalid command: A. Valid commands are: L, R, M",
      "timestamp": "2024-06-03T21:45:26.4337044"
  }
### 5. Posição inválida:
- **Requisição**:
   ```bash
   curl -s --request POST http://localhost:8080/rest/mars/MML
   ```
- **Resposta**:
  ```json
  {
      "status": 400,
      "reason": "Bad Request",
      "message": "The robot cannot leave the exploration area",
      "timestamp": "2024-06-03T21:46:03.9115173"
  }

## Testes de integração
Foram criados testes de integração utilizando o Postman. A collection foi exportada e encontra-se [aqui](https://github.com/rodrigo-lucio/martian-robot-navigation/blob/main/Mars%20Robot%20Navigation%20-%20Conta%20Azul.postman_collection.json). Basta apenas importar o arquivo, clicar em Run collection e os testes já serão executados.
