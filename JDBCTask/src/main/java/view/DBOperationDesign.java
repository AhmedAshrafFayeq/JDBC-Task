/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.DBOperator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import model.Employee;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class DBOperationDesignController extends GridPane{

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtFname;
    @FXML
    private TextField txtMname;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtLname;
    @FXML
    private Button btnNew;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnFirst;
    @FXML
    private Button btnPrevious;
    @FXML
    private Button btnNext;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnLast;
    
    private final DBOperator operator; 

    public DBOperationDesignController(DBOperator operator) {
        this.operator = operator;
        
        btnNew.setOnAction((event)->{
            clearInput();
            operator.changeNewFlag();
        });
        btnDelete.setOnAction((event)->{
           clearInput();
           operator.changeNewFlag();
            operator.delete();
        });
        btnFirst.setOnAction((event)->{
            changeView(operator.getFirst());
        });
        btnPrevious.setOnAction((event)->{
            changeView(operator.getPrevious());
        });
        btnNext.setOnAction((event)->{
            changeView(operator.getNext());
        });
        btnUpdate.setOnAction((event)->{
            operator.update(getUpdates());
        });
        btnLast.setOnAction((event)->{
            changeView(operator.getLast());
        });
        
        
    }
    public void changeView(Employee emp){
        if(emp!=null){
            txtId.setText(""+emp.Id);
            txtFname.setText(emp.firstName);
            txtMname.setText(emp.middleName);
            txtEmail.setText(emp.email);
            txtPhone.setText(""+emp.phone);
            txtLname.setText(emp.lastName);
        }
    }
    public Employee getUpdates(){
        return new Employee(Integer.parseInt(txtId.getText().toString()), Integer.parseInt(txtPhone.getText().toString()),
                txtFname.getText(), txtMname.getText(),
        txtLname.getText(), txtEmail.getText());
    }
    public void clearInput(){
        txtId.setText("");
        txtFname.setText("");
        txtMname.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtLname.setText("");
    }
    
}
