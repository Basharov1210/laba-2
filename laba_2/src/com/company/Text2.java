package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Text2
{
    StringBuffer text;
    public  ArrayList<String> sent; // массив предложений

    Text2() throws Exception
    {
        text = new StringBuffer();
        sent = new ArrayList<>();
    }

    Text2(String n) throws Exception
    {
        text = new StringBuffer(n);
        sent = new ArrayList<String>();
        int st = 0, end = 0;

        for (int i = 0; i < n.length(); i++)
        {
            if ((n.charAt(i) == '.') || (n.charAt(i) == '!') || (n.charAt(i) == '?'))
            {
                end = i+1;
            } else continue;
          //  System.out.println(str.substring(st,end));
            String buf = n.substring(st,end);
            sent.add(buf);
            st = end;
        }
            End();
    }

    public void End()
    {
        int minIndex = 0;
        for (int i = 1; i < sent.size(); i++)
        {
            if ((sent.get(i).length()) < (sent.get(minIndex).length())) minIndex = i;
        }
        String buf;
        buf =  sent.get(minIndex);
        buf += "Конец";
        sent.set(minIndex,buf);

    }

    public void Print()
    {
        System.out.println(text);

        for (int i = 0; i < sent.size(); i++)
        {
            System.out.println(sent.get(i));
        }
        System.out.println();
    }

    public StringBuffer x2numb()
    {
        String buf = "";
        int pls = 0;
        int st = 0;
        int end = 0;

        Pattern num = Pattern.compile("\\d{2}");
        Matcher m =num.matcher(text);

        while (m.find())
        {
            st = m.start();
            end = m.end();
            if ((text.charAt(end) >= '0') && (text.charAt(end) <= '9')) continue;
       //     System.out.println("start = " + st);
       //     System.out.println("end = " + end);
      //      System.out.println(text.substring(st,end));

            pls = Integer.parseInt(text.substring(st,end));
            buf = "";
            while (pls != 0) { pls -= 1; buf += "+";}
            text.replace(st,end,buf);
            m.reset();
        //    System.out.println(text);
        }
        return text;
    }

    public StringBuffer x3numb()
    {
        String buf = "";
        int st = 0;
        int end = 0;
        int End = 0;
        StringBuffer buf1 = new StringBuffer();
        Pattern num = Pattern.compile("\\d{3}");
        Matcher m =num.matcher(text);

        while (m.find(End))
        {
            End = m.end();

            st = text.length() - m.end();;
            end = text.length() - m.start();

            if ((text.charAt(end) >= '0') && (text.charAt(end) <= '9')) continue;
            buf1.append(text);
            buf1.reverse();

            text.replace(m.start(),m.end(),buf1.substring(st,end));
            m.reset();

        }
        return text;
    }


}
