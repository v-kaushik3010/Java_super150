package lecture_3;
import java.util.*;


//hollow diamond pattern

public class hollow_rhombus_pattern {

    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int star=n/2+1;
        int space=-1;
        for(int row=1;row<=n;row++) {
            //stars
            for(int i=1;i<=star;i++){
                System.out.print("*\t");
                }
            for(int i=1;i<=space;i++){
                System.out.print("\t");
                }
            if(row==1 || row==n){
                for(int i=1;i<=n/2;i++){
                    System.out.print("*\t");
                    }
                    }
            else {
                for(int i=1;i<=star;i++){
                    System.out.print("*\t");
                    }
                    }
            System.out.println();
            if(row<n/2+1){
                star--;space+=2;
                }
            else{
                star++;space-=2;
                }
        }
    }
}


