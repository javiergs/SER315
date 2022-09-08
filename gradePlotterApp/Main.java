
public class Main {

    public static void main(String[] args) {
        Repository repository11 = Repository.getInstance();
        Grader grader13 = new Grader(repository11);
        Reporter reporter14 = new Reporter(repository11);
        ObserverTable observerTable15 = new ObserverTable(repository11);
        ObserverPlotter observerPlotter16 = new ObserverPlotter(repository11);

        repository11.addObserver(observerTable15);
        repository11.addObserver(observerPlotter16);

        MainUI main17UI = new MainUI(observerTable15, observerPlotter16);
        new MainController(repository11, grader13, reporter14, main17UI);
    }

}

