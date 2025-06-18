package interfacee;
@FunctionalInterface
interface FunctionalInterfacee {
    void print(int x);
}
@FunctionalInterface
interface FunctionalInterfacee2 {
    int print(int x);
}
@FunctionalInterface
interface FunctionalInterfacee3 {
    int moddiff(int x,int y);
}
class MainClass{
    public static void main(String[] args) {
        FunctionalInterfacee face=System.out::println;
        face.print(10);
        FunctionalInterfacee2 face2=(x)-> x;
        System.out.println(face2.print(20));
        FunctionalInterfacee3 face3=(a,b)->{
            if(a>b)
                return a-b;
            if(b>a)
                return b-a;
            else{
                throw new RuntimeException("no diff");
            }
        };
        System.out.println(face3.moddiff(12,129));
    }
}
