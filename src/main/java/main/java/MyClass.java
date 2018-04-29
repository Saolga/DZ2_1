package main.java;
import java.util.Scanner;//Для работы с консолью

public class MyClass {
    public static void main(String[] args) {
        /**
         Программа выполняет одно из заданий на выбор.
         Если в консоли ввести 1 - запуститься выполнение калькулятора,
         если 2 - поиск самого длинного слова в массиве.
         @author Olga Pashenina
         */
        Scanner sc = new Scanner(System.in);
        int choose=0;   //сюда записываем выбор программы
        System.out.println("Enter number of task: (1 - calculator, 2 - string array):");
        choose=sc.nextInt();
        switch(choose){     //смотри, какую программу запускать
            case 1:
                calc(sc);
                break;
            case 2:
                mass(sc);
                break;
            default:        //введено не 1 и не 2 - ничего не делаем
                System.out.println("Unknown command");
                break;
        }

        sc.close();
    }
    private static void calc(Scanner sc){
        /*
        Простейший консольный калькулятор. Считываем два числа с плав.точкой и символ операции.
        Выводим результат.
         */
        double a,b=0;
        char c='+';
        System.out.println("Input first number:");
        a=sc.nextDouble();      //считываем первое число
        System.out.println("Input second number:");
        b=sc.nextDouble();      //считываем второе число
        System.out.println("Input operation symbol (+,-,/,*):");
        c=sc.next().charAt(0);  //считываем символ
        switch(c){      //в зависимости от символа выводим результат (в форматированном виде)
            case'-':
                System.out.printf("Result: %.4f",(a-b));
                break;
            case'*':
                System.out.printf("Result: %.4f",(a*b));
                break;
            case'/':
                if(b==0)
                    System.out.println("Result: infinity");
                else
                    System.out.printf("Result: %.4f",(a/b));
                break;
            default:
                System.out.printf("Result: %.4f",(a+b));
                break;
        }
    }

    private static void mass(Scanner sc){
        /*
        Задаём размер массива, вводим в него слова.
        Находим самое длинное(если есть ещё слов с таким же
        размером, будет выведено первое из них).
         */
        int sz=0;
        System.out.println("Input array size:");
        sz=sc.nextInt();      //считываем размер массива
        if(sz<=0){
            System.out.println("Wrong size, termination");
            return;
        }
        String words[];
        words=new String[sz];   //создаём массив слов
        System.out.println("Input "+sz+" words:");  //заполняем его
        for(int i=0;i<words.length;++i){
            words[i]=sc.next();
        }
        int max=0;  //размер максимального слова
        int index=0;    //индекс максимального слова
        for(int i=0;i<words.length;++i){    //поиск максимального слова
            if(words[i].length() > max){
                max=words[i].length();
                index=i;
            }
        }
        System.out.println("The longest word is: "+words[index]); //выводим самое длинное слово
    }
}
