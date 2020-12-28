package LearningWithDmitriy;

public class TraineeDriver extends Driver {
    public TraineeDriver(String name, int salaryPerHour) {
        super(name, salaryPerHour);
    }

    @Override
    public int salaryPerMonth() {
        return super.salaryPerMonth() / 2;
    }
}
