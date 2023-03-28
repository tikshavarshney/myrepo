package SpringPart1_23March.Q2_Q3_Q4_Q5_Q6;

import org.springframework.stereotype.Component;

@Component
public class MergeSortAlgo implements SortAlgo{

    public String getAlgoName()
    {
        return "Using Merge Algorithm";
    }
    public int[] sort(int[] numbers)
    {
        return numbers;
    }
}
