package Base.Model;

public class Volunteer {
    private int id;
    private String name;
    private int qualification;
    private String admission;

    public Volunteer(){}
    public Volunteer(String name, int qualification, String admission){
        this.name = name;
        this.qualification = qualification;
        this.admission = admission;
    }

    @Override
    public String toString(){
        return id + "." + name + "\nКвалификация: " + qualification + "\nПрисоединился: " + admission  + "\n";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQualification() {
        return qualification;
    }

    public String getAdmission() {
        return admission;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

}
