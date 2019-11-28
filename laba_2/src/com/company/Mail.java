package com.company;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail
{
   protected String text;
   protected ArrayList<String> mails;

    Mail()
    {
        text = new String();
        mails = new ArrayList<String>();
    }

    Mail(String str) throws Exception
    {
        text = str;
        mails = new ArrayList<String>();
    }
    public void correct()
    {
        for (int i = 0; i < text.length(); i++)
        {
            if ((text.charAt(i) == '@') && (i != 0))
            {
                System.out.println("строка " + text +  " является корректным email-ом");
            }
        }
    }

    public void Break()
    {
        String buf = "";
        int st = 0;
        int end = 0;

        System.out.println(text);

        Pattern Emal = Pattern.compile("[A-Za-z0-9 + _.-]+@[a-z + .]+");
        Matcher m = Emal.matcher(text);

        while (true)
        {
            if (!m.find()) { break;}
            st = m.start();
            end = m.end();
            mails.add(text.substring(st,end));
        }
        System.out.println("Текст содержал эти email-ы");
        for (int i = 0; i < mails.size(); i++)
        {
            System.out.println(mails.get(i));
        }
    }

}

