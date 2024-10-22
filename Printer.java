/* Задание 1. Студенческий справочник
Реализуйте программу для работы с простым справочником студентов.
Программа должна иметь следующие функции:
● addStudent(String name, Integer grade): Добавляет или обновляет запись о студенте с именем name и оценкой grade. Если
студент уже существует, обновляет его оценку.
● findStudent(String name): Находит оценки студента по его имени.
Если студент существует, возвращает список его оценок. Если нет — пустой список.
● getAllStudents(): Возвращает весь справочник студентов в виде
HashMap, где ключи — имена студентов, а значения — списки их оценок.
● removeStudent(String name): Удаляет запись о студенте по имени
из справочника. Если запись не существует, ничего не происходит.
 */


/* import java.util.ArrayList;
import java.util.HashMap;

class StudentDirectory {
    private HashMap<String, ArrayList<Integer>> studentMap = new HashMap<>();
// Добавляет или обновляет запись о студенте

    public void addStudent(String name, Integer grade) {
        studentMap.computeIfAbsent(name, k -> new ArrayList<>()).add(grade);  
    }
// Находит оценки студента по имени
    public ArrayList<Integer> findStudent(String name) {
        return studentMap.getOrDefault(name, new ArrayList<>());
    // Напишите свое решение ниже
    }
    // Возвращает весь справочник студентов
    public HashMap<String, ArrayList<Integer>> getAllStudents() {
    // Напишите свое решение ниже
        return studentMap;
    }
    // Удаляет запись о студенте по имени
    public void removeStudent(String name) {
        studentMap.remove(name);
    // Напишите свое решение ниже
    }
}
public class Printer {
    public static void main(String[] args) {
        StudentDirectory directory = new StudentDirectory();
        directory.addStudent("Alice", 90);
        directory.addStudent("Bob", 85);
        directory.addStudent("Alice", 95);
        System.out.println("Before removal:");
        System.out.println(directory.findStudent("Alice")); 
        System.out.println(directory.getAllStudents()); //
        directory.removeStudent("Alice");
        System.out.println("After removal:");
        System.out.println(directory.findStudent("Alice")); //         []
        System.out.println(directory.getAllStudents()); //         {Bob=[85]}
    }

}
 */

/*  Задача 2. История посещения веб-сайтов
 Реализуйте программу для хранения и анализа историй посещений веб-сайтов. Используйте Deque для хранения истории.
 ● visitSite(String site): Добавляет сайт в историю посещений.
 ● back(int steps): Возвращает название сайта, который был посещен steps назад, или null, если таких шагов нет.
 ● getHistory(): Возвращает список сайтов в истории посещений, от последнего посещенного к первому. */

 /* import java.util.Deque;
 import java.util.LinkedList;
 
 class BrowserHistory {
    // Напишите свое решение ниже
    private Deque<String> history = new LinkedList<>();
    public void visitSite(String site) {
        history.addFirst(site);
    // Напишите свое решение ниже
    }
    public String back(int steps) {
        if (steps >= history.size()) {
            return null;
            }
        return history.stream().skip(steps).findFirst().orElse(null);
        // Напишите свое решение ниже
    }
    public Deque<String> getHistory() {
        return history;
    // Напишите свое решение ниже
    }
}
// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        browserHistory.visitSite("google.com");
        browserHistory.visitSite("stackoverflow.com");
        browserHistory.visitSite("github.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.getHistory());
    }
} */

/* Задача 3. Подсчет продуктов в корзине 
Создайте программу для учета продуктов в корзине. Программа должна
позволять добавлять, удалять, обновлять количество продуктов, а также
проверять наличие продуктов в корзине. Используйте HashMap для хранения
продуктов и их количества.
Методы:
● addProduct(String product, Integer quantity): Добавляет
продукт с указанным количеством в корзину. Если продукт уже есть,
увеличивает его количество.
● removeProduct(String product): Удаляет продукт из корзины. Если
продукт отсутствует, ничего не делает.
● updateQuantity(String product, Integer quantity): Обновляет
количество продукта в корзине. Если продукта нет, ничего не делает.
● checkProduct(String product): Проверяет, есть ли продукт в
корзине и возвращает его количество. Если продукта нет, возвращает 0.
● showBasket(): Выводит все продукты и их количество в корзинe */

