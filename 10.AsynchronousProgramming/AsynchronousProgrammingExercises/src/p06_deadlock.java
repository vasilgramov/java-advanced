public class p06_deadlock {

    public static void main(String[] args) {
        MyClass first = new MyClass("First");
        MyClass second = new MyClass("Second");

        Thread tFirst = new Thread(() -> {first.a(second);});
        Thread tSecond = new Thread(() -> {second.a(first);});

        tFirst.start();
        tSecond.start();
    }

    static class MyClass {
        private String id;

        public MyClass(String id) {
            this.setId(id);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        synchronized void a(MyClass other) {
            System.out.printf("%s called method a %s%n", this.getId(), other.getId());
            other.b(this);
        }

        synchronized void b(MyClass other) {
            System.out.printf("%s called method a %s%n", other.getId(), this.getId());
            this.a(other);
        }
    }
}
