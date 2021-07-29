import java.util.InputMismatchException;
import java.util.Scanner;

class Information{
    private char typeOfSeat;
    private int number;
    private String[] seat={"---","---","---","---","---","---","---","---","---","---"};

    Information(char typeOfSeat){
        this.typeOfSeat=typeOfSeat;
    }

    void reserve(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름>>");
        String name = scanner.nextLine();
        System.out.print("번호>>");
        int seatNum;
        try {
            seatNum = scanner.nextInt();
            if(!seat[seatNum-1].equals("---"))
            {
                System.out.println("이미 예약된 좌석입니다.");
                return;
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("번호를 입력해주세요.");
            return;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("올바른 좌석번호를 입력해주세요");
            return;
        }
        seat[seatNum-1]=name;
    }

    void showSeat(){
        String show="";
        for(int i=0;i< seat.length;i++)
        {
            show = show+seat[i]+" ";
        }
        System.out.println(typeOfSeat+">> "+show);
    }

    void cancel(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름>>");
        String name = scanner.nextLine();
        for(int i=0;i< seat.length;i++)
        {
            if(name.equals(seat[i]))
            {
                seat[i]="---";
                return;
            }
        }
        System.out.println("없는 이름입니다.");
        return;
    }
}

public class ConcertReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Information s=new Information('S') , a=new Information('A'), b=new Information('B');
        System.out.println("명품콘서트홀 예약 시스템입니다.");
        OUTER: while (true)
        {
            scanner.reset();
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
            int choice;
            //String q = scanner.next();
            try {
                choice = scanner.nextInt();

            }
            catch (InputMismatchException e)
            {
                System.out.println("잘못된 입력입니다. 종료합니다.");
                break;
            }
            switch (choice)
            {

                case 1:
                    System.out.print("좌석구분 S(1), A(2), B(3)>>");
                    int typeOfSeat;
                    try
                    {
                        typeOfSeat = scanner.nextInt();

                    }
                    catch (InputMismatchException e)
                    {
                        scanner.nextLine();
                        System.out.println("잘못된 입력입니다.");
                        break;
                    }

                    if(typeOfSeat==1)
                    {
                        s.showSeat();
                        s.reserve();
                        break;
                    }
                    else if(typeOfSeat==2)
                    {
                        a.showSeat();
                        a.reserve();
                        break;
                    }
                    else if(typeOfSeat==3)
                    {
                        b.showSeat();
                        b.reserve();
                        break;
                    }
                    else
                    {
                        System.out.println("번호를 잘못 입력하셨습니다. 처음부터 다시 시도해주세요.");
                        break;
                    }
                case 2:
                    s.showSeat();
                    a.showSeat();
                    b.showSeat();
                    System.out.println("<<<조회를 완료하였습니다.>>>");
                    break;
                case 3:
                    System.out.print("좌석 S:1, A:2, B:3>>");
                    int seatType;
                    try
                    {
                        seatType = scanner.nextInt();
                    }
                    catch (InputMismatchException e2)
                    {
                        scanner.nextLine();
                        System.out.println("잘못된 입력입니다.");
                        break;
                    }

                    if(seatType==1)
                    {
                        s.showSeat();
                        s.cancel();
                        break;
                    }
                    else if(seatType==2)
                    {
                        a.showSeat();
                        a.cancel();
                        break;
                    }
                    else if(seatType==3)
                    {
                        b.showSeat();
                        b.cancel();
                        break;
                    }
                    else
                    {
                        System.out.println("번호를 잘못 입력하셨습니다. 처음부터 다시 시도해주세요.");
                        break;
                    }
                case 4:
                    break OUTER;
                default:
                    System.out.println("처음부터 다시 시도해주세요.");
            }
        }
        scanner.close();
    }
}
