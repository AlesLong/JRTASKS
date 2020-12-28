package LearningWithDmitriy;

public class Security extends AbstractEmployer{
    public Security(String name, int salaryPerHour) {
        super(name, "Security", salaryPerHour);
    }

    @Override
    public int salaryPerMonth() {
        return getSalaryPerHour()*12*15;
    }
}
