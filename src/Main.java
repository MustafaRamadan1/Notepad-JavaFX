import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main     {


    public static void main(String[] args) {
       int [] x = {1,2,3,4,5,6};
       IntStream.of(x).filter((element) -> element < 4 ).forEach((element) -> {System.out.println(element)});
 

    }
}

