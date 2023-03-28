package SpringPart1_23March.Q1;

public class Topic {

    private String topic_name;
    private Subject subject = new Subject();

    public Topic(String topic_name)
    {
        this.topic_name = topic_name;
    }

    public Subject getSubject()
    {
        System.out.println("Topic Name : " + topic_name);
        return subject;
    }
}
