package StudentDatabase;

public class Prize {
    // Variables
    protected String prizeName;
    protected StringBuilder topicCodeTemplate = new StringBuilder(8);
    protected int min;

    // Constructor
    public Prize(
            String newPrizeName,
            String newTopicCode,
            int newMin) {

        this.prizeName = newPrizeName;
        this.topicCodeTemplate.append(newTopicCode);
        this.min = newMin;
    }

    // Class functions
    public void printPrize() {
        System.out.println("Prize: " + this.prizeName +
                "\nTopic Template: " + this.topicCodeTemplate +
                "\nMin: " + this.min);
    }

    // Getters/Setters

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public StringBuilder getTopicCodeTemplate() {
        return topicCodeTemplate;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
