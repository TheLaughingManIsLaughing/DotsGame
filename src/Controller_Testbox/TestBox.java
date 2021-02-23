import src.DotT;
import src.PointT;
import src.Board2D;
import src.ViewBoard;

import java.util.ArrayList;
import java.util.Arrays;

public class TestBox {
    public static void main (String[] args) {

        ArrayList<ArrayList<DotT>> b = new ArrayList<>();
        b.add(new ArrayList<DotT>(Arrays.asList(DotT.R, DotT.B, DotT.Y, DotT.G, DotT.P, DotT.R)));
        b.add(new ArrayList<DotT>(Arrays.asList(DotT.G, DotT.B, DotT.B, DotT.G, DotT.P, DotT.R)));
        b.add(new ArrayList<DotT>(Arrays.asList(DotT.R, DotT.B, DotT.Y, DotT.G, DotT.P, DotT.R)));
        b.add(new ArrayList<DotT>(Arrays.asList(DotT.R, DotT.G, DotT.Y, DotT.G, DotT.P, DotT.R)));
        b.add(new ArrayList<DotT>(Arrays.asList(DotT.R, DotT.G, DotT.Y, DotT.G, DotT.P, DotT.R)));
        b.add(new ArrayList<DotT>(Arrays.asList(DotT.R, DotT.G, DotT.Y, DotT.G, DotT.P, DotT.R)));

        Board2D dotGame = new Board2D();
        ArrayList<PointT> points = new ArrayList<>();
        points.add(new PointT(1,2));
        points.add(new PointT(1,1));
        points.add(new PointT(2,1));

        ViewBoard view = new ViewBoard();
        view.printBoard(b);

        /*
        for (int i = 0; i < b.size(); i++) {
            System.out.println(dotGame.getBoard().get(i));
        }

        System.out.println(dotGame.validPointList(points));
        dotGame.clearDots(points);

        for (int i = 0; i < b.size(); i++) {
            System.out.println(dotGame.getBoard().get(i));
        }

        System.out.println("--------");

        dotGame.moveNulls();
        for (int i = 0; i < b.size(); i++) {
            System.out.println(dotGame.getBoard().get(i));
        }

        System.out.println("--------");
        dotGame.fillNulls();
        for (int i = 0; i < b.size(); i++) {
            System.out.println(dotGame.getBoard().get(i));
        }

         */
    }
}
