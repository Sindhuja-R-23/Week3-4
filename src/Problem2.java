class Client {
    String name;
    int riskScore;
    int balance;

    Client(String name, int riskScore, int balance) {
        this.name = name; this.riskScore = riskScore; this.balance = balance;
    }

    public String toString() {
        return name + "(" + riskScore + ")";
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Client[] clients = {
                new Client("clientC", 80, 1000),
                new Client("clientA", 20, 500),
                new Client("clientB", 50, 700)
        };

        bubbleSort(clients);
        System.out.println("Bubble Asc: " + Arrays.toString(clients));

        insertionSortDesc(clients);
        System.out.println("Insertion Desc: " + Arrays.toString(clients));

        System.out.println("Top Risks: ");
        for (int i = 0; i < Math.min(3, clients.length); i++) {
            System.out.println(clients[i]);
        }
    }

    static void bubbleSort(Client[] arr) {
        int n = arr.length;
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-i-1; j++) {
                if (arr[j].riskScore > arr[j+1].riskScore) {
                    Client temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp;
                }
            }
        }
    }

    static void insertionSortDesc(Client[] arr) {
        for (int i=1; i<arr.length; i++) {
            Client key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j].riskScore < key.riskScore) {
                arr[j+1] = arr[j]; j--;
            }
            arr[j+1] = key;
        }
    }
}
