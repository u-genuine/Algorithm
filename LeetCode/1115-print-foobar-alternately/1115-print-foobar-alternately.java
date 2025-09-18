class FooBar {
    private int n;
    private boolean fooDone = false;
    private boolean barDone = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(!barDone) {
                Thread.sleep(1);
            }
        	printFoo.run();
            fooDone = true;
            barDone = false;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(!fooDone){
                Thread.sleep(1);
            }
        	printBar.run();
            barDone = true;
            fooDone = false;
        }
    }
}


/*
스레드 A는 foo() 호출
스레드 B는 bar() 호출



*/