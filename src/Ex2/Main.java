package Ex2;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

//Выведите на экран следующую строку через 2 потока
//без использования встроенной синхронизации:0 a 1 b 2 c 3 d 4 e 5 f 6 g 7 h 8 i 9 j,
//где первый поток может выводить только цифры,
// а второй — буквы (буквы должны чередоваться друг с другом).
//Приложение не должно тратить на корректный вывод секунду или более
public class Main {
    public static void main(String[] args) {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.print(i + " ");
                        try {
                            TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
            thread1.start();
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (char i = 'a'; i < 'k'; i++) {
                        try {
                            TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.print(i + " ");
                    }
                }
            });
            thread2.start();
        }

}
