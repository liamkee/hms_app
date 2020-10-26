import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class HMS_App extends Application implements Creator{
	VBox cbox = new VBox(); 
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane border = new BorderPane();
		
		// top box - System logo placement / START /
		VBox tbox = addTbox(); 
		border.setTop(tbox);
		// top box / END /
		
		// bottom box - Display Current Date Time / START /
		HBox bbox = addBbox();
		border.setBottom(bbox);
		// bottom box / END /
		
		// left navigation bar - Display System Menu / START /
		VBox lbox = new VBox();
		lbox.setPadding(new Insets(20,0,0,10));
		lbox.setSpacing(6);

	    Text title = new Text("Menu");
	    title.setFont(Font.font("Arial", FontWeight.BOLD, 16));
	    lbox.getChildren().add(title);
		border.setLeft(lbox);
		// Initialise hyperlink array for navigation item / START /
	    Hyperlink[] options = new Hyperlink[] {   
	        new Hyperlink("1. Doctors"),
	        new Hyperlink("2. Patients"),
	        new Hyperlink("3. Medicals"),
	        new Hyperlink("4. Laboratories"),
	        new Hyperlink("5. Facilities"),
	        new Hyperlink("6. Staffs"),
	        };
	    // Initialise hyperlink array for navigation item / END /
	    // Set value for each hyperlink array item / START /
	    for (int i=0; i<options.length; i++) {
	        VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
	        lbox.getChildren().add(options[i]);
	    }
	    
		options[0].setOnAction((ActionEvent e)->{
			border.setCenter(null);
	    	border.setCenter(doctorTable());
	    });
		
		options[1].setOnAction((ActionEvent e)->{
			border.setCenter(null);
			border.setCenter(patientTable());
	    });
		
		options[2].setOnAction((ActionEvent e)->{
			border.setCenter(null);
			border.setCenter(medicalTable());
	    });
		
		options[3].setOnAction((ActionEvent e)->{
			border.setCenter(null);
			border.setCenter(laboratoryTable());
	    });
		
		options[4].setOnAction((ActionEvent e)->{
			border.setCenter(null);
			border.setCenter(facilityTable());
	    });
		
		options[5].setOnAction((ActionEvent e)->{
			border.setCenter(null);
			border.setCenter(staffTable());
	    });
		// Set value for each hyperlink array item / END /
		// left navigation bar / END /
		
		// Create scene / START /
		stage.setTitle("HOSPITAL MANAGEMENT SYSTEM - 1704196"); // Set the stage title
		Scene scene = new Scene(border, 695, 650);
		stage.setScene(scene); // Place the scene in the stage
		stage.show(); // Display the stage
		// Create scene / END /
	}
	public VBox addTbox() { //add top box method
		VBox tbox = new VBox();
		tbox.setPadding(new Insets(10,10,10,55));
	    tbox.setStyle("-fx-background-color: #336699;");
	    
	    ImageView imgV = new ImageView();
	    imgV.setImage(new Image("file:///C:/Users/LYKEE/Desktop/Eclipse/Assignment_wGUI/hms.jpg"));
	    imgV.setFitWidth(580);
	    imgV.setFitHeight(100);

	    tbox.getChildren().addAll(imgV);
	    return tbox;
	}
	public HBox addBbox() { //add bottom box method
		HBox bbox = new HBox();
		bbox.setPadding(new Insets(10,10,10,460));
		bbox.setSpacing(100);
		bbox.setStyle("-fx-background-color: #336699;");
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MMMM-YYYY");  
		DateTimeFormatter time = DateTimeFormatter.ofPattern("hh:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 

		Text d = new Text("Date: "+date.format(now)+"\t Time: "+time.format(now));
		bbox.getChildren().addAll(d);
		return bbox;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	//Create Existing Data / START /
	final ObservableList<Doctor> Ddata = FXCollections.observableArrayList(
			new Doctor(StuId.substring(4,7), StuName, "Cardiologists","9-6",StuCourse),
			new Doctor("197", "Hoo Men Sao", "Anesthesiologists","4-12","BSc"),
			new Doctor("199", "Lai Lai", "Dermatologists","6-3","BSc")
		);
	final ObservableList<Patient> Pdata = FXCollections.observableArrayList(
			new Patient(StuId.substring(4,7), StuName, "Obesity",StuSex,"Waiting",StuAge),
			new Patient("888", "Ah Huat Gor", "Too exited","Male","Meeting Doctor","12"),
			new Patient("203", "Aladin Lim", "Covid","Female","In Emergency Room","80")
		);
	final ObservableList<Medical> Mdata = FXCollections.observableArrayList(
			new Medical("Abciximab", "US Bioservices", "08/20/2021","500","22"),
			new Medical("Invega", "SenderraRx", "09/09/2022","350","12"),
			new Medical("AccuNeb", "PANTHERx", "10/23/2021","770","80")
		);
	final ObservableList<Laboratory> Ldata = FXCollections.observableArrayList(
			new Laboratory("A1-02","0003,0001", "Invega,Abciximab",StuId.substring(4,7),"20500"),
			new Laboratory("A2-13","0002", "AccuNeb,Abciximab","197","12000"),
			new Laboratory("B1-07","0002", "Invega","199","5070")
		);
	final ObservableList<Facility> Fdata = FXCollections.observableArrayList(
			new Facility("0001","HeartStopper","US Bioservices",StuId.substring(4,7),"1000"),
			new Facility("0002","Revival-35MX","PANTHERx","197","3000"),
			new Facility("0003","Dreamer2V","SenderraRx","199","5000")
		);
	final ObservableList<Staff> Sdata = FXCollections.observableArrayList(
			new Staff(StuId.substring(4,7),StuName,"Programmer",StuSex,"25000"),
			new Staff("219","Lee Kim Kee","Accountant","Male","550"),
			new Staff("313","Than Oil Sin","Admin","Female","6000")
		);
	//Existing Data / END /
	
	//Generate table / START /
	public VBox doctorTable() {
		final TableView<Doctor> Dtable = new TableView<>();
		
		final HBox hb = new HBox();
		final Label Dlabel = new Label("Doctor Table");
		Dlabel.setFont(new Font("Arial", 20));
		Dtable.setEditable(true);
		
		// Set Columns Property / START /
		TableColumn<Doctor,String> idCol = new TableColumn<Doctor,String>("ID");
		idCol.setMinWidth(30);
		idCol.setCellValueFactory(
                new PropertyValueFactory<>("iD"));
		idCol.setCellFactory(TextFieldTableCell.<Doctor>forTableColumn());
		idCol.setOnEditCommit(
				(CellEditEvent<Doctor,String> t)->{
					((Doctor) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setID(t.getNewValue());
				});
		
        TableColumn<Doctor,String> nameCol = new TableColumn<Doctor,String>("NAME");
        nameCol.setMinWidth(30);
        nameCol.setPrefWidth(130);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));
        nameCol.setCellFactory(TextFieldTableCell.<Doctor>forTableColumn());
        nameCol.setOnEditCommit(
				(CellEditEvent<Doctor,String> t)->{
					((Doctor) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setLastName(t.getNewValue());
				});
        
        TableColumn<Doctor,String> speCol = new TableColumn<Doctor,String>("SPECIALIST");
        speCol.setMinWidth(30);
        speCol.setPrefWidth(170);
        speCol.setCellValueFactory(
                new PropertyValueFactory<>("specialist"));
        speCol.setCellFactory(TextFieldTableCell.<Doctor>forTableColumn());
        speCol.setOnEditCommit(
				(CellEditEvent<Doctor,String> t)->{
					((Doctor) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setSpecialist(t.getNewValue());
				});
        
        TableColumn<Doctor,String> wTCol = new TableColumn<Doctor,String>("TIMING");
        wTCol.setMinWidth(30);
        wTCol.setPrefWidth(100);
        wTCol.setCellValueFactory(
                new PropertyValueFactory<>("timing"));
        wTCol.setCellFactory(TextFieldTableCell.<Doctor>forTableColumn());
        wTCol.setOnEditCommit(
				(CellEditEvent<Doctor,String> t)->{
					((Doctor) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setTiming(t.getNewValue());
				});
        
        TableColumn<Doctor,String> quaCol = new TableColumn<Doctor,String>("QUALIFICATION");
        quaCol.setMinWidth(30);
        quaCol.setPrefWidth(122);
        quaCol.setCellValueFactory(
                new PropertyValueFactory<>("qualification"));
        quaCol.setCellFactory(TextFieldTableCell.<Doctor>forTableColumn());
        quaCol.setOnEditCommit(
				(CellEditEvent<Doctor,String> t)->{
					((Doctor) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setQualification(t.getNewValue());
				});
     
		Dtable.setItems(Ddata);
		Dtable.getColumns().addAll(idCol,nameCol,speCol,wTCol,quaCol);
		// Set Columns Property / END /
		
		//For Adding samples / START /
			//Create textfield for user to fill / START
		final TextField addId = new TextField();
		addId.setPromptText("id");
		addId.setMaxWidth(wTCol.getPrefWidth());
		
		final TextField addName = new TextField();
		addName.setPromptText("name");
		addName.setMaxWidth(wTCol.getPrefWidth());
		
		final TextField addSpe = new TextField();
		addSpe.setPromptText("specialist");
		addSpe.setMaxWidth(wTCol.getPrefWidth());
		
		final TextField addWt = new TextField();
		addWt.setPromptText("timing");
		addWt.setMaxWidth(wTCol.getPrefWidth());
		
		final TextField addQua = new TextField();
		addQua.setPromptText("qualification");
		addQua.setMaxWidth(wTCol.getPrefWidth());
			//Create textfield for user to fill / END /
		
			//Button property for update data Observable List / START /
		final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            Ddata.add(new Doctor(
            		addId.getText(),
            		addName.getText(),
            		addSpe.getText(),
            		addWt.getText(),
            		addQua.getText()
            		));
            addId.clear();
            addName.clear();
            addSpe.clear();
            addWt.clear();
            addQua.clear();
        });
        	//Button property for update data Observable List / END /
        
        hb.getChildren().addAll(addId, addName, addSpe, addWt,addQua,addButton);
        hb.setSpacing(3);
        //For Adding samples /end/

		cbox.getChildren().clear();
		cbox.setPadding(new Insets(10,20,10,10));
		cbox.getChildren().addAll(Dlabel,Dtable,hb);
		
		return cbox;
	}
	// Repeating same things as the doctorTable() until end...
	public VBox patientTable() {
		final TableView<Patient> Ptable = new TableView<>();
		
		final HBox hb = new HBox();
		final Label Plabel = new Label("Patient Table");
		Plabel.setFont(new Font("Arial", 20));
		Ptable.setEditable(true);
		
		TableColumn<Patient,String> idCol = new TableColumn<Patient,String>("ID");
		idCol.setMinWidth(30);
		idCol.setCellValueFactory(
                new PropertyValueFactory<>("iD"));
		idCol.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());
		idCol.setOnEditCommit(
				(CellEditEvent<Patient,String> t)->{
					((Patient) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setID(t.getNewValue());
				});
		
        TableColumn<Patient,String> nameCol = new TableColumn<Patient,String>("NAME");
        nameCol.setMinWidth(30);
        nameCol.setPrefWidth(90);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));
        nameCol.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());
        nameCol.setOnEditCommit(
				(CellEditEvent<Patient,String> t)->{
					((Patient) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setLastName(t.getNewValue());
				});
        
        TableColumn<Patient,String> disCol = new TableColumn<Patient,String>("DISEASE");
        disCol.setMinWidth(30);
        disCol.setPrefWidth(177.5);
        disCol.setCellValueFactory(
                new PropertyValueFactory<>("disease"));
        disCol.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());
        disCol.setOnEditCommit(
				(CellEditEvent<Patient,String> t)->{
					((Patient) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setDisease(t.getNewValue());
				});
        
        TableColumn<Patient,String> sCol = new TableColumn<Patient,String>("SEX");
        sCol.setMinWidth(30);
        sCol.setCellValueFactory(
                new PropertyValueFactory<>("sex"));
        sCol.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());
        sCol.setOnEditCommit(
				(CellEditEvent<Patient,String> t)->{
					((Patient) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setSex(t.getNewValue());
				});
        
        TableColumn<Patient,String> statusCol = new TableColumn<Patient,String>("STATUS");
        statusCol.setMinWidth(30);
        statusCol.setPrefWidth(150);
        statusCol.setCellValueFactory(
                new PropertyValueFactory<>("admitStatus"));
        statusCol.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());
        statusCol.setOnEditCommit(
				(CellEditEvent<Patient,String> t)->{
					((Patient) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setAdmitStatus(t.getNewValue());
				});
        TableColumn<Patient,Integer> ageCol = new TableColumn<Patient,Integer>("AGE");
        ageCol.setMinWidth(30);
        ageCol.setPrefWidth(50);
        ageCol.setCellValueFactory(
                new PropertyValueFactory<>("age"));
        ageCol.setCellFactory(TextFieldTableCell.<Patient,Integer>forTableColumn(new IntegerStringConverter()));
        ageCol.setOnEditCommit(
				(CellEditEvent<Patient,Integer> t)->{
					((Patient) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setAge(t.getNewValue());
				});
        
		Ptable.setItems(Pdata);
		Ptable.getColumns().addAll(idCol,nameCol,disCol,sCol,statusCol,ageCol);
	    
		//For Adding samples /start/
		final TextField addId = new TextField();
		addId.setPromptText("id");
		addId.setMaxWidth(sCol.getPrefWidth());
		
		final TextField addName = new TextField();
		addName.setPromptText("name");
		addName.setMaxWidth(sCol.getPrefWidth());
		
		final TextField addDis = new TextField();
		addDis.setPromptText("disease");
		addDis.setMaxWidth(sCol.getPrefWidth());
		
		final TextField addSex = new TextField();
		addSex.setPromptText("sex");
		addSex.setMaxWidth(sCol.getPrefWidth());
		
		final TextField addStatus = new TextField();
		addStatus.setPromptText("status");
		addStatus.setMaxWidth(sCol.getPrefWidth());
		
		final TextField addAge = new TextField();
		addAge.setPromptText("age");
		addAge.setMaxWidth(sCol.getPrefWidth());
		
		final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            Pdata.add(new Patient(
            		addId.getText(),
            		addName.getText(),
            		addDis.getText(),
            		addSex.getText(),
            		addStatus.getText(),
            		addAge.getText()
            		));
            addId.clear();
            addName.clear();
            addDis.clear();
            addSex.clear();
            addStatus.clear();
            addAge.clear();
        });
        hb.getChildren().addAll(addId, addName, addDis, addSex,addStatus,addAge,addButton);
        hb.setSpacing(3);
        //For Adding samples /end/
        
        cbox.getChildren().clear();
		cbox.setPadding(new Insets(10,20,10,10));
		cbox.getChildren().addAll(Plabel,Ptable,hb);
		
		return cbox;
	}
	public VBox medicalTable() {
		final TableView<Medical> Mtable = new TableView<>();
		final HBox hb = new HBox();
		final Label Mlabel = new Label("Medical Table");
		Mlabel.setFont(new Font("Arial", 20));
		Mtable.setEditable(true);
		
		TableColumn<Medical,String> mNameCol = new TableColumn<Medical,String>("MEDICATION");
		mNameCol.setMinWidth(30);
		mNameCol.setPrefWidth(130);
		mNameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
		mNameCol.setCellFactory(TextFieldTableCell.<Medical>forTableColumn());
		mNameCol.setOnEditCommit(
				(CellEditEvent<Medical,String> t)->{
					((Medical) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setName(t.getNewValue());
				});
		
        TableColumn<Medical,String> manufactCol = new TableColumn<Medical,String>("MANUFACTURER");
        manufactCol.setMinWidth(30);
        manufactCol.setPrefWidth(140);
        manufactCol.setCellValueFactory(
                new PropertyValueFactory<>("manufacturer"));
        manufactCol.setCellFactory(TextFieldTableCell.<Medical>forTableColumn());
        manufactCol.setOnEditCommit(
				(CellEditEvent<Medical,String> t)->{
					((Medical) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setManufacturer(t.getNewValue());
				});
        
        TableColumn<Medical,String> expCol = new TableColumn<Medical,String>("Exp DATE(MM/DD/YYYY)");
        expCol.setMinWidth(30);
        expCol.setPrefWidth(177.5);
        expCol.setCellValueFactory(
                new PropertyValueFactory<>("ExpiryDate"));
        expCol.setCellFactory(TextFieldTableCell.<Medical>forTableColumn());
        expCol.setOnEditCommit(
				(CellEditEvent<Medical,String> t)->{
					((Medical) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setExpiryDate(t.getNewValue());
				});
        
        TableColumn<Medical,Integer> costCol = new TableColumn<Medical,Integer>("COST");
        costCol.setMinWidth(30);
        costCol.setCellValueFactory(
                new PropertyValueFactory<>("cost"));
        costCol.setCellFactory(TextFieldTableCell.<Medical,Integer>forTableColumn(new IntegerStringConverter()));
        costCol.setOnEditCommit(
				(CellEditEvent<Medical,Integer> t)->{
					((Medical) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setCost(t.getNewValue().intValue());
				});
        
        TableColumn<Medical,Integer> countCol = new TableColumn<Medical,Integer>("COUNT");
        countCol.setMinWidth(30);
        countCol.setCellValueFactory(
                new PropertyValueFactory<>("count"));
        countCol.setCellFactory(TextFieldTableCell.<Medical,Integer>forTableColumn(new IntegerStringConverter()));
        countCol.setOnEditCommit(
				(CellEditEvent<Medical,Integer> t)->{
					((Medical) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setCount(t.getNewValue().intValue());
				});
                
		Mtable.setItems(Mdata);
		Mtable.getColumns().addAll(mNameCol,manufactCol,expCol,costCol,countCol);
	    
		//For Adding samples /start/
		final TextField addMedic = new TextField();
		addMedic.setPromptText("medication");
		addMedic.setMaxWidth(costCol.getPrefWidth());
		
		final TextField addManu = new TextField();
		addManu.setPromptText("manufacturer");
		addManu.setMaxWidth(costCol.getPrefWidth()+25);
		
		final TextField addExp = new TextField();
		addExp.setPromptText("exp date");
		addExp.setMaxWidth(costCol.getPrefWidth());
		
		final TextField addCost = new TextField();
		addCost.setPromptText("cost");
		addCost.setMaxWidth(costCol.getPrefWidth());
		
		final TextField addCount = new TextField();
		addCount.setPromptText("count");
		addCount.setMaxWidth(costCol.getPrefWidth());
		
		final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            Mdata.add(new Medical(
            		addMedic.getText(),
            		addManu.getText(),
            		addExp.getText(),
            		addCost.getText(),
            		addCount.getText()
            		));
            addMedic.clear();
            addManu.clear();
            addExp.clear();
            addCost.clear();
            addCount.clear();
        });
        hb.getChildren().addAll(addMedic, addManu, addExp, addCost,addCount,addButton);
        hb.setSpacing(3);
        //For Adding samples /end/
        
        cbox.getChildren().clear();
		cbox.setPadding(new Insets(10,20,10,10));
		cbox.getChildren().addAll(Mlabel,Mtable,hb);
		
		return cbox;
	}
	public VBox laboratoryTable() {
		final TableView<Laboratory> Ltable = new TableView<>();
		final HBox hb = new HBox();
		final Label Llabel = new Label("Laboratory Table");
		Llabel.setFont(new Font("Arial", 20));
		Ltable.setEditable(true);
		
		TableColumn<Laboratory,String> labCol = new TableColumn<Laboratory,String>("LAB No.");
		labCol.setMinWidth(30);
		labCol.setCellValueFactory(
                new PropertyValueFactory<>("lab"));
		labCol.setCellFactory(TextFieldTableCell.<Laboratory>forTableColumn());
		labCol.setOnEditCommit(
				(CellEditEvent<Laboratory,String> t)->{
					((Laboratory) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setLab(t.getNewValue());
				});
		
		TableColumn<Laboratory,String> faciCol = new TableColumn<Laboratory,String>("FACILITY No.");
		faciCol.setMinWidth(30);
		faciCol.setPrefWidth(120);
		faciCol.setCellValueFactory(
                new PropertyValueFactory<>("faciNo"));
		faciCol.setCellFactory(TextFieldTableCell.<Laboratory>forTableColumn());
		faciCol.setOnEditCommit(
				(CellEditEvent<Laboratory,String> t)->{
					((Laboratory) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setFaciNo(t.getNewValue());
				});
		
		TableColumn<Laboratory,String> medicCol = new TableColumn<Laboratory,String>("MEDICATION");
		medicCol.setMinWidth(30);
		medicCol.setPrefWidth(200);
		medicCol.setCellValueFactory(
                new PropertyValueFactory<>("medicName"));
		medicCol.setCellFactory(TextFieldTableCell.<Laboratory>forTableColumn());
		medicCol.setOnEditCommit(
				(CellEditEvent<Laboratory,String> t)->{
					((Laboratory) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setMedicName(t.getNewValue());
				});
		
		TableColumn<Laboratory,String> staffCol = new TableColumn<Laboratory,String>("STAFF ID");
		staffCol.setMinWidth(30);
		staffCol.setCellValueFactory(
                new PropertyValueFactory<>("staffId"));
		staffCol.setCellFactory(TextFieldTableCell.<Laboratory>forTableColumn());
		staffCol.setOnEditCommit(
				(CellEditEvent<Laboratory,String> t)->{
					((Laboratory) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setStaffId(t.getNewValue());
				});
		
		TableColumn<Laboratory,Integer> costCol = new TableColumn<Laboratory,Integer>("COST");
        costCol.setMinWidth(30);
        costCol.setPrefWidth(107);
        costCol.setCellValueFactory(
                new PropertyValueFactory<>("cost"));
        costCol.setCellFactory(TextFieldTableCell.<Laboratory,Integer>forTableColumn(new IntegerStringConverter()));
        costCol.setOnEditCommit(
				(CellEditEvent<Laboratory,Integer> t)->{
					((Laboratory) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setCost(t.getNewValue().intValue());
				});
        
        Ltable.setItems(Ldata);
        Ltable.getColumns().addAll(labCol,faciCol,medicCol,staffCol,costCol);
	    
		//For Adding samples /start/
		final TextField addLab = new TextField();
		addLab.setPromptText("lab no.");
		addLab.setMaxWidth(costCol.getPrefWidth()-25);
		
		final TextField addFaci = new TextField();
		addFaci.setPromptText("facility no.");
		addFaci.setMaxWidth(costCol.getPrefWidth()+20);
		
		final TextField addMedic = new TextField();
		addMedic.setPromptText("medication");
		addMedic.setMaxWidth(costCol.getPrefWidth());
		
		final TextField addStaff = new TextField();
		addStaff.setPromptText("staff id");
		addStaff.setMaxWidth(costCol.getPrefWidth()-25);
		
		final TextField addCost = new TextField();
		addCost.setPromptText("cost");
		addCost.setMaxWidth(costCol.getPrefWidth()-25);
		
		final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            Ldata.add(new Laboratory(
            		addLab.getText(),
            		addFaci.getText(),
            		addMedic.getText(),
            		addStaff.getText(),
            		addCost.getText()
            		));
            addLab.clear();
            addFaci.clear();
    		addMedic.clear();
    		addStaff.clear();
            addCost.clear();
        });
        hb.getChildren().addAll(addLab, addFaci, addMedic, addStaff, addCost, addButton);
        hb.setSpacing(3);
        //For Adding samples /end/
        
        cbox.getChildren().clear();
		cbox.setPadding(new Insets(10,20,10,10));
		cbox.getChildren().addAll(Llabel,Ltable,hb);
		
		return cbox;
	}
	public VBox facilityTable() {
		final TableView<Facility> Ftable = new TableView<>();
		final HBox hb = new HBox();
		final Label Flabel = new Label("Facility Table");
		Flabel.setFont(new Font("Arial", 20));
		Ftable.setEditable(true);
		
		TableColumn<Facility,String> fNoCol = new TableColumn<Facility,String>("FACILITY No.");
		fNoCol.setMinWidth(30);
		fNoCol.setPrefWidth(85);
		fNoCol.setCellValueFactory(
                new PropertyValueFactory<>("faciNo"));
		fNoCol.setCellFactory(TextFieldTableCell.<Facility>forTableColumn());
		fNoCol.setOnEditCommit(
				(CellEditEvent<Facility,String> t)->{
					((Facility) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setFaciNo(t.getNewValue());
				});
		
		TableColumn<Facility,String> faciCol = new TableColumn<Facility,String>("FACILITY NAME");
		faciCol.setMinWidth(30);
		faciCol.setPrefWidth(143);
		faciCol.setCellValueFactory(
                new PropertyValueFactory<>("facility"));
		faciCol.setCellFactory(TextFieldTableCell.<Facility>forTableColumn());
		faciCol.setOnEditCommit(
				(CellEditEvent<Facility,String> t)->{
					((Facility) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setFacility(t.getNewValue());
				});
		
		TableColumn<Facility,String> sellerCol = new TableColumn<Facility,String>("SELLER(COMPANY NAME)");
		sellerCol.setMinWidth(30);
		sellerCol.setPrefWidth(170);
		sellerCol.setCellValueFactory(
                new PropertyValueFactory<>("seller"));
		sellerCol.setCellFactory(TextFieldTableCell.<Facility>forTableColumn());
		sellerCol.setOnEditCommit(
				(CellEditEvent<Facility,String> t)->{
					((Facility) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setSeller(t.getNewValue());
				});
		
		TableColumn<Facility,String> buyerCol = new TableColumn<Facility,String>("APPROVER(Dr ID)");
		buyerCol.setMinWidth(30);
		buyerCol.setPrefWidth(110);
		buyerCol.setCellValueFactory(
                new PropertyValueFactory<>("buyer"));
		buyerCol.setCellFactory(TextFieldTableCell.<Facility>forTableColumn());
		buyerCol.setOnEditCommit(
				(CellEditEvent<Facility,String> t)->{
					((Facility) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setBuyer(t.getNewValue());
				});
		
		TableColumn<Facility,Integer> costCol = new TableColumn<Facility,Integer>("COST");
        costCol.setMinWidth(30);
        costCol.setPrefWidth(80);
        costCol.setCellValueFactory(
                new PropertyValueFactory<>("cost"));
        costCol.setCellFactory(TextFieldTableCell.<Facility,Integer>forTableColumn(new IntegerStringConverter()));
        costCol.setOnEditCommit(
				(CellEditEvent<Facility,Integer> t)->{
					((Facility) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setCost(t.getNewValue().intValue());
				});
        Ftable.setItems(Fdata);
        Ftable.getColumns().addAll(fNoCol,faciCol,sellerCol,buyerCol,costCol);
	    
		//For Adding samples /start/
		final TextField addFNo = new TextField();
		addFNo.setPromptText("facility no.");
		addFNo.setMaxWidth(fNoCol.getPrefWidth());
		
		final TextField addFaci = new TextField();
		addFaci.setPromptText("facility name");
		addFaci.setMaxWidth(faciCol.getPrefWidth());
		
		final TextField addSeller = new TextField();
		addSeller.setPromptText("seller");
		addSeller.setMaxWidth(sellerCol.getPrefWidth()-40);
		
		final TextField addBuyer = new TextField();
		addBuyer.setPromptText("approver");
		addBuyer.setMaxWidth(buyerCol.getPrefWidth()-35);
		
		final TextField addCost = new TextField();
		addCost.setPromptText("cost");
		addCost.setMaxWidth(costCol.getPrefWidth()-20);
		
		final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            Fdata.add(new Facility(
            		addFNo.getText(),
            		addFaci.getText(),
            		addSeller.getText(),
            		addBuyer.getText(),
            		addCost.getText()
            		));
            addFNo.clear();
            addFaci.clear();
            addSeller.clear();
            addBuyer.clear();
            addCost.clear();
        });
        hb.getChildren().addAll(addFNo,addFaci,addSeller,addBuyer,addCost,addButton);
        hb.setSpacing(3);
        //For Adding samples /end/
        
        cbox.getChildren().clear();
		cbox.setPadding(new Insets(10,20,10,10));
		cbox.getChildren().addAll(Flabel,Ftable,hb);
		
		return cbox;
	}
	public VBox staffTable() {
		final TableView<Staff> Stable = new TableView<>();
		final HBox hb = new HBox();
		final Label Slabel = new Label("Staff Table");
		Slabel.setFont(new Font("Arial", 20));
		Stable.setEditable(true);
		
		TableColumn<Staff,String> idCol = new TableColumn<Staff,String>("ID");
		idCol.setMinWidth(30);
		idCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));
		idCol.setCellFactory(TextFieldTableCell.<Staff>forTableColumn());
		idCol.setOnEditCommit(
				(CellEditEvent<Staff,String> t)->{
					((Staff) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setId(t.getNewValue());
				});
        
		TableColumn<Staff,String> nameCol = new TableColumn<Staff,String>("NAME");
		nameCol.setMinWidth(30);
		nameCol.setPrefWidth(170);
		nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
		nameCol.setCellFactory(TextFieldTableCell.<Staff>forTableColumn());
		nameCol.setOnEditCommit(
				(CellEditEvent<Staff,String> t)->{
					((Staff) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setName(t.getNewValue());
				});
		
		TableColumn<Staff,String> desCol = new TableColumn<Staff,String>("DESIGNATION");
		desCol.setMinWidth(30);
		desCol.setPrefWidth(237);
		desCol.setCellValueFactory(
                new PropertyValueFactory<>("designation"));
		desCol.setCellFactory(TextFieldTableCell.<Staff>forTableColumn());
		desCol.setOnEditCommit(
				(CellEditEvent<Staff,String> t)->{
					((Staff) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setDesignation(t.getNewValue());
				});
		
		TableColumn<Staff,String> sexCol = new TableColumn<Staff,String>("SEX");
		sexCol.setMinWidth(30);
		sexCol.setCellValueFactory(
                new PropertyValueFactory<>("sex"));
		sexCol.setCellFactory(TextFieldTableCell.<Staff>forTableColumn());
		sexCol.setOnEditCommit(
				(CellEditEvent<Staff,String> t)->{
					((Staff) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setSex(t.getNewValue());
				});
		
		TableColumn<Staff,Integer> salCol = new TableColumn<Staff,Integer>("SALARY");
		salCol.setMinWidth(30);
		salCol.setCellValueFactory(
                new PropertyValueFactory<>("salary"));
		salCol.setCellFactory(TextFieldTableCell.<Staff,Integer>forTableColumn(new IntegerStringConverter()));
		salCol.setOnEditCommit(
				(CellEditEvent<Staff,Integer> t)->{
					((Staff) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setSalary(t.getNewValue().intValue());
				});
		
        Stable.setItems(Sdata);
        Stable.getColumns().addAll(idCol,nameCol,desCol,sexCol,salCol);
	    
		//For Adding samples /start/
		final TextField addId = new TextField();
		addId.setPromptText("id");
		addId.setMaxWidth(idCol.getPrefWidth()-20);
		
		final TextField addName = new TextField();
		addName.setPromptText("name");
		addName.setMaxWidth(nameCol.getPrefWidth()-40);
		
		final TextField addDes = new TextField();
		addDes.setPromptText("designation");
		addDes.setMaxWidth(desCol.getPrefWidth()-10);
		
		final TextField addSex = new TextField();
		addSex.setPromptText("sex");
		addSex.setMaxWidth(sexCol.getPrefWidth());
		
		final TextField addSal = new TextField();
		addSal.setPromptText("salary");
		addSal.setMaxWidth(salCol.getPrefWidth());
		
		final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            Sdata.add(new Staff(
            		addId.getText(),
            		addName.getText(),
            		addDes.getText(),
            		addSex.getText(),
            		addSal.getText()
            		));
            addId.clear();
    		addName.clear();
    		addDes.clear();
    		addSex.clear();
    		addSal.clear();
        });
        hb.getChildren().addAll(addId,addName,addDes,addSex,addSal,addButton);
        hb.setSpacing(3);
        //For Adding samples /end/
        
        cbox.getChildren().clear();
		cbox.setPadding(new Insets(10,20,10,10));
		cbox.getChildren().addAll(Slabel,Stable,hb);
		
		return cbox;
	}
	//Generate table / END / 
}
