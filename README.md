# Arquitetura de aplicativo

O aplicativo Market Search Api é construído em Clean Architecture e MVVM, que mostra listas de
personagens, episodios e localização.
O aplicativo consome [Market Search Api](https://api.mercadolibre.com/sites/$SITE_ID/search?q=Motorola%20G6)

# Arquitetura de aplicativo

### Camada de dados:
A camada de dados inclui dados do aplicativo e lógica de negócios. A camada de dados contém APIs,
repositórios, e mappers.

### Camada de domínio:
A camada de domínio é responsável por manipular a lógica de negócios e fica entre as camadas
de Ui e de dados. A camada de domínio inclui casos de uso e entidades.

### Camada de Ui/Presentation:
A camada de Ui exibe dados do aplicativo na tela e deixa a Ui pronta para interagir com os usuários.
Ela contém estado relacionado à IU e lógica de Ui. A camada de Ui inclui viewmodels, fragmentos,
atividades, componentes.

## Importância do mapeamento de dados entre camadas
No aplicativo, cada camada tem um modelo de dados próprio, e os dados são mapeados entre camadas
para cada modelo de camada. Usar modelos diferentes por camada é perfeito para uma abordagem de
arquitetura limpa. Se o aplicativo se limitar a apenas um modelo e algumas situações como
modificações no banco de dados, adicionar APIs RESTful à fonte de dados ou precisar de um modelo
utilizável para Ui, o aplicativo precisa atualizar todos os modelos. Usar modelos por camada é uma
ótima chave para criar software escalável e sustentável.

[Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Componentes com reconhecimento de ciclo de vida realizam ações em resposta 
a uma alteração no status do ciclo de vida de outro componente, como atividades e fragmentos. 
Esses componentes ajudam a produzir um código mais bem organizado e, geralmente, mais leve, 
que é mais fácil de manter.

[Flow](https://developer.android.com/kotlin/flow) - Flow é um tipo que pode emitir vários valores sequencialmente, em oposição a 
funções de suspensão que retornam apenas um único valor. Por exemplo, você pode usar um fluxo 
para receber atualizações ao vivo de um banco de dados.

[Retrofit](https://square.github.io/retrofit) - É uma biblioteca de rede simples usada para transações de rede. Ao usar esta 
biblioteca, podemos capturar perfeitamente a resposta JSON do serviço da web/API da web.