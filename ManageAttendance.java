public class ManageAttendance {
    private Client[] normal;
    private Client[] elderly;
    private int end;
    private int elderlyEnd;
    private int elderlyAttended;

    public ManageAttendance(int size) {
        normal = new Client[size];
        elderly = new Client[size];
        end = 0;
        elderlyEnd = 0;
        elderlyAttended = 0;
    }

    public boolean isEmpty() {
        return end == 0 && elderlyEnd == 0;
    }

    public int numClients(){
        return end;
    }

    public int numElderlyClients(){
        return elderlyEnd;
    }

    public boolean isFull() {
        return end == normal.length;
    }

    public boolean isElderlyFull(){
        return elderlyEnd == elderly.length;
    }

    public void addClient(String name, int age) {
        Client client = new Client(name,age);
        if (client.isElderly() && isElderlyFull()) {
            System.out.println("Fila de idosos cheia, novo cliente não inserido.");
            return;
        }
        if (client.isElderly()){
            elderly[elderlyEnd] = client;
            System.out.println("Cliente " + name + " inserido");
            System.out.println();
            elderlyEnd++;
            return;
        }

        if (isFull()){
            System.out.println("Fila cheia, novo cliente não inserido.");
            return;
        }
        normal[end] = client;
        System.out.println("Cliente " + name + " inserido");
        System.out.println();
        end++;

    }

    public Client showNext(){
        if (isEmpty()) {
            return null;
        }

        if (elderlyAttended == 2 || elderlyEnd == 0){
            return normal[0];
        }

        return elderly[0];
    }

    public Client getNext() {
        if (isEmpty()) {
            return null;
        }
        if (elderlyAttended == 2 || elderlyEnd == 0){
            Client aux = normal[0];
            for (int i = 0; i < end - 1; i++) {
                normal[i] = normal[i + 1];
            }
            end--;
            elderlyAttended = 0;
            return aux;
        }
        Client aux = elderly[0];
        for (int i = 0; i < elderlyEnd - 1; i++) {
            elderly[i] = elderly[i + 1];
        }
        elderlyEnd--;
        elderlyAttended++;
        return aux;
    }

    public String showQueues() {
        StringBuilder clients = new StringBuilder("N° de Clientes: " + numClients()+ "\n");
        clients.append("N° de Clientes idosos: " + numElderlyClients() + "\n\n");
        clients.append(("Filas -> nome:idade\n"));
        clients.append("///////////////\n");
        if (elderlyEnd == 0){
            clients.append("Idoso: vazia\n");
        }else {
            clients.append("Idoso: \n");
            for (int i = 0; i < elderlyEnd; i++) {
                clients.append(elderly[i].getName()).append(":").append(elderly[i].getAge()).append("\n");
            }
        }
        clients.append("///////////////\n");
        if (end == 0){
            clients.append("Normal: vazia");
            return clients.toString();
        }
        clients.append("Normal: \n");
        for (int i = 0; i < end; i++) {
            clients.append(normal[i].getName()).append(":").append(normal[i].getAge()).append("\n");
        }
        return clients.toString();
    }
}
