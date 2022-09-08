

public class DecoratorStudentCoreData extends Decorator {

	protected String id;
    protected String firstName;
    protected String lastName;
    protected String program;
    protected String level;
    protected String asurite;

    public DecoratorStudentCoreData(String id, String firstName, String lastName, String program, String level, String asurite) {
        setID(id);
        setFirstName(firstName);
        setLastName(lastName);
        setProgram(program);
        setLevel(level);
        setAsurite(asurite);
    }

    public void setID(String id) {
        this.id = id;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setAsurite(String asurite) {
        this.asurite = asurite;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getProgram() {
        return this.program;
    }

    @Override
    public String getLevel() {
        return this.level;
    }

    @Override
    public String getAsurite() {
        return this.asurite;
    }

}
