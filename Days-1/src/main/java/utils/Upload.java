package utils;

import java.util.concurrent.TimeUnit;

public class Upload extends Thread{

    private String imagePath = "";
    public Upload(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println( imagePath + " - Upload" );
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(imagePath + " Upload Finish");
    }

}
