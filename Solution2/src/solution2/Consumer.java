/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 *
 * @author vvlasov
 */
public class Consumer implements Runnable {

    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(450);
            } catch (InterruptedException e) {

            }
            while (true) {
                try {
                    if (!queue.hasWaitingConsumer()) {
                        ShareItem item = queue.take();
                        System.out.format("Processing %s\n", item.toString());
                    }else
                        queue.hasWaitingConsumer();
                } catch (InterruptedException e) {

                }
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }
            }

        }
    }

}
