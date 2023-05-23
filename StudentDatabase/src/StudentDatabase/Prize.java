package StudentDatabase;

public class Prize {
    protected String prizeName;
    protected StringBuilder topicCode = new StringBuilder(8);
    protected int min;

    public Prize(
            String newPrizeName,
            String newTopicCode,
            int newMin) {

        this.prizeName = newPrizeName;
        this.topicCode.append(newTopicCode);
        this.min = newMin;
    }
}
