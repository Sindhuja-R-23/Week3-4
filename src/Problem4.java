class Asset {
    String name; double returnRate;
    Asset(String name,double r){this.name=name;this.returnRate=r;}
    public String toString(){return name+":"+returnRate+"%";}
}

public class Problem4 {
    public static void main(String[] args){
        Asset[] assets={new Asset("AAPL",12),new Asset("TSLA",8),new Asset("GOOG",15)};
        mergeSort(assets,0,assets.length-1);
        System.out.println("Merge Asc: "+Arrays.toString(assets));
        quickSortDesc(assets,0,assets.length-1);
        System.out.println("Quick Desc: "+Arrays.toString(assets));
    }

    static void mergeSort(Asset[] arr,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            mergeSort(arr,l,m); mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    static void merge(Asset[] arr,int l,int m,int r){
        Asset[] temp=new Asset[r-l+1];
        int i=l,j=m+1,k=0;
        while(i<=m && j<=r){
            if(arr[i].returnRate<=arr[j].returnRate) temp[k++]=arr[i++];
            else temp[k++]=arr[j++];
        }
        while(i<=m) temp[k++]=arr[i++];
        while(j<=r) temp[k++]=arr[j++];
        for(i=0;i<temp.length;i++) arr[l+i]=temp[i];
    }

    static void quickSortDesc(Asset[] arr,int low,int high){
        if(low<high){
            int pi=partition(arr,low,high);
            quickSortDesc(arr,low,pi-1);
            quickSortDesc(arr,pi+1,high);
        }
    }
    static int partition(Asset[] arr,int low,int high){
        double pivot=arr[high].returnRate;
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j].returnRate>=pivot){
                i++; Asset tmp=arr[i]; arr[i]=arr[j]; arr[j]=tmp;
            }
        }
        Asset tmp=arr[i+1]; arr[i+1]=arr[high]; arr[high]=tmp;
        return i+1;
    }
}
