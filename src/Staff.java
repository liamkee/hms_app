import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Staff {
		private SimpleStringProperty id;
		private SimpleStringProperty name;
		private SimpleStringProperty designation;
		private SimpleStringProperty sex;
		
		private SimpleIntegerProperty salary;
        
        public Staff(String i,String n, String d, String s, String sal) {
            this.id = new SimpleStringProperty(i);
            this.name = new SimpleStringProperty(n);
            this.designation = new SimpleStringProperty(d);
            this.sex = new SimpleStringProperty(s);
            this.salary = new SimpleIntegerProperty(Integer.parseInt(sal));
        }
 
        public String getId() {
            return id.get();
        }
 
        public void setId(String i) {
        	id.set(i);
        }
        
        public String getName() {
            return name.get();
        }
 
        public void setName(String n) {
        	name.set(n);
        }
        
        public String getDesignation() {
            return designation.get();
        }
 
        public void setDesignation(String d) {
        	designation.set(d);
        }
        
        public String getSex() {
            return sex.get();
        }
 
        public void setSex(String s) {
        	sex.set(s);
        }
        
        public int getSalary() {
            return salary.get();
        }
 
        public void setSalary(int sal) {
        	salary.set(sal);
        }
}