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
public class Producer implements Runnable {

    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        for (int i = 1; i < 10; i++) {
            System.out.format("Элемент 'ShareItem-%d' добавлен\n", i);
            queue.offer(new ShareItem("ShareItem-" + i, i));
            

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;

            }
            if (queue.hasWaitingConsumer()) {
                System.out.format("Consumer в ожидании!\n");
            } 
        }
    }

}
