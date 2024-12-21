package Ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//поток считывает информацию из файла и записывает ее в лист
public class ThreadReader implements Runnable{
    private static final List<Integer> list = new ArrayList<>();
    @Override
    public void run() {
        File file = new File("/Users/annasheremet/IdeaProjects/Lesson10/src/Ex1/Numbers");
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                list.add(scanner.nextInt());
            }
            System.out.println(list);
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Integer> getList(){
        return list;
    }
}
