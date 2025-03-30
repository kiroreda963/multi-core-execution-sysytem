# Multi-Core Execution System (Master-Slave Architecture)



### Project Overview
This project implements a multi-core execution system with a master-slave architecture using Java. One core acts as the master, managing execution and delegating tasks to two slave cores, which process tasks concurrently. The system executes programs consisting of variable assignments, arithmetic operations, and print commands, with each instruction executed in a single clock cycle.

### Features Implemented
- **Ready Queue**: Manages processes waiting for execution.
- **Shared Memory**: Stores program variables and data accessible by all cores.
- **Process Control Block (PCB)**: Maintains metadata for each process (Process ID, Program Counter, Memory Boundaries).
- **Master-Slave Execution**: The master core schedules and assigns tasks to the two slave cores.
- **Scheduling Algorithms**:
  - **Round Robin (RR)**: Allocates time slices of 2 (quantum=2) to each process.
  - **Shortest Job First (SJF)**: Allocates the shortest process first.
- **Thread-based Execution**: Uses `extends Thread` to enable concurrent execution of tasks.
- **Execution Monitoring**:
  - Tracks and displays the executing process on each core.
  - Maintains logs of process completion times.

---

## Project Components

### 1. **Initialization**
- Implements a ready queue.
- Allocates shared memory for program variables and data.

### 2. **Parsing Programs**
- Reads input files.
- Categorizes instructions into variable assignments, arithmetic operations, and print commands.

### 3. **Operations**
- Handles variable assignments and arithmetic operations (addition, subtraction, multiplication, division).
- Ensures thread-safe execution of print commands.

### 4. **Scheduling Algorithms**
- Implements both **Round Robin** and **Shortest Job First** scheduling.
- Defines criteria for process selection and execution order.

### 5. **Execution Control**
- Delegates tasks from the master to slave cores.
- Tracks currently executing processes and logs memory states.
- Updates system status at each clock cycle.

### 6. **Testing & Debugging**
- Tests with multiple input files.
- Ensures robustness and proper error handling.

---

## Expected Outputs
1. **Ready Queue State**: Displays the queue at each cycle.
2. **Processor Status**: Indicates the process running on each core.
3. **Memory State**: Lists current variable values after each operation.

---

## Evaluation Criteria
- **Correctness**: Operations execute correctly, maintaining accurate values.
- **Scheduling Performance**: RR rotates processes correctly; SJF prioritizes shortest jobs.
- **Execution Monitoring**: Displays running processes and logs process completion.
- **Error Handling**: Ensures stability with various inputs and edge cases.
- **Debugging & Optimization**: Ensures smooth execution and resolves logical errors.

---

## How to Run the Project
1. Compile all `.java` files:
   ```bash
   javac *.java
   ```
2. Run the main program:
   ```bash
   java Main
   ```
3. Provide input program files as needed.
4. Monitor console output for execution status.




