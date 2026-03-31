import java.util.*;

class Transaction {
    String id;
    double fee;
    String timestamp;

    Transaction(String id, double fee, String ts) {
        this.id = id; this.fee = fee; this.timestamp = ts;
    }

    public String toString() {
        return id + ":" + fee + "@" + timestamp;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        List<Transaction> txns = new ArrayList<>();
        txns.add(new Transaction("id1", 10.5, "10:00"));
        txns.add(new Transaction("id2", 25.0, "09:30"));
        txns.add(new Transaction("id3", 5.0, "10:15"));

        bubbleSort(txns);
        System.out.println("BubbleSort: " + txns);

        insertionSort(txns);
        System.out.println("InsertionSort: " + txns);

        txns.stream().filter(t -> t.fee > 50).forEach(t -> System.out.println("High Fee Outlier: " + t));
    }

    static void bubbleSort(List<Transaction> list) {
        int n = list.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (list.get(j).fee > list.get(j+1).fee) {
                    Collections.swap(list, j, j+1);
                }
            }
        }
    }

    static void insertionSort(List<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i-1;
            while (j >= 0 && list.get(j).fee > key.fee) {
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, key);
        }
    }
}
