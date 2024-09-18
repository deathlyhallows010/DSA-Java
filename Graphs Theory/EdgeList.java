/*
 * Where sorting of edges is important - MST
 */

import java.util.ArrayList;


public class EdgeList {
    public static void main(String[] args) {
        ArrayList<int[]> edgeList = new ArrayList<>();

        edgeList.add(new int[]{0, 1});
        edgeList.add(new int[]{1, 2});
        edgeList.add(new int[]{2, 3});

        System.out.println(edgeList);

    }
}
