import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestBasic_01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //TODO:
        //1) task_AB_147_B_1 and task_AB_147_B_2 should be executed in parallel
        //2) Task_AB executor should be implemented in the way that allows
        //to catch exception during execution as well as get the result only when specific task is finished.
        //3) elements passed to any executor should not be modified during execution of any task.
        //4) task_AB_155_C_1 and task_AB_155_C_2 should be executed in parallel

        List<Integer> elements = IntStream.range(0, 100_000)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        Task_AB<Long> task_AB_147_B_1 = new Task_AB<>(elements, TestBasic_01::AB_147_B_1);
        Task_AB<Long> task_AB_147_B_2 = new Task_AB<>(elements, TestBasic_01::AB_147_B_2);

        ExecutorService executors = Executors.newFixedThreadPool(2);

            Future<Long> longFuture = executors.submit(task_AB_147_B_1);
            Future<Long> longFuture2 = executors.submit(task_AB_147_B_2);

       executors.shutdown();


//        task_AB_147_B_1.run();
//        task_AB_147_B_2.run();


        //if (task_AB_147_B_1.getResult() + task_AB_147_B_2.getResult() == elements.size()) {
        if (longFuture.get(1,TimeUnit.SECONDS) + longFuture2.get(1,TimeUnit.SECONDS) == elements.size()) {
            System.out.println("ALL OK");
        } else {
            System.out.println("ERROR");
        }

        ExecutorService executors1 = Executors.newFixedThreadPool(2);
        Task_AB<List<Integer>> task_AB_155_C_1 = new Task_AB<>(elements, TestBasic_01::AB_155_C_1);
        Task_AB<List<Integer>> task_AB_155_C_2 = new Task_AB<>(elements, TestBasic_01::AB_155_C_2);

        executors1.submit(task_AB_155_C_1);
        executors1.submit(task_AB_155_C_2);

        executors1.shutdown();

        //TODO: verify if result of the task doesn't change input list.


    }

    static class Task_AB<R> implements Callable<R> {
        private final List<Integer> elements;
        private final Function<List<Integer>, R> function;

        public Task_AB(List<Integer> elements, Function<List<Integer>, R> function) {
            this.elements = elements;
            this.function = function;
        }

        private R result;

        public R getResult() {
            return result;
        }

        @Override
        public R call() throws Exception {
            return function.apply(elements);
        }
    }

    //----- CANNOT MODIFY CODE BELOW -------
    private static long AB_147_B_1(List<Integer> elements) {
        return elements.stream().parallel().filter(e -> e % 2 == 0).count();
    }

    private static long AB_147_B_2(List<Integer> elements) {
        return elements.stream().parallel().filter(e -> e % 2 == 1).count();
    }

    private static List<Integer> AB_155_C_1(List<Integer> elements) {
        elements.add(-1);
        elements.add(-2);
        return elements;
    }

    private static List<Integer> AB_155_C_2(List<Integer> elements) {
        elements.add(-10);
        elements.add(-20);
        return elements;
    }
}

