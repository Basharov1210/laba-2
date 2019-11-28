package com.company;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Text
{
    public String text; // текст
    public  ArrayList<String> word; // массив слов
    public int n; // кол-во слов
    public String Sumword;

   public void Print()
    {
        System.out.println(text);

        for (int i = 0; i < n; i++)
        {
            System.out.print(word.get(i));
        }


        System.out.println("массив вхождений каждого найденного слова = " + Sumword);
    }

    Text() throws Exception
    {
        text = new String();
        word = new ArrayList<String>();
        n = 0;
        Sumword = new String();
    }

    Text(String n) throws Exception
    {
        text = new String();
        text = n;
        Sumword = new String();
        LoweCase();
        
        razb();
    }



    public int Case(String pre)
    {
        int k = 0;
        pre = pre.toLowerCase();
        for (int i = 0; i < n; i++)
        {
            if ((word.get(i)).startsWith(pre))
            {
                k++;
            }
        }

        System.out.println(k + " слов начинается с префикса " + pre + '\n');
        return k;
    }


    public void LoweCase() //преобразовывает текст к одному регистру
    {
       text = text.toLowerCase();
    }


    public void razb()
    {
        String[] words = text.split(" ");

        n = words.length;
        word = new ArrayList<String>();

        for(int i = 0; i < words.length; i++)
        {
            for (int j = 0; j < (words[i]).length(); j++)
            {
                if ((words[i]).charAt(j) == '!')
                {
                    words[i] = (words[i]).replace("!","");
                    continue;
                }
                if ((words[i]).charAt(j) == '?')
                {
                    words[i] = (words[i]).replace("?","");
                    continue;
                }
                if ((words[i]).charAt(j) == ',')
                {
                    words[i] = (words[i]).replace(",","");
                    continue;
                }
                if ((words[i]).charAt(j) == '.')
                {
                    words[i] = (words[i]).replace(".","");
                    continue;
                }
                if ((words[i]).charAt(j) == ')')
                {
                    words[i] = (words[i]).replace(")","");
                    continue;
                }
                if ((words[i]).charAt(j) == '(')
                {
                    words[i] = (words[i]).replace("(","");
                    continue;
                }
                if ((words[i]).charAt(j) == ']')
                {
                    words[i] = (words[i]).replace("]","");
                    continue;
                }
                if ((words[i]).charAt(j) == '[')
                {
                    words[i] = (words[i]).replace("[","");
                    continue;
                }
                if ((words[i]).charAt(j) == ':')
                {
                    words[i] = (words[i]).replace(":","");
                    continue;
                }
                if ((words[i]).charAt(j) == ';')
                {
                    words[i] = (words[i]).replace(";","");
                    continue;
                }
            }
            word.add(words[i]);
            Sumword += words[i];
        }
    }

}
