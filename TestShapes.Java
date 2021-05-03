package com.company;

import com.company.Circle;
import com.company.Rectangle;
import com.company.Shape;
import com.company.Triangle;

import java.text.DecimalFormat;
import java.util.ArrayList;

class TestShapes {

    public static void main(String[] args) {

        /*
            1.Create the reference of Shape interface and
              remember that we can not create object of interface.
        */
        //create Shape reference for Circle class
        Shape circle = new Circle(2.5);

        //create Shape reference for Rectangle class
        Shape rectangle = new Rectangle(3.15, 2.17);

        //create Shape reference for Triangle class
        Shape triangle = new Triangle(2.5, 3.7, 7.9);


        /*
           2.Store all the shape references
             to the ArrayList
        */
        ArrayList<Shape> shapeList = new ArrayList<>();
        shapeList.add(circle);
        shapeList.add(rectangle);
        shapeList.add(triangle);


        /*
           3.create DecimalFormate class object
             to set two decimal point for the
             result of area and perimeter
        */
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);


        /*
            4.Now print the area and perimeter of all
              classes using the foreach loop
        */
        for (Shape shape : shapeList) {

            //print the class name with area
            System.out.println(shape.getClass().getSimpleName() + " area : " + df.format(shape.area()));

            //print the class name with perimeter
            System.out.println(shape.getClass().getSimpleName() + " perimeter : " + df.format(shape.perimeter()));

            System.out.println();
        }
    }
}