import java.util.ArrayList;
import java.util.List;

public class StaffManager {
    private List<Staff> staffList = new ArrayList<>();

    public void addStaff(String name, String identityNumber, String phoneNumber, String role, double salary) {
        String id = generateStaffId();
        Staff newStaff = new Staff(id, name, identityNumber, phoneNumber, role, salary);
        staffList.add(newStaff);
        System.out.println("Staff added: " + newStaff);
    }

    public void displayStaff() {
        System.out.println("Registered Staff:");
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
    }

    private String generateStaffId() {
        return "S" + (staffList.size() + 1);
    }
}
