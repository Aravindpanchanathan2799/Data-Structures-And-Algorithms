package alg.analysis.memory;

import alg.analysis.quadratic.TwoSum;
import alg.analysis.cubic.ThreeSum;
import ds.bag.FixedCapacityBag;
import ds.bag.DynamicCapacityBag;
import ds.bag.LinkedListBag;

public class MemoryAnalysis {
    public static void main(String[] args) {
        System.out.println("Memory Analysis - by Your Name");

        int[] testArray = {1, -1, 3, -3, 5, -5, 7, -7}; 
        
        // Measure precise object memory usage
        measureObjectMemory("Task 2: TwoSum", () -> TwoSum.count(testArray));
        measureObjectMemory("Task 3: ThreeSum", () -> ThreeSum.count(testArray));

        measureObjectMemory("Task 4: FixedCapacityBag", () -> {
            FixedCapacityBag<Integer> fixedBag = new FixedCapacityBag<>(100);
            for (int i = 0; i < 100; i++) fixedBag.add(i);
            return fixedBag;
        });

        measureObjectMemory("Task 5: DynamicCapacityBag", () -> {
            DynamicCapacityBag<Long> dynamicBag = new DynamicCapacityBag<>(10);
            for (long i = 0; i < 23; i++) dynamicBag.add(i);
            return dynamicBag;
        });

        measureObjectMemory("Task 6: LinkedListBag", () -> {
            LinkedListBag<String> linkedListBag = new LinkedListBag<>();
            for (int i = 0; i < 17; i++) linkedListBag.add("Element_" + i);
            return linkedListBag;
        });
    }

    private static void measureObjectMemory(String taskName, MeasurableTask task) {
        System.out.println("\n" + taskName + " - Memory Analysis");

        // Run GC before measuring
        Runtime runtime = Runtime.getRuntime();
        for (int i = 0; i < 3; i++) {
            runtime.gc();
            try { Thread.sleep(50); } catch (InterruptedException ignored) {}
        }

        long beforeMemory = runtime.totalMemory() - runtime.freeMemory();
        Object obj = task.execute(); // Execute task
        long afterMemory = runtime.totalMemory() - runtime.freeMemory();
        
        long memoryUsed = afterMemory - beforeMemory;
        System.out.println("Memory Used: " + memoryUsed + " bytes (" + (memoryUsed / 1024.0) + " KB)");
    }

    @FunctionalInterface
    interface MeasurableTask {
        Object execute();
    }
}
