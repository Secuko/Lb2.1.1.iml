package Base;
import Base.DAO.*;
import Base.Model.Volunteer;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        Dao.initConn();
        Volunteer volunteer1 = new Volunteer("Сердюхин Иван", 2, "2020-12-12");
        VolunteerDAO.insert(volunteer1);
        ArrayList volunteers = VolunteerDAO.getAllVolunteers();
        VolunteerDAO.update((Volunteer) volunteers.get(2));
        System.out.println(VolunteerDAO.getVolunteer(1));

        for (int i = 0; i < volunteers.size(); i++) {
            System.out.println(volunteers.get(i));
        }

        VolunteerDAO.delete((Volunteer)volunteers.get(2));

       for (int i = 0; i < volunteers.size(); i++) {
            System.out.println(volunteers.get(i));
        }
    }
}
