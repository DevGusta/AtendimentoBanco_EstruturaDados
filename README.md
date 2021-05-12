Descrição
O Banco “Dinheiro da Mão” tem apenas um caixa para atendimento aos clientes. Cada cliente que
chega para ser atendido pode ser idoso (idade igual ou superior a 60 anos) ou não.
Você foi contratado para desenvolver um sistema que irá coordenar o atendimento dos clientes
do banco.
Com o objetivo de atender os clientes considerando a legislação, o programa deverá alternar a
chamada de atendimento entre os idosos e os não-idosos, priorizando os idosos. Ao chegar um
idoso, o atendimento deste idoso deve ser priorizado. A cada dois atendimentos de idosos, um não
idoso poderá ser atendido. No momento que um idoso deveria ser chamado, caso não tenha idoso,
um não-idoso deverá ser chamado, e vice-versa.

Construção
Classe Client
-atributos name e age.
-validação: Cliente precisa ter nome com pelo menos 5 caracteres, não brancos (“ “). Além disso, a
idade mínima deve ser 16 anos. Caso a idade do cliente seja inválida (valores menores que 16)
considere que a idade será 18 anos.
-métodos:
getName( ); //retorna o nome ( name ) do cliente
getAge( ); //retorna a idade ( age ) do cliente
isElderly() ; //retorna true se a pessoa for idosa ( >= 60 anos ).
Classe ManageAttendance, que deve fornecer os seguintes métodos públicos:
ManageAttendance ( int size ); // inicia nova instância com o tamanho máximo das filas
boolean isEmpty() ; // retorna true quando não há clientes para atendimento
int numClients( ); // retorna o número de clientes aguardando atendimento
int numElderlyClients( ); // retorna o número de clientes idosos aguardando atendimento
void addClient( Client cli ); // insere um novo cliente na fila de atendimento
Client showNext( ); // retorna o próximo cliente a ser atendido, mas NÃO remove o cliente
Client getNext( ); // retorna o próximo cliente para ser atendido e remove da fila
String showQueues( ); // retorna uma string contendo os nomes de todos os clientes que estão
aguardando atendimento. O formato da string deve ser como o exemplo a seguir,
separados por hífen e sem nenhum espaço(sem hífen no final):
idoso:nome1:idade1-nome2:idade2-nome3:idade3; normal: nome4:idade4-nome5:idade5
quando a fila estiver vazia, exiba a palavra vazia como no exemplo:
idoso:vazia;normal:nome1:idade1-nome2:idade2-nome3:idade3
Implemento o seguinte menu de opções para o programa (classe App / main):
1 – Chegada do cliente na agência
2 – Verificar quem é o próximo a ser atendido
3 – Atender um cliente (ao atender o cliente, o nome e a idade dele deve ser apresentada)
4 – Exibir as filas (idoso e não idoso)
5 – Finalizar o programa (que só poderá ser finalizado caso não tenha mais clientes aguardando)
O programa somente pode encerrar com a opção 5 do menu. Para qualquer valor digitado que não
esteja no menu deve aparecer uma mensagem informando que aquela opção é inválida.
O programa deve fornecer mensagens apropriadas para o usuário de acordo com a operação
solicitada. Por exemplo: “A fila está cheia, novo cliente não foi inserido”, “Cliente X foi atendido”,
“Não pode terminar enquanto há clientes para atender”, etc.
