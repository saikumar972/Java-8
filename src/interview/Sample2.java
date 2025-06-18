package interview;

public class Sample2 {
    public static void main(String[] args) {
        int[] arr={10,20,30,0};
        //0,0,0,6000

        //{600,300,200}
        int product=1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    continue;
                }
                product=product*arr[j];
            }
            System.out.println(product);
            product=1;
        }
    }


}
