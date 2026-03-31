class Trade {
    String id; int volume;
    Trade(String id, int volume) { this.id=id; this.volume=volume; }
    public String toString() { return id+":"+volume; }
}

public class Problem3 {
    public static void main(String[] args) {
        Trade[] trades = {
                new Trade("trade3", 500),
                new Trade("trade1", 100),
                new Trade("trade2", 300)
        };

        mergeSort(trades, 0, trades.length-1);
        System.out.println("MergeSort Asc: " + Arrays.toString(trades));

        quickSortDesc(trades, 0, trades.length-1);
        System.out.println("QuickSort Desc: " + Arrays.toString(trades));
    }

    static void mergeSort(Trade[] arr, int l, int r) {
        if (l<r) {
            int m=(l+r)/2;
            mergeSort(arr,l,m); mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    static void merge(Trade[] arr,int l,int m,int r){
        Trade[] temp=new Trade[r-l+1];
        int i=l,j=m+1,k=0;
        while(i<=m && j<=r){
            if(arr[i].volume<=arr[j].volume) temp[k++]=arr[i++];
            else temp[k++]=arr[j++];
        }
        while(i<=m) temp[k++]=arr[i++];
        while(j<=r) temp[k++]=arr[j++];
        for(i=0;i<temp.length;i++) arr[l+i]=temp[i];
    }

    static void quickSortDesc(Trade[] arr,int low,int high){
        if(low<high){
            int pi=partition(arr,low,high);
            quickSortDesc(arr,low,pi-1);
            quickSortDesc(arr,pi+1,high);
        }
    }
    static int partition(Trade[] arr,int low,int high){
        int pivot=arr[high].volume;
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j].volume>=pivot){
                i++; Trade tmp=arr[i]; arr[i]=arr[j]; arr[j]=tmp;
            }
        }
        Trade tmp=arr[i+1]; arr[i+1]=arr[high]; arr[high]=tmp;
        return i+1;
    }
}
