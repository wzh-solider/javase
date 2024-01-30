public class N10 {

    public static void main(String[] args) {
        Phone phone1 = new Phone("小米", "zt888", "andrior", 2998, 258);

        phone1.shuxing();
        phone1.autodial(110);
        phone1.game("王者");
        phone1.music("绿色");

        Phone phone2 = new Phone("华为", "lh334", "andrior", 1998, 64, 2);
        phone2.shuxing();
        phone2.autodial(119);
        phone2.game("金铲铲");
        phone2.music("红色");
    }
}

class Phone {
    private String brand;
    private String moder;
    private String operatsystem;
    private int price;
    private int memory;
    private int number;

    public Phone() {
    }

    public Phone(String brand, String moder, String operatsystem, int price, int memory) {
        this.brand = brand;
        this.moder = moder;
        this.operatsystem = operatsystem;
        this.price = price;
        this.memory = memory;
    }

    public Phone(String brand, String moder, String operatsystem, int price, int memory, int number) {
        this.brand = brand;
        this.moder = moder;
        this.operatsystem = operatsystem;
        this.price = price;
        this.memory = memory;
        this.number = number;
    }

    public void shuxing() {
        System.out.println("品牌是：" + brand + "型号是：" + moder + "操作系统是：" + operatsystem + "价格是" + price + "内存是" + memory + "序号是" + number);


    }

    public void autodial(int a) {
        System.out.println("自动拨号为" + a);
    }

    public void game(String b) {
        System.out.println("游戏为" + b);
    }

    public void music(String c) {
        System.out.println("音乐为" + c);
    }

}

