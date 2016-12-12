package org.davidd.onNov28;

import org.junit.Before;
import org.junit.Test;

import java.util.Spliterator;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.Consumer;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Dec12 {

    int n;

    @Before
    public void b() {
        n = 500000;
    }

    @Test
    public void noStream() {
        long now = System.currentTimeMillis();

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }

        System.out.println(sum);
        System.out.println((System.currentTimeMillis() - now));
    }

    @Test
    public void reduce() {
        long now = System.currentTimeMillis();

        long sum = Stream.iterate(0, i -> i + 1).limit(n).reduce(0, Integer::sum);

        System.out.println(sum);
        System.out.println((System.currentTimeMillis() - now));
    }

    @Test
    public void parallelReduce() {
        long now = System.currentTimeMillis();

        long sum = Stream.iterate(0, i -> i + 1).parallel().limit(n).reduce(0, Integer::sum);

        System.out.println(sum);
        System.out.println((System.currentTimeMillis() - now));
    }

    @Test
    public void range() {
        long now = System.currentTimeMillis();

        long sum = LongStream.range(0, n).sum();

        System.out.println(sum);
        System.out.println((System.currentTimeMillis() - now));
    }



    // Fork and join



    static class RTask extends RecursiveTask {

        int start, end;

        public RTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Object compute() {
            if (canSplit()) {

            } else {

            }

            return null;
        }

        private boolean canSplit() {
            return true;
        }
    }

    @Test
    public void rtask() {
        ForkJoinPool pool = new ForkJoinPool();
        RTask rTask1 = new RTask(0, n);

        pool.invoke(rTask1);
    }



    // Spliterator



    static class SIterator implements Spliterator<Integer> {

        int start, end;

        public SIterator(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean tryAdvance(Consumer<? super Integer> action) {
            return false;
        }

        @Override
        public Spliterator<Integer> trySplit() {
            if (canSplit()) {
                int mid = (start + end) / 2;
                return new SIterator(mid, end);
            } else {
                return null;
            }
        }

        @Override
        public long estimateSize() {
            return 0;
        }

        @Override
        public int characteristics() {
            return 0;
        }

        private boolean canSplit() {
            return (end - start) > 10_000;
        }
    }

    @Test
    public void spliterator() {
        ForkJoinPool pool = new ForkJoinPool();
        RTask rTask1 = new RTask(0, n);

        pool.invoke(rTask1);
    }
}
