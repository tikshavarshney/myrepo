package SpringPart1_23March.Q2_Q3_Q4_Q5_Q6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args)
    {
//        SearchImpl search = new SearchImpl(new QuickSortAlgo());
//        int result = search.searchNumber(new int[]{3, 6, 2, 8}, 2);
//        System.out.println("Result : " + result);


//        // Application Context
//
        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        SearchImpl search = applicationContext.getBean(SearchImpl.class);
        int result = search.searchNumber(new int[]{4, 2, 8, 6}, 3);
        System.out.println("Result : " + result);
    }
}
