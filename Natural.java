import java.util.Scanner;
public class Natural{
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
int n= sc.nextInt();
if(n<=0){
System.out.println("enter a valid value:");
}else{
System.out.println("the values are:");
for(int i=1;i<=n;i++){
System.out.println(i+ " ");
}
System.out.println();
}
sc.close();
}
}