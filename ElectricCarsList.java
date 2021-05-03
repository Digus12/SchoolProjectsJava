//____________________________________ ElectricCarsList.java _________________________

import java.util.ArrayList;
import java.util.Iterator;

public class ElectricCarsList {
    ArrayList<String> carModels = new ArrayList<>();
    ArrayList<ElectricCar> carList = new ArrayList<>();

    public static void main(String[] args){
        ElectricCarsList cars = new ElectricCarsList();
        cars.addCars();
        cars.printList();
    }

    private void printList() {
        Iterator<ElectricCar> itr = carList.iterator();
        System.out.println("========================================> Electric Cars List <========================================");
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("======================================================================================================");
    }

    public void addCars() {
        carList.add(new ElectricCar("2020 Tesla Model S", 74990, 402, 9.0,1));
        carList.add(new ElectricCar("Audi Q7 2020", 40990, 356, 8.0,1));
        carList.add(new ElectricCar("Toyota Yaris 2021", 24990, 202, 9.0,2));
        carList.add(new ElectricCar("Mahindra XUV500 2021", 30990, 256, 8.0,2));
        carList.add(new ElectricCar("Mahindra eKUV100", 14990, 302, 9.0,2));
        carList.add(new ElectricCar("Hyundai I20 Next-Gen", 21990, 306, 8.0,3));
    }
    class ElectricCar {
        String modelName;
        double mfgPrice;
        int maxRange;
        double usNewsRating;  // 1.0-10.0
        int rank;

        public ElectricCar(String modelName, double mfgPrice, int maxRange, double usNewsRating, int rank) {
            this.modelName = modelName;
            this.mfgPrice = mfgPrice;
            this.maxRange = maxRange;
            this.usNewsRating = usNewsRating;
            this.rank = rank;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public double getMfgPrice() {
            return mfgPrice;
        }

        public void setMfgPrice(double mfgPrice) {
            this.mfgPrice = mfgPrice;
        }

        public int getMaxRange() {
            return maxRange;
        }

        public void setMaxRange(int maxRange) {
            this.maxRange = maxRange;
        }

        public double getUsNewsRating() {
            return usNewsRating;
        }

        public void setUsNewsRating(double usNewsRating) {
            this.usNewsRating = usNewsRating;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        @Override
        public String toString() {
            return String.format("[ Model: %-30s MfgPrice:'%.2f', MaxRange:'%-4d', Rating:'%.1f', Rank:'%d']",modelName,mfgPrice,maxRange,usNewsRating,rank);
        }
    }
}
