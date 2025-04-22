# ***#18 Concurrency***

## ***-> What is concurency?***

- wikipedia definition:
 ``` text
(…) the ability of different parts or units of a program, algorithm, or problem to be
executed out-of-order or in partial order, without affecting the final outcome (…) 
```
- Concurrency is a way to improve the performance of a program by allowing multiple 
tasks to be executed at the same time. This can be especially useful for I/O-bound tasks, 
such as reading and writing files, making network requests, or interacting with databases.

## ***-> Why do we need concurrency?***

- Concurrency is important because it allows us to make better use of system resources,
  improve performance, and create more responsive applications. By allowing multiple tasks 
  to run simultaneously, we can reduce the time it takes to complete a set of tasks and 
  improve the overall user experience.


## ***-> Java Concurrency***

- In Java we have library called Concurrency API since Java 5.
- This API is very complex and consists of many classes. 
- In case of Java we have the term concurrency consists of terms like:
  - Multithreading 
  - Concurrency
  - Parallelism
  
## ***-> What is the difference between thread and the process?***

- most common interview question
- ChatGPT answer: 
```text
 -> process:
    - A process is an independent unit of execution.
    - It has its own memory space, system resources (like file handles, sockets), and at least one thread.
    - One process cannot directly access another process’s memory (needs inter-process communication like sockets or pipes).
    - Think of it as a running program — like when you open Chrome or VS Code, you're starting a new process. 
    - Example: opening two instances of Chrome -> two processes
    
  -> thread:
    - A thread is a smaller unit of execution within a process.
    - All threads in a process share the same memory space and resources.
    - Threads are lighter and faster to create and manage than processes.
    - They are used to perform concurrent operations within a single process — like downloading files in the background while still using the app.
    - Example: two tabs in Chrome -> they run on different threads, each tab have its own thread althought
    they're in the same process (chrome program), share same memory, processor resources etc.
```
- every process on our computer has its own PID (process identifier). When we start a program operating system
will assign resources like RAM memory, processor time, required by the process. 
- When we're running our application through main() method in java we're automatically creating 
one-thread process. We can also create threads for simple part of code in our project - more of that later.
- We can divide process into two groups:
  - single-threaded process
  - multi-threaded process 

## ***-> What concurrency (multi-threading) actually give us?*** 
- **Better usage of acquired resources** - we can make more than one task in the same time - like 
with making a dinner - we can boil a water and cut a vegetables at the same time - we dont need to wait
for the water to boil to cut the vegetables - we can do both at the same time - same with CPU in our cumputer.
We dont need to wait data to be read from disc - we can do other things at this time. 
- **Responsiveness** - like in games - we are not showing the player black screen when loading a location -
instead of we are making some dialogs, or some other cut scenes - like in mass effect games when the player is 
riding the elevator when location is loading from the disc. Same with web application - we are trying to give
our user some interface prompt instead of leaving them with black screen and keep them waiting. 
- **Efficient multi-user support** - we can divide time of the processor for multi-users. This is very useful especially in web applications
where we can have thousands hundred of users using your application and trying to get some info from our app
(for example in banks application when users are trying to get info about their balance).

## ***-> What are disadvantages of concurrency?***
- **context switch** - time needed to switch between one thread to another. Like with making a dinner -
u need some time to switch from cutting vegetables to boiling water. 
- **Complexity** - Writing, understanding, and debugging concurrent programs is much harder than sequential ones.
- **Race Conditions** - Multiple threads or processes accessing shared data can lead to unpredictable results if not handled properly.
- **Deadlocks** - Two or more threads can end up waiting on each other forever, halting progress.
- **Resource Contention** - Threads competing for limited resources (like CPU, memory, or I/O) can lead to inefficiencies or slowdowns.
- **Testing and Debugging Difficulty** - Bugs may not show up consistently due to timing differences, making them hard to reproduce.
- **Overhead** - Context switching between threads and maintaining synchronization mechanisms (like locks) adds overhead.
- **Non-determinism** - The order of execution is often unpredictable, leading to results that vary between runs.

## ***-> Concurrency vs. Parallel execution***

| Feature           | Concurrency                                      | Parallel Execution                                 |
|-------------------|--------------------------------------------------|----------------------------------------------------|
| **Time**          | Overlapping (not necessarily simultaneous)       | Simultaneous (truly at the same time)              |
| **CPU cores**     | One or more                                       | Multiple                                            |
| **Goal**          | Better responsiveness or structure                | Speed up computation                               |
| **Analogy**       | One waiter juggling many tables                   | Multiple waiters serving at once                   |
| **Example tools** | Threads, `ExecutorService`, `CompletableFuture`   | `ForkJoinPool`, parallel streams, multiple threads |
| **Focus**         | Task management                                   | Performance and speed                              |
