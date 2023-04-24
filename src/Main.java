import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    // Khai báo một mảng users để lưu danh sách người dùng
    private static final User[] users = new User[10];
    // Khai báo biến userIndex để lưu vị trí của người dùng đang đăng nhập
    private static int userIndex = -1;
    public static void main(String[] args) {
        // Khởi tạo danh sách người dùng
        users[0] = new User("user1", "pass1", 1000);
        users[1] = new User("user2", "pass2", 2000);
        users[2] = new User("user3", "pass3", 3000);

        // Yêu cầu người dùng nhập username và password để đăng nhập
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Hoang's Bank");
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();

        // Kiểm tra xem username và password có hợp lệ không
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(username) && users[i].getPassword().equals(password)) {
                userIndex = i;
                break;
            }
        }

        // Nếu username và password không hợp lệ, thông báo lỗi và kết thúc chương trình
        if (userIndex == -1) {
            System.out.println("Invalid username or password.");
            return;
        }

        // Hiển thị các tùy chọn cho người dùng
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Check balance");
            System.out.println("3. Exit");

            // Yêu cầu người dùng nhập tùy chọn
            int option = sc.nextInt();

            // Thực hiện các chức năng tương ứng với tùy chọn người dùng
            switch (option) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    checkBalance();
                    break;
                case 3:
                    System.out.println("Thank you for using our service!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }

    // Chức năng rút tiền
    private static void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to withdraw: $");
        int amount = sc.nextInt();
        if (amount > users[userIndex].getAmount()) {
            System.out.println("Can not withdraw.");
        } else {
            users[userIndex].setAmount(users[userIndex].getAmount() - amount);
            System.out.println("Transaction successful.");
        }
    }

    // Chức năng kiểm tra số dư tài khoản
    private static void checkBalance() {
        System.out.println("Your balance is $" + users[userIndex].getAmount() + ".");
    }
}