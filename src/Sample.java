
public class Sample {
    public static void main(String[] args) {
        A a1 = new C();
        B b1 = new D();
        C c1 = new C();
        C c2 = new D();
        Object o = new String("Twenty Two");
        try {
            f(c2);
            a1.a(o);
            c1.a((String) o);
            b1.b((String) o);
            c2.a(o);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException");
        } catch (BadFormatException e) {
            System.out.println("BadFormatException");
        } catch (Exception e) {
            System.out.println("Exception");
        } finally {
            System.out.println("Good Bye!");
        }
    }
    public static void f(A a) {
        a.a(a);
    }
}

interface A {
    void a(Object o);
}

interface B {
    void b(String s);
}

class C implements A {
    public void a(Object o) {
        System.out.println("a() in C");
    }

    public void b(String s) {
        System.out.println("b() in C");
    }
}


class D extends C implements A, B {
    public void a(Object o) {
        System.out.println("a() in D");
        super.a(o);
    }

    public void b(String s) {
        System.out.println("b() in D");
        try {
            int parseInt = Integer.parseInt(s);
        } catch (Exception e) {
            //NumberFormatException
            throw new BadFormatException();
        }
    }
}

class BadFormatException extends RuntimeException { }
