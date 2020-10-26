import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Facility {
		private SimpleStringProperty faciNo;
        private SimpleStringProperty facility;
        private SimpleStringProperty seller;
        private SimpleStringProperty buyer;
        private SimpleIntegerProperty cost;
        
        public Facility(String f, String i, String s, String b, String c) {
        	this.faciNo = new SimpleStringProperty(f);
            this.facility = new SimpleStringProperty(i);
            this.seller = new SimpleStringProperty(s);
            this.buyer = new SimpleStringProperty(b);
            this.cost = new SimpleIntegerProperty(Integer.parseInt(c));
        }
 
        public String getFaciNo() {
            return faciNo.get();
        }
 
        public void setFaciNo(String i) {
        	faciNo.set(i);
        }
        
        public String getFacility() {
            return facility.get();
        }
 
        public void setFacility(String i) {
        	facility.set(i);
        }
        
        public String getSeller() {
            return seller.get();
        }
 
        public void setSeller(String i) {
        	seller.set(i);
        }
        
        public String getBuyer() {
            return buyer.get();
        }
 
        public void setBuyer(String i) {
        	buyer.set(i);
        }
        
        public int getCost() {
            return cost.get();
        }
 
        public void setCost(int c) {
        	cost.set(c);
        }
}