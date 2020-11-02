package aop;

public class Animal {
    protected Integer width;
    protected Integer height;
    protected void eat(){
        Long start = System.currentTimeMillis();//毫秒
        System.out.println("I can eat");
        Long end = System.currentTimeMillis();//毫秒
        System.out.println((end-start)/1000f+"s");
    }
    protected void run(){
        Long start = System.currentTimeMillis();//毫秒
        System.out.println("I can run");
        Long end = System.currentTimeMillis();//毫秒
        System.out.println((end-start)/1000f+"s");
    }
}
