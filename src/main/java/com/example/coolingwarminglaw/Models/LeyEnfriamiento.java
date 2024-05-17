package com.example.coolingwarminglaw.Models;

import java.text.DecimalFormat;

public class LeyEnfriamiento {

    private DecimalFormat a_format;

    public LeyEnfriamiento() {
        a_format=new DecimalFormat("0.00000");
    }
    public String getA_formula(float p_tempAmbiente,float p_tempActual,float p_x,float p_fx) {
        String v_formula;
        String v_valoC;
        v_formula="f(t)=T+Ce^kt";

        v_valoC=m_getC(p_tempActual,p_tempAmbiente);
        v_formula=v_formula.replace("C",m_setFormormat(v_valoC)).replace("k",m_setFormormat(m_getK(Float.parseFloat(v_valoC),p_tempAmbiente,p_tempActual,p_x,p_fx))).replace("T",m_setFormormat(p_tempAmbiente+""));

        return v_formula;
    }


    private String m_getC(float p_tempFinal,float p_tempAmbiente){
        float v_respuesta;
        v_respuesta=p_tempFinal-p_tempAmbiente;

        return a_format.format(v_respuesta);
    }


    private String m_getK(float p_valoC,float p_tempAmbiente,float p_tempActual,float p_x,float p_fx){
        float v_respuesta;
        v_respuesta=(float) Math.log((p_fx-p_tempAmbiente)/p_valoC)/p_x;

        return a_format.format(v_respuesta);
    }


    private String m_setFormormat(String p_number){
        String v_respuesta;

        if((int)Float.parseFloat(p_number)-Float.parseFloat(p_number)==0)
         v_respuesta=(Float.parseFloat(p_number)+"").replace(".0","");
        else
           v_respuesta=Float.parseFloat(p_number)+"";

        return v_respuesta;
    }




}
