import java.util.Map;

public class RepositoryStudentIterator implements RepositoryIterator {

    private int index;
    private Map<String, Decorator> studentList;

    public RepositoryStudentIterator(Map<String, Decorator> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean hasNext() {
        if (index < studentList.keySet().toArray().length) {
            return true;
        }
        return false;
    }

    @Override
    public Decorator next() {
        Object key = studentList.keySet().toArray()[index++];
        if (!this.hasNext() && key == null) {
            return null;
        }
        return studentList.get(key);
    }
}
