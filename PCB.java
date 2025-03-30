import java.util.List;

class PCB implements Comparable<PCB>{
    int processID;
    int programCounter;
    int memoryStart;
    int memoryEnd;
    int burstTime; // Number of instructions
    List<String> instructions;

    public PCB(int processID, int burstTime, int memoryStart, int memoryEnd, List<String> instructions) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.memoryStart = memoryStart;
        this.memoryEnd = memoryEnd;
        this.programCounter = memoryStart;
        this.instructions = instructions;
    }

    @Override
    public int compareTo(PCB o) {
        return this.burstTime-o.burstTime;
    }
}