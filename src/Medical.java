
/*public class Medical {
	public void findMedical() {
		System.out.println(name+"      "+manufacturer+"      "+expiryDate+"      "+cost+"      "+count);		
	}
}*/

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Medical {
		private SimpleStringProperty name;
		private SimpleStringProperty manufacturer;
		private SimpleStringProperty expiryDate;
		
		private SimpleIntegerProperty cost;
		private SimpleIntegerProperty count;
        
        public Medical(String n,String m, String ex, String cos,String cou) {
            this.name = new SimpleStringProperty(n);
            this.manufacturer = new SimpleStringProperty(m);
            this.expiryDate = new SimpleStringProperty(ex);
            this.cost = new SimpleIntegerProperty(Integer.parseInt(cos));
            this.count = new SimpleIntegerProperty(Integer.parseInt(cou));
        }
 
        public String getName() {
            return name.get();
        }
 
        public void setName(String n) {
        	name.set(n);
        }
        
        public String getManufacturer() {
            return manufacturer.get();
        }
 
        public void setManufacturer(String n) {
        	manufacturer.set(n);
        }
        
        public String getExpiryDate() {
            return expiryDate.get();
        }
 
        public void setExpiryDate(String ex) {
        	expiryDate.set(ex);
        }
        
        public int getCost() {
            return cost.get();
        }
 
        public void setCost(int i) {
        	cost.set(i);
        }
        
        public int getCount() {
            return count.get();
        }
 
        public void setCount(int cou) {
        	count.set(cou);
        }
}