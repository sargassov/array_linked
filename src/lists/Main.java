package lists;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayLizt<String> arrayLizt = new ArrayLizt<>();
        System.out.println("Пустой лист. Lizt size = " + arrayLizt.size());

        ArrayLizt<String> arrayLizt1 = new ArrayLizt<>(15);
        System.out.println("Пустой лист под массив из 15 элементов. Lizt size = " + arrayLizt1.size());

        ArrayLizt<String> arrayLizt2 = new ArrayLizt<>(new String[]{"A", "B", "C"});
        System.out.println("Лист из 3 строк. Lizt size = " + arrayLizt2.size());

        arrayLizt2.add("D");
        System.out.println("Добавим строку. Итоговый массив " + arrayLizt2 + ". Размер = " + arrayLizt2.size());


        arrayLizt2.addAll(new ArrayLizt<>(new String[]{"E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
        System.out.println("Внутренний массив создавался под 10 строк, но добавим весь алфавит. Итоговый массив " + arrayLizt2 + ". Размер = " + arrayLizt2.size());

        arrayLizt2.remove(4);
        System.out.println("Удалим 4 элемент. Итоговый массив " + arrayLizt2 + ". Размер = " + arrayLizt2.size());

        try {
            System.out.println("Теперь, когда внутренний массив уже под " + (int) (arrayLizt2.size() * 1.5) + " элементов попробуем обратиться  к несуществующему 30 элементу ");
            arrayLizt2.get(30);
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }

        Thread.sleep(1000);
        arrayLizt2.clear();
        System.out.println("Очистим массив. Итоговый массив " + arrayLizt2 + ". Размер = " + arrayLizt2.size());

        System.out.println("---------------------------------------");

        LinkedLizt<String> lizt = new LinkedLizt<>();
        System.out.println("Создаем ЛинкедЛист. " + lizt + ". Его размер после создания = " + lizt.size());

        LinkedLizt<String> lizt1 = new LinkedLizt<>(new String[]{"A", "B", "C"});
        System.out.println("Создаем второй через массив. Добавим три строки. " + lizt1 + ". Его размер после создания = " + lizt1.size());

        LinkedLizt<String> lizt2 = new LinkedLizt<>(lizt1);
        System.out.println("Создаем третий через другой линкед лист. " + lizt2 + ".  Его размер после создания = " + lizt2.size());

        lizt2.addFirst("Stroka");
        System.out.println("Добавим строку вперед.  " + lizt2 + ". Pазмер  = " + lizt2.size());

        lizt2.addLast("Stroka");
        System.out.println("Добавим строку назад.  " + lizt2 + ". Pазмер  = " + lizt2.size());

        lizt2.add("ЫЫЫ", 3);
        System.out.println("Добавим строку по индексу 3.  " + lizt2 + ". Pазмер  = " + lizt2.size());

        lizt2.remove(4);
        System.out.println("Удаляем строку 5.  " + lizt2 + ". Pазмер  = " + lizt2.size());
    }
}
