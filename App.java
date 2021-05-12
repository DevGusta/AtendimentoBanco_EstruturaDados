import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean toContinue = true;
        int option;

        System.out.println("Bem vindo! Digite o tamanho máximo da fila da sua agência:");
        ManageAttendance bank = new ManageAttendance(keyboard.nextInt());
        System.out.println();


        while (toContinue){
            System.out.println("1 - Chegada do cliente na agência");
            System.out.println("2 - Verificar quem é o próximo a ser atendido");
            System.out.println("3 - Atender um cliente");
            System.out.println("4 - Exibir as filas");
            System.out.println("5 - Finalizar o programa");
            System.out.print("Escolha uma opção: ");
            option = keyboard.nextInt();
            System.out.println();
            switch (option){
                case 1:
                    String name = "";
                    int age = 0;
                    boolean validation = true;
                    while (validation){
                        System.out.print("Digite o nome do cliente: ");
                        name = keyboard.next();
                        if (name.length() < 5){
                            System.out.println("O nome do cliente precisa ter pelo menos 5 caracteres");
                            System.out.println();
                            continue;
                        }

                        System.out.print("Digite a idade do cliente(mínimo de 16 anos): ");
                        age = keyboard.nextInt();

                        if (age < 16){
                            age = 18;
                            System.out.println("Idade digitada foi inválida. Será considerado 18 anos");
                            System.out.println();
                        }
                        validation = false;
                    }
                    bank.addClient(name,age);

                    break;
                case 2:
                    if (bank.showNext() != null){
                        System.out.println("Próximo Cliente:");
                        System.out.println("Nome: " + bank.showNext().getName());
                        System.out.println("Idade: " + bank.showNext().getAge());
                        System.out.println();
                        break;
                    }
                    System.out.println("Fila vazia");
                    System.out.println();
                    break;
                case 3:
                    if(bank.isEmpty()){
                        System.out.println("Fila vazia");
                        System.out.println();
                        break;
                    }

                    System.out.print("Digite o nome do cliente a ser atendido: ");
                    name = keyboard.next();
                    System.out.print("Digite a idade do cliente a ser atendido: ");
                    age = keyboard.nextInt();


                    if (!bank.showNext().getName().equals(name)){
                        System.out.println("Nome digitado não corresponde ao próximo cliente a ser atendido.");
                        System.out.println();
                        break;
                    }
                    if (bank.showNext().getAge() != age){
                        System.out.println("Idade digitada não corresponde ao próximo cliente a ser atendido.");
                        System.out.println();
                        break;
                    }
                    Client client = bank.getNext();
                    System.out.println("Cliente " + client.getName() + " foi atendido");
                    System.out.println();
                    break;
                case 4:
                    System.out.println(bank.showQueues());
                    System.out.println();
                    break;
                case 5:
                    if (bank.isEmpty()){
                        toContinue = false;
                        break;
                    }
                    System.out.println("Não pode terminar enquanto há clientes para atender");
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println();
                    break;

            }
        }
        System.out.println("Clientes idoso");
        System.out.println("Até mais!");
    }
}
