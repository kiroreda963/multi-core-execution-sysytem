import java.util.PriorityQueue;
import java.util.Comparator;

class ReadyQueue {
    PriorityQueue<PCB> queue;

    public ReadyQueue() {
        queue = new PriorityQueue<>(Comparator.comparingInt(pcb -> pcb.burstTime));
    }

    public void addProcess(PCB pcb) {
        queue.add(pcb);
    }

    public PCB getNextProcess() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        // Use StringBuilder for efficient string concatenation
        StringBuilder sb = new StringBuilder();
        sb.append("ReadyQueue:Processes ID [");

        for (PCB pcb : queue) {
            sb.append(pcb.processID).append(", ");
        }

        // Remove the last ", " if the queue is not empty
        if (!queue.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }

        sb.append("]");
        return sb.toString();
    }
} 
