import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Laboratory {
		 
        private SimpleStringProperty lab;
        private SimpleStringProperty faciNo;
        private SimpleStringProperty medicName;
        private SimpleStringProperty staffId;
        private SimpleIntegerProperty cost;
        
        public Laboratory(String i,String f, String m, String s ,String c) {
            this.lab = new SimpleStringProperty(i);
            this.faciNo = new SimpleStringProperty(f);
            this.medicName = new SimpleStringProperty(m);
            this.staffId = new SimpleStringProperty(s);
            this.cost = new SimpleIntegerProperty(Integer.parseInt(c));
        }
 
        public String getLab() {
            return lab.get();
        }
 
        public void setLab(String i) {
        	lab.set(i);
        }
        
        public String getFaciNo() {
            return faciNo.get();
        }
 
        public void setFaciNo(String i) {
        	faciNo.set(i);
        }
        
        public String getMedicName() {
            return medicName.get();
        }
 
        public void setMedicName(String i) {
        	medicName.set(i);
        }
        
        public String getStaffId() {
            return staffId.get();
        }
 
        public void setStaffId(String i) {
        	staffId.set(i);
        }
        
        public int getCost() {
        	return cost.get();
        }
 
        public void setCost(int i) {
        	cost.set(i);
        }
        
        
}