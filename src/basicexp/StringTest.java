package basicexp;
/*
-demonstrating object equality comparison for string
- use of codepoint methods
- comparison with intern() - proved equal with intern and non-equal without it
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "A";
        String b = "A";
        String c = a + b;
        String d = "AA";
        String e = "A" + "A";
        String f=new String("A");
        String g=new String("A"+"A");
        String h=new String(b);
        System.out.println(a==b);       //true
        System.out.println(a.equals(b));//true
        System.out.println(a+b==d);//false
        System.out.println(a+b==c);//false
        System.out.println(a+b==e);//false
        System.out.println(c==d);//false
        System.out.println(c==e);//false
        System.out.println(d==e);//true
        System.out.println(h==b);//false
        System.out.println(a==f);//false
        System.out.println(c==g);//false
        System.out.println(g.codePointAt(1));//65
        //g.codePoints().forEach((i)-> System.out.println(i));//65 65
        System.out.println(h.intern()==b.intern());//true
    }


}
