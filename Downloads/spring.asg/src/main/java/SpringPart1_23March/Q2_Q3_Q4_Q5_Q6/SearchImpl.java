package SpringPart1_23March.Q2_Q3_Q4_Q5_Q6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchImpl {

    @Autowired
    private SortAlgo sortAlgo;

    public SearchImpl(SortAlgo sortAlgo)
    {
        super();
        this.sortAlgo = sortAlgo;
    }

    public int searchNumber(int[] numbers, int num)
    {
        sortAlgo.sort(new int[]{3, 7, 1, 9});
        System.out.println(sortAlgo.getAlgoName());
        return 1;
    }
}
