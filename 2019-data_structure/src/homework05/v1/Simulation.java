package homework05.v1;

public class Simulation {

  public static void main(String[] args) {
    int MAX_TIME = 100;
    int mean = 2;
    int x = 6;
    int deltaTime = 0;
    ExponentialRandom exponentialRandom = new ExponentialRandom(mean);
    SLinkedQueue objectQueue = new SLinkedQueue();
    SLinkedQueue[] QueueArray = new SLinkedQueue[2];
    for (int loop = 0; loop < QueueArray.length; loop++) {
      QueueArray[loop] = new SLinkedQueue();
    }
    for (int time = 1; time <= MAX_TIME; time++) {
      deltaTime++;
      objectQueue.add(exponentialRandom.nextInt());
      if (deltaTime == (int) objectQueue.first()) {
        if (QueueArray[0].size() <= QueueArray[1].size()) {
          System.out.printf("[Time:%d] Service %d arrived. Inserted Queue 0.\n", time,
              objectQueue.first());
          QueueArray[0].add(objectQueue.remove());
        } else {
          System.out.printf("[Time:%d] Service %d arrived. Inserted Queue 1.\n", time,
              objectQueue.first());
          QueueArray[1].add(objectQueue.remove());
        }
        deltaTime = 0;
      }
      if (time % x == 0 || time % x == 1) {
        try {
          System.out.printf("[Time:%d] Service ID : %d removed Queue ID : %d\n", time,
              QueueArray[time % x].remove(), time % x);
        } catch (IllegalStateException e) {
        }
      }
    }
    for (int loop = 0; loop < QueueArray.length; loop++) {
      if (QueueArray[loop].isEmpty()) {
        System.out.printf("Queue %d에 남아 있는 원소가 없습니다.\n", loop);
      } else {
        System.out.printf("Queue %d에 원소가 %d개 남아 있습니다.\n", loop, QueueArray[loop].size());
      }
    }
  }
}
