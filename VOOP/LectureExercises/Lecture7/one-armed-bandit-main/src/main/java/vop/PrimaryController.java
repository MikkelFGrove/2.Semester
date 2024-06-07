package vop;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URISyntaxException;

public class PrimaryController {

    @FXML
    private Label resultLabel;

    @FXML
    private ImageView spin1;

    @FXML
    private ImageView spin2;

    @FXML
    private ImageView spin3;

    @FXML
    private Button startButton;

    @FXML
    private Button stop1;

    @FXML
    private Button stop2;

    @FXML
    private Button stop3;

    Image[] images;
    Thread t1, t2, t3;
    int spinsAlive;
    @FXML
    public void initialize(){
        images= new Image[10];
        try {
            for (int i = 0; i < images.length; i++) {
                images[i] = new Image(getClass().getResource("fruits" + i +".png").toURI().toString());
            }
        } catch (URISyntaxException e){
            System.out.println("Exception when trying to load images :(");
        }
        spin1.setImage(images[1]);
        spin2.setImage(images[1]);
        spin3.setImage(images[1]);
        stop1.setDisable(true);
        stop2.setDisable(true);
        stop3.setDisable(true);

        stop1.setOnAction(this::stop);
        stop2.setOnAction(this::stop);
        stop3.setOnAction(this::stop);

        startButton.setOnAction(this::start);
    }


    private synchronized void aliveCount(boolean up) {
        if (up) {
            spinsAlive++;
        } else {
            spinsAlive--;
        }

        System.out.println("Alive: " + spinsAlive);
        if (spinsAlive == 0) {
            startButton.setDisable(false);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (spin1.getImage() == spin2.getImage() && spin1.getImage() == spin3.getImage()) {
                        resultLabel.setText("All 3 equals! JACKPOT!");
                    } else if (spin1.getImage() == spin2.getImage()
                            || spin1.getImage() == spin3.getImage()
                            || spin2.getImage() == spin3.getImage()) {
                        resultLabel.setText("2 equals! Congratulations!");
                    } else {
                        resultLabel.setText("You are a LOSER!");

                    }
                }
            });
        }
    }

    private void start(ActionEvent actionEvent) {
        BanditRunnable bandit1 = new BanditRunnable(0, 120, spin1);
        BanditRunnable bandit2 = new BanditRunnable(0, 100, spin2);
        BanditRunnable bandit3 = new BanditRunnable(0, 140, spin3);
        t1 = new Thread(bandit1);
        t2 = new Thread(bandit2);
        t3 = new Thread(bandit3);
        t1.setDaemon(true);
        t2.setDaemon(true);
        t3.setDaemon(true);
        t1.start();
        t2.start();
        t3.start();
        resultLabel.setText("Running...");
        stop1.setDisable(false);
        stop2.setDisable(false);
        stop3.setDisable(false);
        startButton.setDisable(true);
    }

    private void stop(ActionEvent actionEvent){
        if (((Button)actionEvent.getSource()).equals(stop1) ){
            t1.interrupt();
        } else if (((Button)actionEvent.getSource()).equals(stop2) ){
            t2.interrupt();
        } else if (((Button)actionEvent.getSource()).equals(stop3)){
            t3.interrupt();
        }
        startButton.setDisable(false);
    }

    public class BanditRunnable implements Runnable {

        private int i;
        private long sleepTime;
        private boolean running;
        private ImageView iw;

        public BanditRunnable(int i, long sleepTime, ImageView iw) {
            this.i = i;
            this.sleepTime = sleepTime;
            this.iw = iw;
        }

        @Override
        public void run() {
            running = true;
            aliveCount(true);
            System.out.println("Thread started: " + Thread.currentThread());

            while (running) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        iw.setImage(images[i]);
                        i = (i + 1) % images.length;
                    }
                });
                synchronized (this) {
                    try {
                        //Thread.sleep(sleepTime);
                        wait(sleepTime);
                    } catch (InterruptedException ex) {
                        System.out.println("Interrupted: " + Thread.currentThread());
                        running = false;
                        aliveCount(false);
                    }
                }
            }
        }
    }


}
