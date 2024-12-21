package Ex1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreadOperation implements Runnable{
    //кэш для хранения значений, которые мы уже посчитали
    private static final Map<Integer, Long> cache = new HashMap<>();
    //поток для считывания данных из файла
    private final ThreadReader threadReader =new ThreadReader();

    @Override
    public void run() {
        threadReader.run();//запускаем считывание
        try {
            for (Integer num: threadReader.getList()) {//заполяенм кэш факториалами
                if(!cache.containsKey(num)) {
                    cache.put(num, factorial(num));
                }
            }
            for (Integer num: threadReader.getList()) {//выводим факториал из кэша для каждого числа
                System.out.println(cache.get(num));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //расчет факториала
    public long factorial(int num){
            int result = 1;
            for (int i = 1; i <= num; i ++){
                result = result*i;
            }
            return (long)result;
        }
    }

