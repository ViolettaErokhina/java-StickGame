import java.util.Scanner;

public class StickGame {

    public static boolean canWin(long n) {
        // Базовые случаи:
        if (n == 1) return false;    // Можно взять 1 палочку (конец игры)
        if (n == 2) return true;     // Можно взять половину (1) или 1 - выигрышная позиция
        if (n == 3) return false;    // Можно взять только 1 → противник получит 2 и победит
        if (n == 4) return true;     // Можно взять половину (2) или 1 → выигрышная позиция

        if (n % 2 == 0) {
            // Если игрок берет половину (n/2), проверяем, ведет ли это к проигрышу противника
            if (!canWin(n / 2)) return true;

            // Если игрок берет 1, проверяем, сможет ли противник проиграть
            return !canWin(n - 1);
        } else {
            // Если палочек нечетное количество, можно взять только 1
            return !canWin(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество палочек (1 <= n <= 10^18): ");
        long n = scanner.nextLong();
        scanner.close();

        // Проверяем, может ли текущий игрок (Саша или Таня) выиграть
        if (canWin(n)) {
            System.out.println("Первый игрок (Саша) победит!");
        } else {
            System.out.println("Первый игрок (Саша) проиграет.");
        }
    }
}