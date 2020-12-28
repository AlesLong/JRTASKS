package LearningWithDmitriy;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<AbstractEmployer> employers = new ArrayList<>();
        employers.add(new Driver("Dima",10));
        employers.add(new Driver("Denis",5));
        employers.add(new Security("Zhenya",100));
        employers.add(new Security("Roma",111));
        employers.add(new TraineeDriver("Kostya",5));
        employers.add(new TraineeDriver("Dzyu",15));
        for (int i = 0; i < employers.size(); i++) {
            AbstractEmployer x = employers.get(i);
            System.out.println("Работник "+x.getName()+" работает "+x.getProf()+" получает зарплату "+x.salaryPerMonth());
        }
    }
}
