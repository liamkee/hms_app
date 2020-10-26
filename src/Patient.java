import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Patient {
		private SimpleStringProperty iD;
		private SimpleStringProperty lastName;
		private SimpleStringProperty disease;
		private SimpleStringProperty sex;
		private SimpleStringProperty admitStatus;
		
		private SimpleIntegerProperty age;
        
        public Patient(String i,String n, String d, String s, String ad, String a) {
            this.iD = new SimpleStringProperty(i);
            this.lastName = new SimpleStringProperty(n);
            this.disease = new SimpleStringProperty(d);
            this.sex = new SimpleStringProperty(s);
            this.admitStatus = new SimpleStringProperty(ad);
            this.age = new SimpleIntegerProperty(Integer.parseInt(a));
        }
 
        public String getID() {
            return iD.get();
        }
 
        public void setID(String i) {
        	iD.set(i);
        }
        
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String n) {
        	lastName.set(n);
        }
        
        public String getDisease() {
            return disease.get();
        }
 
        public void setDisease(String d) {
        	disease.set(d);
        }
        
        public String getSex() {
            return sex.get();
        }
 
        public void setSex(String s) {
        	sex.set(s);
        }
        
        public String getAdmitStatus() {
            return admitStatus.get();
        }
 
        public void setAdmitStatus(String ad) {
        	admitStatus.set(ad);
        } 
        
        public int getAge() {
            return age.get();
        }
 
        public void setAge(int a) {
        	age.set(a);
        }
}