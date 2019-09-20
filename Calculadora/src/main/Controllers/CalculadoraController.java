package main.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable {


    private Stage prevStage;
    private String texto = "";
    private String anterior = "";
    private boolean shift = false;
    private short parentesis = 0;

    //Declaracion de botones
    @FXML
    private Label lblTexto;
    public Button btnSin;
    public Button btnCos;
    public Button btnTan;
    public Button btnLog;

    public void setPrevStage(Stage stage) {
        prevStage = stage;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //Funciones de botones signos
    public void botonParentesisIzquierdo(ActionEvent event) {
        this.texto = this.texto + "(";
        lblTexto.setText(this.texto);
    }

    public void botonParentesisDerecha(ActionEvent event) {
        this.texto = this.texto + ")";
        lblTexto.setText(this.texto);
    }

    public void botonPunto(ActionEvent event) {
        this.texto = this.texto + ".";
        lblTexto.setText(this.texto);
    }

    public void botonSuma(ActionEvent event) {
        this.texto = this.texto + "+";
        lblTexto.setText(this.texto);
    }

    public void botonResta(ActionEvent event) {
        this.texto = this.texto + "-";
        lblTexto.setText(this.texto);
    }

    public void botonMultiplicacion(ActionEvent event) {
        this.texto = this.texto + "*";
        lblTexto.setText(this.texto);
    }

    public void botonDivision(ActionEvent event) {
        this.texto = this.texto + "/";
        lblTexto.setText(this.texto);
    }

    public void botonRaiz(ActionEvent event) {
        this.texto = this.texto + "√";
        lblTexto.setText(this.texto);
    }

    public void botonExponente(ActionEvent event) {
        this.texto = this.texto + "^";
        lblTexto.setText(this.texto);
    }

    public void botonCuadrado(ActionEvent event) {
        this.texto = this.texto + "^2";
        lblTexto.setText(this.texto);
    }

    //Funciones botones Angulos
    public void botonSin(ActionEvent event) {
        if (this.shift) {
            this.texto = this.texto + "Sin^-1(";
            this.parentesis++;
            lblTexto.setText(this.texto);
        } else {
            this.texto = this.texto + "Sin(";
            this.parentesis++;
            lblTexto.setText(this.texto);
        }
    }

    public void botonCos(ActionEvent event) {
        if (this.shift) {
            this.texto = this.texto + "Cos^-1(";
            this.parentesis++;
            lblTexto.setText(this.texto);
        } else {
            this.texto = this.texto + "Cos(";
            this.parentesis++;
            lblTexto.setText(this.texto);
        }
    }

    public void botonTan(ActionEvent event) {
        if (this.shift) {
            this.texto = this.texto + "Tan^-1(";
            this.parentesis++;
            lblTexto.setText(this.texto);
        } else {
            this.texto = this.texto + "Tan(";
            this.parentesis++;
            lblTexto.setText(this.texto);
        }
    }

    public void botonLn(ActionEvent event) {
        this.texto = this.texto + "Tan(";
        this.parentesis++;
        lblTexto.setText(this.texto);
    }

    public void botonLog(ActionEvent event) {
        this.texto = this.texto + "Tan(";
        lblTexto.setText(this.texto);
    }

    public void botonShift(ActionEvent event) {
        if (this.shift) { //Esta activado
            this.btnCos.setText("Cos");
            this.btnSin.setText("Sin");
            this.btnTan.setText("Tan");
            this.shift = !this.shift;
        }else{
            this.btnCos.setText("Cos^-1");
            this.btnSin.setText("Sin^-1");
            this.btnTan.setText("Tan^-1");
            this.shift = !this.shift;
        }
    }

    //Funciones de botones numericos
    public void botonCero(ActionEvent event){
        this.texto = this.texto + "0";
        lblTexto.setText(this.texto);
    }
    public void botonUno(ActionEvent event){
        this.texto = this.texto + "1";
        lblTexto.setText(this.texto);
    }
    public void botonDos(ActionEvent event){
        this.texto = this.texto + "2";
        lblTexto.setText(this.texto);
    }
    public void botonTres(ActionEvent event){
        this.texto = this.texto + "3";
        lblTexto.setText(this.texto);
    }
    public void botonCuatro(ActionEvent event){
        this.texto = this.texto + "4";
        lblTexto.setText(this.texto);
    }
    public void botonCinco(ActionEvent event){
        this.texto = this.texto + "5";
        lblTexto.setText(this.texto);
    }
    public void botonSeis(ActionEvent event){
        this.texto = this.texto + "6";
        lblTexto.setText(this.texto);
    }
    public void botonSiete(ActionEvent event){
        this.texto = this.texto + "7";
        lblTexto.setText(this.texto);
    }
    public void botonOcho(ActionEvent event){
        this.texto = this.texto + "8";
        lblTexto.setText(this.texto);
    }
    public void botonNueve(ActionEvent event){
        this.texto = this.texto + "9";
        lblTexto.setText(this.texto);
    }

    public void pulsaciones(KeyEvent event) throws IOException {
        switch (event.getText()){
            case "+":
                this.texto = this.texto + "+";
                break;
            case "-":
                this.texto = this.texto + "-";
                break;
            case "/":
                this.texto = this.texto + "/";
                break;
            case "*":
                this.texto = this.texto + "*";
                break;
            case ".":
                this.texto = this.texto + ".";
                break;
            case "0":
                this.texto = this.texto + "0";
                break;
            case "1":
                this.texto = this.texto + "1";
                break;
            case "2":
                this.texto = this.texto + "2";
                break;
            case "3":
                this.texto = this.texto + "3";
                break;
            case "4":
                this.texto = this.texto + "4";
                break;
            case "5":
                this.texto = this.texto + "5";
                break;
            case "6":
                this.texto = this.texto + "6";
                break;
            case "7":
                this.texto = this.texto + "7";
                break;
            case "8":
                if(event.isShiftDown()){
                    this.texto = this.texto + "(";
                    this.parentesis++;
                }else{
                    this.texto = this.texto + "8";
                }
                break;
            case "9":
                if(event.isShiftDown()) {
                    if (this.parentesis > 0) {
                        this.parentesis--;
                        this.texto = this.texto + ")";
                    }
                }else{
                    this.texto = this.texto + "9";
                }
                break;
        }
        this.lblTexto.setText(this.texto);
    }

}
