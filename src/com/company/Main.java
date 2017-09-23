package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Point
    {
        double x,y;
        Point(double x,double y)
        {
            this.x=x;
            this.y=y;
        }
    }

    private static double getDistance(Point p1, Point p2)
    {
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
    }

    private static ArrayList<Point> takeInput()
    {
        int numberOfPoints;
        ArrayList<Point> points = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of points: ");
        numberOfPoints = scanner.nextInt();
        if(numberOfPoints<3)
        {
            System.out.println("Minimum 3 points required");
            System.exit(1);
        }
        System.out.println("Enter the points ");
        for(int i=0;i<numberOfPoints;i++)
        {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points.add(new Point(x,y));
        }
        return points;
    }

    private static void printResult(ArrayList<Point> points)
    {
        for(int i=0;i<points.size();i++)
        {
            double l = Double.MAX_VALUE,sl = Double.MAX_VALUE,tl=Double.MAX_VALUE;
            int li=i,si=i,ti=i;
            for(int j=0;j<points.size();j++)
            {
                if(i==j)
                    continue;
                double dist = getDistance(points.get(i),points.get(j));

                if(dist<=l)
                {
                    tl=sl;
                    sl=l;
                    l=dist;
                    ti=si;
                    si=li;
                    li=j;
                    continue;
                }

                if(dist<=sl)
                {
                    tl=sl;
                    sl=dist;
                    ti=si;
                    si=j;
                    continue;
                }

                if(dist<tl)
                {
                    tl=dist;
                    ti=j;
                    continue;
                }
            }
            li++;
            si++;
            ti++;

            System.out.println(i+1 + " " + li + "," + si +","+ti);
        }
    }

    public static void main(String[] args) {
        ArrayList<Point> points = takeInput();
        printResult(points);

    }
}
