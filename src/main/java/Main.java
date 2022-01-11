import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String com = "";
        String path = "C:/Users/Jinbo Jonez/Desktop";

        while (!com.equals("quit")){
            File file = new File(path);
            com = scanner.readLine();

            if(com.equals("quit"))
                break;

            if (!com.equals("ls") && !com.equals("pwd") && !com.startsWith("cd ") && !com.equals("cd"))
                System.out.println("el comando: " + com + " no se reconoce" );

            if(com.equals("ls")){
                String[] array = file.list();
                for(String s : array ){
                    System.out.println(s);
                }
            }

            if(com.equals("pwd")){
                System.out.println(path);
            }

            if (com.equals("cd")){
                String[] array = path.split("/");
                array[array.length-1] = "";
                path = String.join("/", array);
                System.out.println(path);
            }

            if(com.startsWith("cd ")){
                String[] cd = com.split(" ");
                String[] array = file.list();
                assert array != null;
                List<String> list = Arrays.asList(array);
                String direct = cd[1];

                if(list.contains(direct)) {
                    path = path + "/" + direct;
                    System.out.println(path);
                }
                else System.out.println("no existe la ruta especificada");
            }
        }
    }
}
