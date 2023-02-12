public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Please register!");
        System.out.print("Login: ");
        String login = scanner.nextLine();
        String password;
        while (true) {
            System.out.print("Password: ");
            password = scanner.nextLine();
            if (password.length() >= 8 && hasNumber(password) && hasCapital(password) && hasSymbol(password)) {
                break;
            }
            System.out.println("Password must be at least 8 characters long, contain at least one number, one capital letter, and one symbol.");
        }
        System.out.println("Thank you for registering, " + login + "!");
    }
