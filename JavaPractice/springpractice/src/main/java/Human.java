public class Human {

    Heart heart;

    Human() {

    }

    void setHeart(Heart heart) {
        System.out.println("Setheart setter is called");
    }

    void checkHuman() {
        if(heart == null) {
            System.out.println("Dead");
        }else{
            heart.pumpHeart();
        }

    }
}
