package ir.ac.kntu;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;

public class RecursiveGUI {

    public RecursiveGUI() {
    }

    public void shape(Pane pane,int iterations,double length,double angle,double width,double height){
        angle=angle*3.14/180;
        double rotation = 1.04;
        int count=0;
        ArrayList<Double> tempPoints= drawDiamond(pane,width/2, height*2/3, length,rotation,count);
        ArrayList<Double> nextPoints = new ArrayList<>(tempPoints);
        for(int i=0;i<iterations;i++){
            length = length/ 1.8;
            for(int k=0;k<Math.pow(3,i);k++) {
                tempPoints=drawDiamond(pane,nextPoints.get(0),nextPoints.get(1),length,nextPoints.get(6)-angle,count);
                nextPoints.addAll(tempPoints);
                tempPoints=drawDiamond(pane,nextPoints.get(2),nextPoints.get(3),length,nextPoints.get(6)+angle,count);
                nextPoints.addAll(tempPoints);
                tempPoints = drawDiamond(pane, nextPoints.get(4), nextPoints.get(5),length,nextPoints.get(6),count);
                nextPoints.addAll(tempPoints);
                nextPoints.remove(0);
                nextPoints.remove(0);
                nextPoints.remove(0);
                nextPoints.remove(0);
                nextPoints.remove(0);
                nextPoints.remove(0);
                nextPoints.remove(0);
            }
            count+=184/iterations;
        }

    }


    public ArrayList<Double> drawDiamond(Pane pane, double x, double y, double length, double rotate, int count){
        double x1 = x + length * java.lang.Math.cos(rotate);
        double y1 = y - length * java.lang.Math.sin(rotate);
        double x2 = x + length * java.lang.Math.cos(rotate +1.05);
        double y2 = y - length * java.lang.Math.sin(rotate +1.05);
        Polygon firstPolygon = new Polygon();
        firstPolygon.getPoints().addAll(new Double[]{x, y, x1, y1, x2, y2 });
        firstPolygon.setFill(Color.rgb(66+count,104,124));
        double middleX = (x1+x2)/2;
        double x3 = (middleX-x) + middleX;
        double middleY = (y1+y2)/2;
        double y3 = (middleY-y) + middleY;
        Polygon secondPolygon = new Polygon();
        secondPolygon.getPoints().addAll(new Double[]{x1, y1, x2, y2, x3, y3 });
        secondPolygon.setFill(Color.rgb(66+count,104,124));
        ArrayList<Double> points=new ArrayList<>();
        points.add(x1);
        points.add(y1);
        points.add(x2);
        points.add(y2);
        points.add(x3);
        points.add(y3);
        points.add(rotate);
        pane.getChildren().addAll(firstPolygon,secondPolygon);
        return points;
    }
}