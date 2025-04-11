package src.model;

public class StatisticSummary {
    private long count;
    private int sum;
    private int min;
    private int max;

    public StatisticSummary() {
        this.count = 0;
        this.sum = 0;
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
    }

    public void accept(int value) {
        count++;
        sum += value;
        min = Math.min(min, value);
        max = Math.max(max, value);
    }

    public void combine(StatisticSummary other) {
        this.count += other.count;
        this.sum += other.sum;
        this.max = Math.max(this.max, other.max);
        this.min = Math.min(this.min, other.min);
    }

    @Override
    public String toString() {
        return "src.model.StatisticSummary{" +
                "count=" + count +
                ", sum=" + sum +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}