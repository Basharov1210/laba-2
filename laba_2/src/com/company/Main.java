package com.company;


import java.util.Scanner;

public class Main
{

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(java.lang.System.in);

        String n = null;
        System.out.println("Введите текст: ");
        n = s.nextLine();

        Text e = new Text(n);

        e.Print();

        String p = null;
        System.out.println("Введите символ: ");
        p = s.nextLine();

        System.out.println(e.Case(p) + " слов начинается с префикса " + p + '\n');

        System.out.println();

       Text2 a = new Text2(n);
        a.Print();

        System.out.println(a.x2numb());

        System.out.println(a.x3numb());

        System.out.println();

        String k = null;
        System.out.println("Введите mail почту: ");
        k = s.nextLine();

        Mail b = new Mail(k);
        b.correct();

        String m = null;
        System.out.println("Введите текст в котором есть mail почта: ");
        m = s.nextLine();

        Mail c = new Mail(m);
        c.Break();

    }
}


