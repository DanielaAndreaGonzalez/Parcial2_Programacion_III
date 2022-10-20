/**
 * 
 */
package parcial2.controller;


import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import parcial2.Main;
import parcial2.model.Persona;

/**
 * @author GonzalezHDanielaA
 *
 */
public class PrincipalViewController {
	
	Main aplication;
	ModelFactoryController modelFactoryController;
	CrudPersonaController  crudPersonaController;
	Persona  persona;
	ObservableList<Persona> listaPersona = FXCollections.observableArrayList();
	
	@FXML
    private Button btnActualizarPer;

    @FXML
    private Button btnAgregarPer;

    @FXML
    private Button btnBuscarPer;

    @FXML
    private Button btnEliminarPer;
    
    @FXML
    private TableView<Persona> tblPersonas;

    @FXML
    private TableColumn<Persona, String> columnCodigoPer;

    @FXML
    private TableColumn<Persona, String> columnDireccionPer;

    @FXML
    private TableColumn<Persona, String> columnEmailPer;

    @FXML
    private TableColumn<Persona, String> columnNombrePer;

    @FXML
    private TableColumn<Persona, String> columnTelefonoPer;

    @FXML
    private TextField txtDireccionPer;

    @FXML
    private TextField txtEmailPer;

    @FXML
    private TextField txtNombrePer;

    @FXML
    private TextField txtTelefonoPer;

    @FXML
    private TextField txtcodigoPer;
	
    public void setAplicacion(Main aplicacion) 
    {
    	this.aplication = aplicacion;
    	tblPersonas.setItems(getListaPersonas());   	
    }
    
    @FXML
	void initialize()
	{
    	modelFactoryController = ModelFactoryController.getInstance();
    	crudPersonaController = new CrudPersonaController(modelFactoryController);
    	
    	
    	//Tabla Personas
    	this.columnCodigoPer.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    	this.columnNombrePer.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	this.columnTelefonoPer.setCellValueFactory(new PropertyValueFactory<>("telefono"));
    	this.columnEmailPer.setCellValueFactory(new PropertyValueFactory<>("email"));
    	this.columnDireccionPer.setCellValueFactory(new PropertyValueFactory<>("direccion"));
     	
    	tblPersonas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    		
    	persona = newSelection;
    	mostrarInformacionPersona(newSelection);
    	});
    	
}
	
    @FXML
    void agregarPersonaAction(ActionEvent event) {
    	agregarPersona();   	  	
    }
	
    @FXML
    void buscarPersonaAction(ActionEvent event) {
    	buscarPersona();
    }
    
    @FXML
    void actualizarPersonaAction(ActionEvent event) {
    	actualizarPersona();
    }
    
    @FXML
    void eliminarPersonasAction(ActionEvent event) {
    	
    	eliminarPersona();
    }
    
    
    public ObservableList<Persona> getListaPersonas()
    {
    	listaPersona.addAll(modelFactoryController.obtenerListaPersonasXML());
    	return listaPersona;
    }
    
    public void agregarPersona()
    {
    	String codigo = txtcodigoPer.getText();
    	String nombre = txtNombrePer.getText();
    	String telefono = txtTelefonoPer.getText();
    	String email = txtEmailPer.getText();
    	String direccion = txtDireccionPer.getText();
   
    	persona = crudPersonaController.agregarPersona(codigo, nombre, telefono, email, direccion);
    	listaPersona.add(persona);
    	JOptionPane.showMessageDialog(null, "Se agregó la persona con éxito!");
    }
	
    
    
    public void buscarPersona()
    {
    	String codigo = txtcodigoPer.getText();
    	Persona persona2 = new Persona();
    	persona2 = crudPersonaController.buscarPersona(codigo);
    		
    	txtcodigoPer.setText(persona2.getCodigo());
    	txtNombrePer.setText(persona2.getNombre());
    	txtTelefonoPer.setText(persona2.getTelefono());
    	txtDireccionPer.setText(persona2.getDireccion());
    	txtEmailPer.setText(persona2.getEmail());	
    }
    
    public void actualizarPersona()
    {
    	String codigo = txtcodigoPer.getText();
    	String nombre = txtNombrePer.getText();
    	String telefono = txtTelefonoPer.getText();
    	String email =  txtEmailPer.getText();
    	String direccion =  txtDireccionPer.getText();
    	
    	persona = crudPersonaController.actualizarPersona(codigo, nombre, telefono, email, direccion);
    	tblPersonas.refresh();
    	
    	System.out.println("Persona actualizada");
    }
    
    public void eliminarPersona()
    {
    	String codigo = txtcodigoPer.getText();
    	boolean eliminado;
    	
    	eliminado = crudPersonaController.eliminarPersona(codigo);
    	if(eliminado)
    	{
    		listaPersona.remove(persona);
    		tblPersonas.getSelectionModel().clearSelection();
    		JOptionPane.showMessageDialog(null, "Se eliminó");	
    	}
    	
    }
    
    
    
    public void mostrarInformacionPersona(Persona personaSeleccionada)
    {
    	if(personaSeleccionada != null)
    	{
    		txtcodigoPer.setText(personaSeleccionada.getCodigo());
    		txtNombrePer.setText(personaSeleccionada.getNombre());
    		txtTelefonoPer.setText(personaSeleccionada.getTelefono());
    		txtEmailPer.setText(personaSeleccionada.getEmail());
    		txtDireccionPer.setText(personaSeleccionada.getDireccion());	
    	}
    }
	
    
    

}
