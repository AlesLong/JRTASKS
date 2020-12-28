package LearningWithDmitriy;

public abstract class AbstractEmployer {
    private String name;
    private String prof;
    private int salaryPerHour;

    public AbstractEmployer(String name, String prof, int salaryPerHour) {
        this.name = name;
        this.prof = prof;
        this.salaryPerHour = salaryPerHour;
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public String getName() {
        return name;
    }

    public String getProf() {
        return prof;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public int salaryPerMonth() {
        return salaryPerHour * 8 * 21;
    }
}

