package StudentDatabase;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TopicMatcher {
    public static boolean matchTopic(String topicCodeToMatch, ArrayList<Topic> topicList) {
        Pattern pattern = Pattern.compile(topicCodeToMatch);
        Matcher matcher = null;
        for (Topic t : topicList) {
            matcher = pattern.matcher(t.topicCode);
        }
        assert matcher != null;
        return matcher.find();
    }

    public static ArrayList<MedStudent> returnStudentsMatching(String topicCodeTemplate, ArrayList<Student> studentList) {
        ArrayList<MedStudent> l = new ArrayList<>();
        for (Student s : studentList) {
            if (s.hasMatchingTopics(topicCodeTemplate)) {
                l.add((MedStudent) s);
            }
        }
        return l;
    }

    public static int getAverageGradeForMatchingTopics(String topicCodeTemplate, MedStudent s) {
        ArrayList<Topic> ts = s.returnMatchingTopics(topicCodeTemplate);
        int sum = 0;
        for (Topic t : ts) {
            if (t.mark > 0) {
                sum += t.mark;
            } else {
                sum += t.mapGradeToMark();
            }
        }
        return sum / ts.size();
    }
}
