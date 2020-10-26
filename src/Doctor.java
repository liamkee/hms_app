import javafx.beans.property.SimpleStringProperty;

public class Doctor {
		 
        private SimpleStringProperty iD;
        private SimpleStringProperty lastName;
        private SimpleStringProperty specialist;
        private SimpleStringProperty timing;
        private SimpleStringProperty qualification;
        
        public Doctor(String i, String lName, String spe, String time, String qual) {
            this.iD = new SimpleStringProperty(i);
            this.lastName = new SimpleStringProperty(lName);
            this.specialist = new SimpleStringProperty(spe);
            this.timing = new SimpleStringProperty(time);
            this.qualification = new SimpleStringProperty(qual);
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
 
        public void setLastName(String fName) {
            lastName.set(fName);
        }
 
        public String getSpecialist() {
            return specialist.get();
        }
 
        public void setSpecialist(String fName) {
        	specialist.set(fName);
        }
        public String getTiming() {
            return timing.get();
        }
 
        public void setTiming(String fName) {
        	timing.set(fName);
        }
        public String getQualification() {
            return qualification.get();
        }
 
        public void setQualification(String fName) {
        	qualification.set(fName);
        }
    }