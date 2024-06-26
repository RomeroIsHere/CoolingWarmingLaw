package com.example.coolingwarminglaw;

import com.example.coolingwarminglaw.Models.Graphic;
import com.example.coolingwarminglaw.Models.LeyEnfriamiento;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML
    private Spinner<Double> txt_tempAmbiente,txt_tempActual,txt_x,txt_fx;

   private LeyEnfriamiento a_ley=new LeyEnfriamiento();

    @FXML
   private BorderPane bp_base;

    private Graphic a_generator=new Graphic();

    @FXML
    private void m_calcular(){
        String v_formula;
        //   try{
            v_formula=a_ley.getA_formula(
                    txt_tempAmbiente.getValue().floatValue(),
                    txt_tempActual.getValue().floatValue(),
                    txt_x.getValue().floatValue(),
                    txt_fx.getValue().floatValue()
            );

            bp_base.setCenter(a_generator.m_geneGraph(v_formula,txt_tempAmbiente.getValue().floatValue()));

       /* }catch (Exception e){
            System.out.println(e.toString());
        m_showMessage("Error","Tecle todos los campos", Alert.AlertType.ERROR);
        }*/





    }


    private void m_showMessage(String p_title, String p_msg, Alert.AlertType p_tipe){
        Alert v_alert=new Alert(p_tipe);
        v_alert.setTitle(p_title);
        v_alert.setContentText(p_msg);
        v_alert.show();
    }








}