package jt222ii_assign3;

/**
 * Created by jonastornfors on 2016-09-29.
 */
public class TestShit {
    public static void main(String[] args) {
        MyGraph<String> graph = new MyGraph<>();

        /*graph.addEdgeFor("a", "b");
        graph.addEdgeFor("b", "c");
        graph.addEdgeFor("c", "d");
        graph.addEdgeFor("c", "e");
        System.out.println(graph.toString());
        MyGML<String> gml = new MyGML<>(graph);

        gml.dumpGML();*/

        graph.addEdgeFor("a", "c");
        graph.addEdgeFor("a", "b");
        graph.addEdgeFor("b", "d");
        graph.addEdgeFor("c", "d");
        graph.addEdgeFor("d", "e");
        graph.addEdgeFor("d", "f");
        graph.addEdgeFor("e", "g");
        graph.addEdgeFor("e", "f");

        MyDFS dfs = new MyDFS();
        System.out.println(dfs.dfs(graph));
        System.out.println(dfs.postOrder(graph));
        System.out.println(dfs.topSort(graph));
    }
}
