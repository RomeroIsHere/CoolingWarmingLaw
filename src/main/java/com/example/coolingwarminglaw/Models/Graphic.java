package com.example.coolingwarminglaw.Models;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;

public class Graphic {


    public LineChart m_geneGraph(String p_formula, float p_ambiente){
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        int v_contador=0;
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Enfriamiento de la sustancia");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("p_formula");
        //populating the series with data

        xAxis.setLabel("Tiempo (s)");
        yAxis.setLabel("Temperatura c°");

      for(Float v_dato:m_getValues(p_formula.replace("f(t)=","").replace("t","x").replace("e^","exp(")+")",p_ambiente)) {
          System.out.println(v_dato);
          series.getData().add(new XYChart.Data(v_contador++, v_dato));
      }


        lineChart.getData().add(series);

        return lineChart;
    }


    private List<Float> m_getValues(String p_formula,float p_final){
      List<Float> v_respuesta=new ArrayList<>();
      int v_contador;
      v_contador=0;
      Funtion v_funtion=new Funtion();
       v_funtion.m_cargFuncion(p_formula);
        System.out.println(p_formula);
        int limit=3000;
        do{
            v_respuesta.add(Float.parseFloat(v_funtion.m_evaluar(v_contador++)));
        }while (v_respuesta.getLast()>p_final&&v_contador<limit);

        return v_respuesta;
    }


}
