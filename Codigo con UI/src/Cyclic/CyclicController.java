/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cyclic;

import Imprimir.CyclicPrint;
import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;

/**
 *
 * @author rdiazarr
 */
public class CyclicController {
    
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="NumCiphers"
    private TextField NumCiphers; // Value injected by FXMLLoader
    
    @FXML // fx:id="Complete"
    private CheckBox Complete; // Value injected by FXMLLoader   
    
    @FXML // fx:id="Modulus"
    private TextField Modulus; // Value injected by FXMLLoader
    
    @FXML // fx:id="Exponent"
    private TextField Exponent; // Value injected by FXMLLoader

    @FXML // fx:id="Message"
    private TextField Message; // Value injected by FXMLLoader
        
    @FXML // fx:id="CypherMessage"
    private TextField CypherMessage; // Value injected by FXMLLoader    

    @FXML // fx:id="startBttn"
    private Button startBttn; // Value injected by FXMLLoader

    @FXML // fx:id="continueBttn"
    private Button continueBttn; // Value injected by FXMLLoader

    @FXML // fx:id="Results"
    private TextArea Results; // Value injected by FXMLLoader

    @FXML // fx:id="mRecovered"
    private TextField mRecovered; // Value injected by FXMLLoader

    @FXML // fx:id="Time"
    private TextField Time; // Value injected by FXMLLoader
    
    
    
    
    private CyclicAttack cyclic;    
           
    private int radix;
    
    private BigInteger modulusBI;
    
    private BigInteger exponentBI;
    
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert NumCiphers != null : "fx:id=\"NumCiphers\" was not injected: check your FXML file 'Cyclic.fxml'.";
        assert Complete != null : "fx:id=\"Complete\" was not injected: check your FXML file 'Cyclic.fxml'.";
        assert Message != null : "fx:id=\"Message\" was not injected: check your FXML file 'Cyclic.fxml'.";
        assert Modulus != null : "fx:id=\"Modulus\" was not injected: check your FXML file 'Cyclic.fxml'.";
        assert Exponent != null : "fx:id=\"Exponent\" was not injected: check your FXML file 'Cyclic.fxml'.";
        assert CypherMessage != null : "fx:id=\"CypherMessage\" was not injected: check your FXML file 'Cyclic.fxml'.";        
        assert startBttn != null : "fx:id=\"startBttn\" was not injected: check your FXML file 'Cyclic.fxml'.";
        assert continueBttn != null : "fx:id=\"continueBttn\" was not injected: check your FXML file 'Cyclic.fxml'.";
        assert Results != null : "fx:id=\"Results\" was not injected: check your FXML file 'Cyclic.fxml'.";
        assert mRecovered != null : "fx:id=\"mRecovered\" was not injected: check your FXML file 'Cyclic.fxml'.";
        assert Time != null : "fx:id=\"Time\" was not injected: check your FXML file 'Cyclic.fxml'.";

        
        cyclic = new CyclicAttack(new CyclicPrint(this));
        continueBttn.setDisable(true);      
    }
    
    @FXML
    public void start(ActionEvent event) {
        this.cyclic.setRadix(this.radix); 
        
        String message = this.Message.getText();
        
        if (this.cyclic.init(message, this.modulusBI, this.exponentBI)){
        
            if(this.Complete.isSelected()){
                this.cyclic.complete();
            } else {
                String numOfCyphers = this.NumCiphers.getText();            
                this.cyclic.start(numOfCyphers);
            }
        } 
    }

    @FXML
    public void Continue(ActionEvent event) {
        String numOfCyphers = this.NumCiphers.getText();         
        this.cyclic.Continue(numOfCyphers);
    }
    

    @FXML
    void info(ActionEvent event) {
        this.cyclic.putInfo();
    }
    
    
    @FXML
    void clean(ActionEvent event) {
        
        this.Complete.setDisable(false);
        this.NumCiphers.setDisable(false);
        this.NumCiphers.setBlendMode(BlendMode.SRC_OVER);
        this.NumCiphers.setEditable(true);
        this.NumCiphers.setText("10");
        this.Message.setEditable(true);
        this.Message.clear();
        this.CypherMessage.clear();
        this.Results.clear();        
        this.Time.clear();
        this.startBttn.setDisable(false);
        this.continueBttn.setDisable(true);

    }

    

    
    
    @FXML
    public void checkSelected(ActionEvent event){
        if (this.Complete.isSelected()){
            this.NumCiphers.clear();
            this.NumCiphers.setDisable(true);
            this.NumCiphers.setBlendMode(BlendMode.DARKEN);
        }
        
        if (!this.Complete.isSelected()){
            this.NumCiphers.setText("10");
            this.NumCiphers.setDisable(false);
            this.NumCiphers.setBlendMode(BlendMode.SRC_OVER);
        }
    }   

    
    
    
    public void setRadix(int radix) {
        this.radix = radix;
    }
    
    public void setModulusBI(BigInteger modulus) {
        this.modulusBI = modulus;
    }
  
    public void setExponentBI(BigInteger exponent) {
        this.exponentBI = exponent;
    }
    
    
    
    //parte gráfica -----------------------------------------------------------
    public TextField getModulus() {
        return this.Modulus;
    }
    
    public TextField getExponent() {
        return this.Exponent;
    }
    
    public TextField getMessage() {
        return this.Message;
    }
    
    public TextField getCypherMessage() {
        return this.CypherMessage;
    }
    
    public TextField getTime() {
        return this.Time;
    }
    
    public TextArea getResults() {
        return this.Results;
    }
    
    public TextField getMRecovered() {
        return this.mRecovered;
    }
    
    public CheckBox getComplete() {
        return this.Complete;
    }
    
    public TextField getNumCiphers() {
        return this.NumCiphers;
    }
    
    public Button getContinueBttn() {
        return this.continueBttn;
    }
     
    public Button getStartBttn() {
        return this.startBttn;
    }


}
