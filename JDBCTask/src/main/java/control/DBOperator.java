package control;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DBOperation;
import model.Employee;
import view.DBOperationDesignController;


public class DBOperator extends Application {
    DBOperationDesignController dbDesign;
    DBOperation dbOperation;
    public DBOperator() {
        dbDesign = new DBOperationDesignController(this);
        dbOperation = new DBOperation();
        if(dbOperation.connect()){
            initial();
        }else{
            System.out.println("Couldn't Connect to the Database");
        }
        
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Scene scene = new Scene(dbDesign);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DB Operation");
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void stop(){
        dbOperation.close();
    }
    public void initial(){
        dbDesign.changeView(dbOperation.initial());
    }
    public void changeNewFlag(){
        dbOperation.changeNewFlag();
    }
    public void update(Employee employee){
        dbOperation.update(employee);
    }
    public void delete(){
        dbOperation.delete();
    }
    public Employee getNext(){
        return dbOperation.getNext();
    }
    public Employee getLast(){
        return dbOperation.getLast();
    }
    public Employee getPrevious(){
        return dbOperation.getPrevious();
    }
    public Employee getFirst(){
        return dbOperation.getFisrt();
    }

}
