class RecursionDemo1{
static int factorial(int n);
if(n==0){
return 0;
}else if(n==1){
return 1;
}
else{
return fibonacci(n-1)+fibonacci(n-2);
}
}
public static void main(String[]args){
int terms=7;
System.out.print("fibonacci number");
for(int i=1;i<terms;i++){
System.out.println(fibonacci(i)+" ");
}
}