/* import java.util.HashMap;

class ShoppingBasket {
    private HashMap<String, Integer> basket = new HashMap<>();
    // Метод для добавления продукта в корзину
    public void addProduct(String product, Integer quantity) {
        if (basket.containsKey(product)) {
            basket.put(product, basket.get(product) + quantity);
        } else {
            basket.put(product, quantity);
        }
    }
    // Метод для удаления продукта из корзины
    public void removeProduct(String product) {
        if (basket.containsKey(product)) {
            basket.remove(product);
        }
    }

    // Метод для обновления количества продукта в корзине
    public void updateQuantity(String product, Integer quantity) {
        if (basket.containsKey(product)) {
            basket.put(product, quantity);
        }
    }
    
// Метод для проверки количества продукта в корзине
    public int checkProduct(String product) {
        return basket.getOrDefault(product, 0);
    }
    // Метод для вывода всех продуктов и их количества
    public void showBasket() {
        if (basket.isEmpty()) {
            System.out.println("Basket is empty.");
        } else {
            for (HashMap.Entry<String, Integer> entry : basket.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }
}

// Не удаляйте и не меняйте метод Main!
public class Printer {
    public static void main(String[] args) { 
        String product1, product2, product3; Integer quantity1, quantity2, quantity3;
        if (args.length == 0) {
            product1 = "apple";
            quantity1 = 3;
            product2 = "banana";
            quantity2 = 2;
            product3 = "apple";
            quantity3 = 5;
        } else {
            product1 = args[0];
            quantity1 = Integer.parseInt(args[1]);
            product2 = args[2];
            quantity2 = Integer.parseInt(args[3]);
            product3 = args[4];
            quantity3 = Integer.parseInt(args[5]);
        }
        ShoppingBasket basket = new ShoppingBasket();
        basket.addProduct(product1, quantity1);
        basket.addProduct(product2, quantity2);
        basket.addProduct(product3, quantity3);

        System.out.println("Basket after adding products:");
        basket.showBasket();
        basket.removeProduct("banana");
        System.out.println("Basket after removing 'banana':");
        basket.showBasket();
        basket.updateQuantity("apple", 10);
        System.out.println("Basket after updating quantity of 'apple':");
        basket.showBasket();
        System.out.println("Quantity of 'apple': " +
        basket.checkProduct("apple"));
        System.out.println("Quantity of 'banana': " +
        basket.checkProduct("banana"));
    }
}
 */
/* Задача 4. Сортировка слиянием
Напишите программу, которая реализует сортировку слиянием. Программа
должна содержать два основных метода: merge для объединения двух
отсортированных массивов в один отсортированный, и mergeSort для
сортировки массива с использованием сортировки слиянием.
 */

import java.util.Arrays;
class MergeSort {
// Метод для объединения двух отсортированных массивов
public static void merge(int[] left, int[] right, int[] result)
{
    int i = 0, j = 0, k = 0;
// Объединение элементов из массива left и right в массив result
    while (i < left.length && j < right.length) {
    if (left[i] <= right[j]) {
        result[k++] = left[i++];
    } else {
        result[k++] = right[j++];
    }   
}
// Копирование оставшихся элементов из массива left (если есть)
while (i < left.length) {
    result[k++] = left[i++];
}
// Копирование оставшихся элементов из массива right (если есть)
while (j < right.length) {
    result[k++] = right[j++];
    }
    }
    
// Метод для рекурсивной сортировки массива
public static void mergeSort(int[] array) {
    if (array.length < 2) {
        return; // Массив с одним элементом уже отсортирован
    }
    int mid = array.length / 2;
    int[] left = Arrays.copyOfRange(array, 0, mid);
    int[] right = Arrays.copyOfRange(array, mid, array.length);
    // Рекурсивная сортировка двух половин
    mergeSort(left);
    mergeSort(right);
    // Объединение отсортированных половин
    merge(left, right, array);
    }
    }
    // Не удаляйте и не меняйте метод Main!
    public class Printer {
    public static void main(String[] args) {
    int[] initArray;
    if (args.length == 0) {
        initArray = new int[]{38, 27, 43, 3, 9, 82, 10};
        } else {
        initArray = Arrays.stream(args[0].split("        ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        MergeSort.mergeSort(initArray);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
}
}