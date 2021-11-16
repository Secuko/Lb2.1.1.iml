package Base.DAO;
import Base.Model.Volunteer;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class VolunteerDAO {
    public static Volunteer getVolunteer(int id) {
        Volunteer volunteer = new Volunteer();
        try (Connection conn = Dao.getConn()) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Volunteer WHERE Id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                volunteer.setId(resultSet.getInt("Id"));
                volunteer.setName(resultSet.getString("name"));
                volunteer.setQualification(resultSet.getInt("qualification"));
                volunteer.setAdmission(resultSet.getString("admission"));
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return volunteer;
    }

    public static ArrayList<Volunteer> getAllVolunteers() {
        ArrayList<Volunteer> Volunteers = new ArrayList<Volunteer>();
        try (Connection conn = Dao.getConn()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Volunteer");
            while (resultSet.next()) {
                Volunteer volunteer = new Volunteer();
                volunteer.setId(resultSet.getInt("Id"));
                volunteer.setName(resultSet.getString("name"));
                volunteer.setQualification(resultSet.getInt("qualification"));
                volunteer.setAdmission(resultSet.getString("admission"));
                Volunteers.add(volunteer);
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Volunteers;
    }

    public static void update(Volunteer volunteer) {
        try (Connection conn = Dao.getConn()) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE Volunteer SET Name = ?, Qualification = ?, Admission = ? WHERE id = ?");
            Scanner in = new Scanner(System.in);
            preparedStatement.setInt(4, volunteer.getId());
            preparedStatement.setString(1, in.nextLine());
            preparedStatement.setInt(2, in.nextInt());
            in.nextLine();
            preparedStatement.setString(3, in.nextLine());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void delete(Volunteer volunteer) {
        try (Connection conn = Dao.getConn()) {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Volunteer WHERE id = ?");
            preparedStatement.setInt(1, volunteer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void insert(Volunteer volunteer) {
        try (Connection conn = Dao.getConn()) {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Volunteer (Name, Qualification, Admission) Values (?, ?, ?)");
            preparedStatement.setString(1, volunteer.getName());
            preparedStatement.setInt(2, volunteer.getQualification());
            preparedStatement.setString(3, volunteer.getAdmission());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
