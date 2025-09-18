class Foo {
    private boolean firstDone = false;
    private boolean secondDone = false;

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstDone = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(!firstDone) {
            Thread.sleep(1);
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondDone = true;
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        while(!secondDone) {
            Thread.sleep(1);
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}