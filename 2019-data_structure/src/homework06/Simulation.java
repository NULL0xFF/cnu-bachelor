package homework06;

public class Simulation {

  public static void main(String[] args) {
    int mean = 2;
    int x = 6;
    int deltaTime = 0;
    int MAX_TIME = 100;
    int id = 1;
    DLinkedQueue[] linkedQueue = new DLinkedQueue[2];
    linkedQueue[0] = new DLinkedQueue();
    linkedQueue[1] = new DLinkedQueue();
    ExponentialRandom eRandom = new ExponentialRandom(mean);
    int eRandObject = eRandom.nextInt();
    for (int time = 1; time < MAX_TIME; time++) {
      deltaTime++;
      if (deltaTime == eRandObject) {
        if (linkedQueue[0].size() <= linkedQueue[1].size()) {
          System.out.printf("[Time:%d] Service %d arrived. Inserted Queue 0.\n", time, id);
          linkedQueue[0].add(id);
        } else {
          System.out.printf("[Time:%d] Service %d arrived. Inserted Queue 1.\n", time, id);
          linkedQueue[1].add(id);
        }
        deltaTime = 0;
        id++;
        eRandObject = eRandom.nextInt();
      }
      if ((time % x == 0) || (time % x == 1)) {
        try {
          System.out.printf("[Time:%d] Service ID : %d removed Queue ID : %d\n", time,
              linkedQueue[time % x].remove(), time % x);
        } catch (IllegalStateException e) {
        }
      }
    }
    for (int loop = 0; loop < linkedQueue.length; loop++) {
      if (linkedQueue[loop].empty()) {
        System.out.printf("Queue %d에 남아 있는 원소가 없습니다.\n", loop);
      } else {
        System.out.printf("Queue %d에 원소가 %d개 남아 있습니다.\n", loop, linkedQueue[loop].size());
      }
    }
  }
}
