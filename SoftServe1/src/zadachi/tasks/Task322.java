package zadachi.tasks;

import zadachi.Command;

public class Task322 implements Command {
    @Override
    public void execute() {
        System.out.println("Task 322 :\n" +
                "Given a natural number n [1:10000]. Find a number with maximum amount of divider.");
        int n=10_000;
        int arr[]=new int[n+1];
        int sumOfDivider=0;
        int result=0;
        for (int i=1;i<=n;i++){
            for(int j=0;j<=n;j++){
                if((i-j)>0 && i%(i-j)==0){
                    arr[i]+=(i-j);
                }
            }
            if (sumOfDivider<=arr[i]){
                sumOfDivider=arr[i];
                result=i;
            }
        }
        System.out.println("Number with maximum amount of divider is "+result);
    }
}
