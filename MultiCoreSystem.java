

import java.io.*;
import java.util.*;

public class MultiCoreSystem {

    public static void main(String[] args) {
        ReadyQueue readyQueue = new ReadyQueue();
        Memory memory = new Memory(); // Example memory size

        // Parse the input files
        List<String> instructions1 = parseInstructions("src\\Program_2.txt");
        PCB process1 = new PCB(1, instructions1.size(), 0, instructions1.size() - 1, instructions1);
        readyQueue.addProcess(process1);

       List<String> instructions2 = parseInstructions("src\\Program_3.txt");
        PCB process2 = new PCB(2, instructions2.size(), instructions1.size(), instructions1.size() + instructions2.size() - 1, instructions2);
        readyQueue.addProcess(process2);

        List<String> instructions3 = parseInstructions("src\\Program_1.txt");
        PCB process3 = new PCB(3, instructions3.size(), instructions2.size(), instructions2.size() + instructions3.size() - 1, instructions3);
        readyQueue.addProcess(process3);

        

        
        Core slaveCore1 = new Core(readyQueue, memory);
        Core slaveCore2 = new Core(readyQueue, memory);

        MasterCore.cores.add(slaveCore1);
        MasterCore.cores.add(slaveCore2);
        
        MasterCore.run();
    }

    private static List<String> parseInstructions(String fileName) {
        List<String> instructions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                instructions.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instructions;
    }
}