import java.util.Scanner;

class Core extends Thread {
    private final ReadyQueue readyQueue;
    private final Memory memory;
    private PCB currentProcess;

    public Core(ReadyQueue readyQueue, Memory memory) {
        this.readyQueue = readyQueue;
        this.memory = memory;
    }

    @Override
    public void run() {
        while (true) {
            if (currentProcess == null && !readyQueue.isEmpty()) {
                currentProcess = readyQueue.getNextProcess();
            }


            if (currentProcess != null) {
                clockCycleStatus();
                executeInstruction();
                if (currentProcess.programCounter > currentProcess.memoryEnd) {
                    System.out.println("Process " + currentProcess.processID + " completed.");
                    currentProcess = null;
                }
            }
        }
    }
   private void clockCycleStatus(){
    System.out.println("Ready Queue status"+ readyQueue.toString());
    
    System.out.println(memory.toString());
   }
    private void executeInstruction() {
        if (currentProcess.programCounter <= currentProcess.memoryEnd) {
            String instruction = currentProcess.instructions.get(currentProcess.programCounter- currentProcess.memoryStart);
            String[] parts = instruction.split(" ");
            switch (parts[0]) {
                case "assign":
                    if (parts[2].equals("input")) {
                        // Simulate user input
                        System.out.println("Process: "+currentProcess.processID+" "+"Enter value for " + parts[1] + ": ");
                        Scanner scanner = new Scanner(System.in);
                        if (scanner.hasNextInt()) {
                            int value = scanner.nextInt();
                            memory.set(parts[1], value);
                        } else {
                            System.out.println("Process: "+currentProcess.processID+" "+"Invalid input. Please enter an integer.");
                        }//TODO assign immeadiate
                        
                    } else {
                        if(Character.isDigit(parts[2].charAt(0)))
                        {
                            memory.set(parts[1], Integer.parseInt(parts[2]));
                            break;
                        }    
                        switch (parts[2]) {
                            case "add":
                                
                                 memory.set(parts[1], memory.get(parts[3]) + memory.get(parts[4]));
                            break;
                            case "subtract":
                                memory.set(parts[1], memory.get(parts[3]) - memory.get(parts[4]));
                            break;
                            case "multiply":
                                memory.set(parts[1], memory.get(parts[3]) * memory.get(parts[4]));
                            break;
                            case "divide":
                                memory.set(parts[1], memory.get(parts[3]) / memory.get(parts[4]));
                            break;
                            
                        }
                    }
                    break;
                
                case "print":
                    System.out.println("Process: "+currentProcess.processID+" "+parts[1] + " = " + memory.get(parts[1]));break;
                default:
                    System.out.println("Unknown instruction: " + instruction);break;
            }
            currentProcess.programCounter++;
        }
    }
   
}