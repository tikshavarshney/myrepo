package SpringPart1_23March.Q2_Q3_Q4_Q5_Q6;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSortAlgo implements SortAlgo {

    public String getAlgoName()
    {
        return "Using Quick Algorithm";
    }
    public int[] sort(int[] numbers)
    {
        return numbers;
    }
}
