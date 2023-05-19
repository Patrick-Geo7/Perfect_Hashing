public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    HashFunc HF = new HashFunc();
    for(int q =0; q<HF.getU(); q++){
        for(int a=0; a<HF.getB(); a++){
            System.out.print(HashFunc(5,4)[q][a]);
        }
        System.out.println("");
    }

    }
}