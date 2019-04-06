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
import static javafx.scene.layout.Region.USE_PREF_SIZE;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class DBOperationDesignController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

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
    
}
