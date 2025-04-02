import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader inPut =  new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(inPut.readLine());
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < number/4; i++){
            str.append("long ");
        }
        if(number%4 > 0)
        {
            str.append("int");
        }

        System.out.print(str);
    }
}