/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.DBOperator;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import model.Employee;

public class DBOperationDesign extends GridPane {
    DBOperator operator;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final RowConstraints rowConstraints5;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final TextField txtId;
    protected final TextField txtFname;
    protected final TextField txtMname;
    protected final TextField txtEmail;
    protected final TextField txtPhone;
    protected final TextField txtLname;
    protected final AnchorPane anchorPane;
    protected final Button btnNew;
    protected final Button btnDelete;
    protected final Button btnFirst;
    protected final Button btnPrevious;
    protected final Button btnNext;
    protected final Button btnUpdate;
    protected final Button btnLast;

    public DBOperationDesign(DBOperator operator) {
        this.operator = operator;
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        txtId = new TextField();
        txtFname = new TextField();
        txtMname = new TextField();
        txtEmail = new TextField();
        txtPhone = new TextField();
        txtLname = new TextField();
        anchorPane = new AnchorPane();
        btnNew = new Button();
        btnDelete = new Button();
        btnFirst = new Button();
        btnPrevious = new Button();
        btnNext = new Button();
        btnUpdate = new Button();
        btnLast = new Button();
        
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
            operator.changeNewFlag();
            operator.update(getUpdates());
        });
        btnLast.setOnAction((event)->{
            changeView(operator.getLast());
        });
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(294.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(180.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(420.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(420.0);

        rowConstraints.setMaxHeight(55.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(49.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(64.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(64.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(94.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(67.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(150.0);
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(72.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(251.0);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(85.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(251.0);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(87.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMaxHeight(251.0);
        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setPrefHeight(87.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        setOpaqueInsets(new Insets(10.0));

        GridPane.setHgrow(label, javafx.scene.layout.Priority.ALWAYS);
        label.setPrefHeight(17.0);
        label.setPrefWidth(139.0);
        label.setText("ID");

        GridPane.setRowIndex(label0, 3);
        label0.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label0.setPrefHeight(17.0);
        label0.setPrefWidth(139.0);
        label0.setText("Middle Name");

        GridPane.setRowIndex(label1, 2);
        label1.setPrefHeight(17.0);
        label1.setPrefWidth(139.0);
        label1.setText("Last Name");

        GridPane.setRowIndex(label2, 1);
        label2.setPrefHeight(17.0);
        label2.setPrefWidth(139.0);
        label2.setText("First Name");

        GridPane.setRowIndex(label3, 4);
        label3.setPrefHeight(17.0);
        label3.setPrefWidth(139.0);
        label3.setText("Email");

        GridPane.setRowIndex(label4, 5);
        label4.setPrefHeight(17.0);
        label4.setPrefWidth(139.0);
        label4.setText("Phone");

        GridPane.setColumnIndex(txtId, 1);

        GridPane.setColumnIndex(txtFname, 1);
        GridPane.setRowIndex(txtFname, 1);

        GridPane.setColumnIndex(txtMname, 1);
        GridPane.setRowIndex(txtMname, 3);

        GridPane.setColumnIndex(txtEmail, 1);
        GridPane.setRowIndex(txtEmail, 4);

        GridPane.setColumnIndex(txtPhone, 1);
        GridPane.setRowIndex(txtPhone, 5);

        GridPane.setColumnIndex(txtLname, 1);
        GridPane.setRowIndex(txtLname, 2);

        GridPane.setColumnIndex(anchorPane, 1);
        GridPane.setRowIndex(anchorPane, 6);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(200.0);

        btnNew.setLayoutX(9.0);
        btnNew.setLayoutY(24.0);
        btnNew.setMnemonicParsing(false);
        btnNew.setText("New");

        btnDelete.setLayoutX(132.0);
        btnDelete.setLayoutY(24.0);
        btnDelete.setMnemonicParsing(false);
        btnDelete.setText("Delete");

        btnFirst.setLayoutX(196.0);
        btnFirst.setLayoutY(24.0);
        btnFirst.setMnemonicParsing(false);
        btnFirst.setText("First");

        btnPrevious.setLayoutX(249.0);
        btnPrevious.setLayoutY(24.0);
        btnPrevious.setMnemonicParsing(false);
        btnPrevious.setText("Previous");

        btnNext.setLayoutX(322.0);
        btnNext.setLayoutY(24.0);
        btnNext.setMnemonicParsing(false);
        btnNext.setText("Next");

        btnUpdate.setLayoutX(61.0);
        btnUpdate.setLayoutY(24.0);
        btnUpdate.setMnemonicParsing(false);
        btnUpdate.setText("Update");

        btnLast.setLayoutX(369.0);
        btnLast.setLayoutY(24.0);
        btnLast.setMnemonicParsing(false);
        btnLast.setText("Last");

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        getRowConstraints().add(rowConstraints1);
        getRowConstraints().add(rowConstraints2);
        getRowConstraints().add(rowConstraints3);
        getRowConstraints().add(rowConstraints4);
        getRowConstraints().add(rowConstraints5);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(label4);
        getChildren().add(txtId);
        getChildren().add(txtFname);
        getChildren().add(txtMname);
        getChildren().add(txtEmail);
        getChildren().add(txtPhone);
        getChildren().add(txtLname);
        anchorPane.getChildren().add(btnNew);
        anchorPane.getChildren().add(btnDelete);
        anchorPane.getChildren().add(btnFirst);
        anchorPane.getChildren().add(btnPrevious);
        anchorPane.getChildren().add(btnNext);
        anchorPane.getChildren().add(btnUpdate);
        anchorPane.getChildren().add(btnLast);
        getChildren().add(anchorPane);

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
