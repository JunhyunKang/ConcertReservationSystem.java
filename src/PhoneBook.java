import java.util.Scanner;

class Phone{
    private String name, phoneNumber;
    Phone(String name, String phoneNumber){
        this.name=name;
        this.phoneNumber=phoneNumber;
    }

    String getName() {
        return name;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }
}


public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("인원수>>");
        int manyPeople = scanner.nextInt();
        Phone[] array = new Phone[manyPeople];
        for(int i=0;i<manyPeople;i++)
        {
            System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>");
            String name = scanner.next();
            String phoneNumber = scanner.next();
            array[i]=new Phone(name, phoneNumber);
        }
        System.out.println("저장되었습니다...");
        while(true)
        {
            System.out.print("검색할 이름>>");
            String name = scanner.next();
            if(name.equals("그만"))
                break;
            int i;
            for (i = 0; i < manyPeople; i++)
            {
                if (name.equals(array[i].getName()))
                {
                    System.out.println(name + "의 번호는 " + array[i].getPhoneNumber() + " 입니다.");
                    break;
                }
            }
            if(i==manyPeople)
                System.out.println(name+" 이 없습니다.");
        }
        scanner.close();
    }
}
