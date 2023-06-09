package StudentDatabase;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that holds functions for matching Topics.
 * Used to support the awardPrize() functionality.
 */
public class TopicMatcher {
    /**
     * Takes a topicCode template and a topicCode and returns boolean if match is found.
     * @param topicCodeToMatch
     * Template to match the topicCode to.
     * @param topicCode
     * topicCode intended to be pattern matched.
     * @return
     * Returns true if the template is present in the topicCode, returns false if not.
     */
    public static boolean matchTopic(String topicCodeToMatch, String topicCode) {
        Pattern pattern = Pattern.compile(topicCodeToMatch);
        Matcher matcher = pattern.matcher(topicCode);
        return matcher.find();
    }

    /**
     * Returns an ArrayList of MedStudent objects that have topics that match the template.
     * @param topicCodeTemplate
     * Template to match the topicCodes to.
     * @param studentList
     * List of Student objects to search.
     * @return
     * Returns an ArrayList of MedStudent objects that have topics that match the template.
     */
    public static ArrayList<MedStudent> returnStudentsMatching(String topicCodeTemplate, ArrayList<Student> studentList) {
        ArrayList<MedStudent> l = new ArrayList<>();
        for (Student s : studentList) {
            if ((s.hasMatchingTopics(topicCodeTemplate)) && s.isMedStudent()) {
                l.add((MedStudent) s);
            }
        }
        return l;
    }

    /**
     * Returns the average mark for all matching topics in template.
     * @param topicCodeTemplate
     * Template to match the topicCodes to.
     * @param s
     * Student object to get average mark from
     * @return
     * Returns the average mark for all matching topics in template.
     */
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
