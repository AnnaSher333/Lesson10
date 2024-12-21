package Ex1;

import java.io.*;
import java.util.*;

//Дан файл содержащий несколько случайных натуральных чисел от 1 до 50.
//Необходимо написать многопоточное приложение,которое параллельно рассчитает
//и выведет в консоль факториал для каждого числа из файла.
public class Main {
    public static void main(String[] args) {
        //внутри потока вызывается поток ThreadReader, считывающий информацию из файла Numbers
        Thread operation = new Thread(new ThreadOperation());
        operation.start();

    }
}