import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        int i = 10;
        int temp = i;
        i++;
        i = temp;
        System.out.println(i);
    }
}