package main.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javafx.scene.control.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable {

    private Stage prevStage;
    private double cantidad1;
    private double cantidad2;
    private double resultado = 0;

    private String texto1 = "";
    private String tipo_operacion = "";
    private boolean shift = false;

    private boolean comenzado=true, igual=false, operacion1=false, operacion2 = false;

    //Declaracion de botones
    @FXML
    private Label lblTexto;
    public Label lblTexto1;
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
    public void botonPunto() {
        if(!this.lblTexto.getText().contains(".")){
            lblTexto.setText(lblTexto.getText() + ".");
            this.comenzado=false;
        }
    }

    public void botonSuma() {
        this.comenzado = true;
        this.igual = true;
        //Verificar si ya existe alguna otra operacion
        if(operacion1 = true){
            cantidad1 = Double.parseDouble(this.lblTexto.getText());
            this.lblTexto1.setText("");
            this.lblTexto1.setText(lblTexto.getText() + "+");
            operacion1 = false;
        }else{
            if(operacion2 = true){
                this.cantidad2 = Double.parseDouble(this.lblTexto.getText());
                this.lblTexto1.setText(lblTexto.getText() + "+");
                operacion2 = false;
            }else{
                this.lblTexto1.setText(this.lblTexto.getText() + "+");
                realizarOperacion(resultado, this.cantidad2);
            }
        }
        tipo_operacion = "+";
    }

    public void botonResta() {
        this.comenzado = true;
        this.igual = true;
        //Verificar si ya existe alguna otra operacion
        if(operacion1 = true){
            cantidad1 = Double.parseDouble(this.lblTexto.getText());
            this.lblTexto1.setText("");
            this.lblTexto1.setText(lblTexto.getText() + "-");
            operacion1 = false;
        }else{
            if(operacion2 = true){
                this.cantidad2 = Double.parseDouble(this.lblTexto.getText());
                this.lblTexto1.setText(lblTexto.getText() + "-");
                operacion2 = false;
            }else{
                this.lblTexto1.setText(this.lblTexto.getText() + "-");
                realizarOperacion(resultado, this.cantidad2);
            }
        }
        tipo_operacion = "-";
    }

    public void botonMultiplicacion() {
        this.comenzado = true;
        this.igual = true;
        //Verificar si ya existe alguna otra operacion
        if(operacion1 = true){
            cantidad1 = Double.parseDouble(this.lblTexto.getText());
            this.lblTexto1.setText("");
            this.lblTexto1.setText(lblTexto.getText() + "*");
            operacion1 = false;
        }else{
            if(operacion2 = true){
                this.cantidad2 = Double.parseDouble(this.lblTexto.getText());
                this.lblTexto1.setText(lblTexto.getText() + "*");
                operacion2 = false;
            }else{
                this.lblTexto1.setText(this.lblTexto.getText() + "*");
                realizarOperacion(resultado, this.cantidad2);
            }
        }
        tipo_operacion = "*";
    }

    public void botonDivision() {
        this.comenzado = true;
        this.igual = true;
        //Verificar si ya existe alguna otra operacion
        if(operacion1 = true){
            cantidad1 = Double.parseDouble(this.lblTexto.getText());
            this.lblTexto1.setText("");
            this.lblTexto1.setText(lblTexto.getText() + "/");
            operacion1 = false;
        }else{
            if(operacion2 = true){
                this.cantidad2 = Double.parseDouble(this.lblTexto.getText());
                this.lblTexto1.setText(lblTexto.getText() + "/");
                operacion2 = false;
            }else{
                this.lblTexto1.setText(this.lblTexto.getText() + "/ ");
                realizarOperacion(resultado, this.cantidad2);
            }
        }
        tipo_operacion = "/";
    }

    public void botonRaiz() {
        cantidad1 = Double.parseDouble(lblTexto.getText());
        if(cantidad1 >= 0){
            lblTexto1.setText("√"+cantidad1);
            lblTexto.setText(Math.sqrt(cantidad1) + " ");
        }else{
            lblTexto1.setText("");
            lblTexto.setText("Math error");
        }
    }

    public void botonExponente(ActionEvent event) {
        comenzado = true;
        cantidad1 = Double.parseDouble(lblTexto.getText());
        lblTexto.setText("");
        lblTexto1.setText(cantidad1 + "^");
        tipo_operacion = "^";
        operacion1 = false;
        igual = true;
    }

    public void botonCuadrado(ActionEvent event) {
        cantidad1 = Double.parseDouble(lblTexto.getText());
        lblTexto1.setText(cantidad1 + "^2");
        lblTexto.setText(Math.pow(cantidad1, 2) + "");
    }

    public void botonFactorial(){
        int a = 1;
        cantidad1 = Double.parseDouble(lblTexto.getText());
        lblTexto1.setText(cantidad1 + "!");
        for(int i=1; i <= cantidad1; i++){
            a = a * i;
        }
        lblTexto.setText(cantidad1 + "");
    }

    public void botonPI(){
        lblTexto.setText(3.1416 + "");
    }

    //Funciones botones Angulos
    public void botonSin(ActionEvent event) {
        if (this.shift) {
            cantidad1 = Double.parseDouble(lblTexto.getText());
            System.out.println(cantidad1);
            lblTexto1.setText("sin^-1( " + cantidad1 + " )");
            double sin = Math.asin(cantidad1)*180/Math.PI;
            lblTexto.setText(sin + " ");
        } else {
            cantidad1 = Double.parseDouble(lblTexto.getText());
            System.out.println(cantidad1);
            lblTexto1.setText("sin( " + cantidad1 + " )");
            double sin = Math.sin(Math.PI*(cantidad1)/180);
            lblTexto.setText(sin + " ");
        }
    }

    public void botonCos(ActionEvent event) {
        if (this.shift) {
            cantidad1 = Double.parseDouble(lblTexto.getText());
            lblTexto1.setText("cos^-1( " + cantidad1 + " )");
            double cos = Math.acos(cantidad1)*180/Math.PI;
            lblTexto.setText(cos + " ");
        } else {
            cantidad1 = Double.parseDouble(lblTexto.getText());
            lblTexto1.setText("cos( " + cantidad1 + " )");
            double cos = Math.cos(Math.PI*(cantidad1)/180);
            lblTexto.setText(cos + " ");
        }
    }

    public void botonTan(ActionEvent event) {
        if (this.shift) {
            cantidad1 = Double.parseDouble(lblTexto.getText());
            lblTexto1.setText("tan^-1( " + cantidad1 + " )");
            double tan = Math.atan(cantidad1)*180/Math.PI;
            lblTexto.setText(tan + " ");
        } else {
            cantidad1 = Double.parseDouble(lblTexto.getText());
            lblTexto1.setText("tan( " + cantidad1+ " )");
            double tan = Math.tan(Math.PI*(cantidad1)/180);
            lblTexto.setText(tan + " ");
        }
    }

    public void botonExponente10(){

    }

    public void botonLog(ActionEvent event) {
        cantidad1 = Double.parseDouble(lblTexto.getText());
        lblTexto1.setText("log( " + cantidad1 + " )");
        lblTexto.setText(Math.log(cantidad1) + "");
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

    public void botonParentesis1(){
        if(this.comenzado){
            lblTexto.setText("");
            lblTexto.setText("(");
            this.comenzado=false;
        }else{
            lblTexto.setText(lblTexto.getText() + "(");
        }
    }

    public void botonParentesis2(){
        if(this.comenzado){
            lblTexto.setText("");
            lblTexto.setText(")");
            this.comenzado=false;
        }else{
            lblTexto.setText(lblTexto.getText() + ")");
        }
    }

    public void botonCambioSigno(){
        double numero1 = 0;
        double numero2 = Double.parseDouble(lblTexto.getText());
        double numero3 = numero1 - numero2;
        lblTexto1.setText(String.valueOf(numero3));
    }

    public void botonC(){
        lblTexto.setText("0");
        lblTexto1.setText("");
        comenzado = true;
        tipo_operacion = "";
        cantidad1 = 0;
        cantidad2 = 0;
        resultado = 0;
        operacion1 = true;
        operacion2 = true;
        igual = true;
    }

    public void botonCE(){
        lblTexto.setText("0");
        lblTexto1.setText("");
        comenzado = true;
        tipo_operacion = "";
    }

    //Funciones de botones numericos
    public void botonCero(){
        if(this.comenzado){
            lblTexto.setText("");
            lblTexto.setText("0");
            this.comenzado=false;
        }else{
            lblTexto.setText(lblTexto.getText() + "0");
        }
    }
    public void botonUno(){
        if(this.comenzado){
            lblTexto.setText("");
            lblTexto.setText("1");
            this.comenzado=false;
        }else{
            lblTexto.setText(lblTexto.getText() + "1");
        }
    }
    public void botonDos(){
        if(this.comenzado){
            lblTexto.setText("");
            lblTexto.setText("2");
            this.comenzado=false;
        }else{
            lblTexto.setText(lblTexto.getText() + "2");
        }
    }
    public void botonTres(){
        if(this.comenzado){
            lblTexto.setText("");
            lblTexto.setText("3");
            this.comenzado=false;
        }else{
            lblTexto.setText(lblTexto.getText() + "3");
        }
    }
    public void botonCuatro(){
        if(this.comenzado){
            lblTexto.setText("");
            lblTexto.setText("4");
            this.comenzado=false;
        }else{
            lblTexto.setText(lblTexto.getText() + "4");
        }
    }
    public void botonCinco(){
        if(this.comenzado){
            lblTexto.setText("");
            lblTexto.setText("5");
            this.comenzado=false;
        }else{
            lblTexto.setText(lblTexto.getText() + "5");
        }
    }
    public void botonSeis(){
        if(this.comenzado){
            lblTexto.setText("");
            lblTexto.setText("6");
            this.comenzado=false;
        }else{
            lblTexto.setText(lblTexto.getText() + "6");
        }
    }
    public void botonSiete(){
        if(this.comenzado){
            lblTexto.setText("");
            lblTexto.setText("7");
            this.comenzado=false;
        }else{
            lblTexto.setText(lblTexto.getText() + "7");
        }
    }
    public void botonOcho(){
        if(this.comenzado){
            lblTexto.setText("");
            lblTexto.setText("8");
            this.comenzado=false;
        }else{
            lblTexto.setText(lblTexto.getText() + "8");
        }
    }
    public void botonNueve(){
        if(this.comenzado){
            lblTexto.setText("");
            lblTexto.setText("9");
            this.comenzado=false;
        }else{
            lblTexto.setText(lblTexto.getText() + "9");
        }
    }

    public void pulsaciones(KeyEvent event) throws IOException {
        if(event.getCode().toString() == "ENTER"){
            btnIgual();
        }
        switch (event.getText()){
            case "+":
                botonSuma();
                break;
            case "-":
                botonResta();
                break;
            case "/":
                botonDivision();
                break;
            case "*":
                botonMultiplicacion();
                break;
            case ".":
                botonPunto();
                break;
            case "0":
                botonCero();
                break;
            case "1":
                botonUno();
                break;
            case "2":
                botonDos();
                break;
            case "3":
                botonTres();
                break;
            case "4":
                botonCuatro();
                break;
            case "5":
                botonCinco();
                break;
            case "6":
                botonSeis();
                break;
            case "7":
                botonSiete();
                break;
            case "8":
                if(event.isShiftDown()){
                    botonParentesis1();
                }else{
                    botonOcho();
                }
                break;
            case "9":
                if(event.isShiftDown()) {
                    botonParentesis2();
                }else{
                    botonNueve();
                }
                break;
        }
    }

    //Creacion de codigo igual
    public void btnIgual(){
        comenzado = true;
        operacion1 = true;
        if(igual == true){
            if(tipo_operacion != null){
                cantidad2 = Double.parseDouble(lblTexto.getText());
                lblTexto1.setText(lblTexto1.getText() + lblTexto.getText());
                realizarOperacion(cantidad1, cantidad2);
                igual = false;
            }
        }else{
            lblTexto1.setText("");
            realizarOperacion(cantidad1, cantidad2);
        }
    }

    public void botonBorrar(){
        if(lblTexto.getText().length() > 0){
            lblTexto.setText((lblTexto.getText().substring(0, lblTexto.getText().length() - 1)));
            if(lblTexto.getText().length() == 0){
                lblTexto.setText("0");
                comenzado = true;
            }
        }
    }

    public void realizarOperacion(double valor1, double valor2){
        switch (tipo_operacion){
            case "+":
                resultado = valor1 + valor2;
                lblTexto.setText(resultado + "");
                valor1 = Double.parseDouble(lblTexto.getText());
                break;
            case "-":
                resultado = valor1 - valor2;
                lblTexto.setText(resultado + "");
                valor1 = Double.parseDouble(lblTexto.getText());
                break;
            case "*":
                resultado = valor1 * valor2;
                lblTexto.setText(resultado + "");
                valor1 = Double.parseDouble(lblTexto.getText());
                break;
            case "/":
                if(valor2 == 0){
                    lblTexto.setText("Math error");
                }
                resultado = valor1 + valor2;
                lblTexto.setText(resultado + " ");
                valor1 = Double.parseDouble(lblTexto.getText());
                break;
            case "^":
                resultado = Math.pow(valor1, valor2);
                lblTexto.setText(resultado + "");
                break;
        }
    }
}
