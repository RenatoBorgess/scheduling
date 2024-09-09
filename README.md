# Servico de agendamento com Spring Boot

Esta api contem dois endpoints. 

```
GET api/scheduling
```
Este endpoint retorna uma lista de transferencias agendadas.
```
POST api/scheduling
```
Este endpoint recebe um objeto do tipo ScheduleRequest e retorna
um objeto ScheduleResponse

Este projeto implementa o padrao de projeto Strategy para calcular as taxas de 
transferencia de acordo com a diferenca entra a data de agendamento e a data da transferencia. 

Para rodar o projeto:

Clone o projeto e use o comando 
```
mvn spring-boot:run
```
Se preferir, utilize uma ide e rode a classe SchedulingApplication
