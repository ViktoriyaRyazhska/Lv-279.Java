package jar;

import java.util.Iterator;

public class App
{
    public static void main( String[] args )
    {
        Buffer<String> buf = new Buffer<String>();
        buf.enqueue("str");
        buf.enqueue("str2");
        buf.enqueue("str3");
        buf.enqueue("str4");

//        Iterator<String> iterator = buf.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
       if (buf.contains("str55"))
           System.out.println("good");
        if (buf.isEmpty())
            System.out.println("good");
    }
}
