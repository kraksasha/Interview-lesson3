package Example1;

public class ThreadEx {

    public static void main(String[] args) {
        Object ob = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ob){
                    int i = 0;
                    while (i != 5){
                        try {
                            System.out.println("ping");
                            if (i > 0){
                                ob.notify();
                            }
                            i++;
                            ob.wait();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    ob.notify();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ob){
                    int i = 0;
                    while (i != 5){
                        try {
                            System.out.println("pong");
                            i++;
                            ob.notify();
                            ob.wait();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        }).start();
    }
}
