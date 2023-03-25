public class TJStudent {
    private String name="TJ Student";
    private String year="Freshman";
    private int age=14;
    public TJStudent() {

    }
    public TJStudent(String _name, String _year, int _age) {
        setName(_name);
        setYear(_year);
        setAge(_age);
    }
    public String getName() {
        return name;
    }
    public String getYear() {
        return year;
    }
    public int getAge() {
        return age;
    }
    public void setName(String _name) {
        name=_name;
    }
    public void setYear(String _year) {
        if (_year.equals("Freshman") || _year.equals("Sophomore") || _year.equals("Junior") || _year.equals("Senior")) {
            year=_year;
        }
        else {
            System.out.println("Error: "+_year+" is not a valid year.");
        }
    }
    public void setAge(int _age) {
        if (_age>=10 && _age<=20) {
         age=_age;
        }
        else {
            System.out.println("Error: "+_age+" is not a valid age.");
        }
    }
    public boolean sameAge(TJStudent a) {
        return a.getAge()==age;
    }
    public boolean sameYear(TJStudent a) {
        return a.getYear().equals(year);
    }
    public void summarize() {
        System.out.println(name+" is a "+age+" year-old "+year+".");
    }
}