## Padrões GRASP 

- Information Expert (Perito em Informação): O princípio do Information Expert sugere que a responsabilidade deve ser atribuída à classe que possui as informações necessárias para cumprir a tarefa. No código, a classe `Task` é responsável por armazenar informações sobre uma tarefa, como seu ID e descrição, o que está alinhado com esse princípio. A classe `TaskManager` utiliza informações da classe `Task` para executar operações CRUD.

- Low Coupling (Baixo Acoplamento): O código mantém um baixo acoplamento entre as classes. A classe `TaskManager` interage com a interface `TaskFactory`, que é uma maneira de criar objetos `Task`, sem depender da implementação concreta da fábrica. Isso mantém as classes independentes e flexíveis para futuras extensões ou mudanças.

## Padrões GOF 

- Factory Method (Método de Fábrica): O padrão Factory Method é aplicado por meio da interface `TaskFactory` e sua implementação `ConcreteTaskFactory`. A interface `TaskFactory` define um método `createTask`, que as classes concretas implementam para criar instâncias da classe `Task`. Isso permite criar objetos `Task` sem especificar sua classe concreta, promovendo a flexibilidade e o desacoplamento.



