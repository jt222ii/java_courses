package jt222ii_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by jonastornfors on 2016-09-27.
 */
public class MyGML<E> extends graphs.GML<E> {
    public MyGML(DirectedGraph dg) {
        super(dg);
    }

    /**
     * The GML mark-up string constructor.
     */
    @Override
    public String toGML() {
        Map<Node<E>, Integer> map = new HashMap<>();//used to store ids for the nodes to use for the targets

        int index = 0;
        String str = "graph \n[\n";
        for(E item : graph.allItems())
        {
            map.put(graph.getNodeFor(item), index);
            str += "\tnode \n\t[\n";
            str += "\t\tid "+index+"\n";
            str += "\t\tlabel \""+item+"\"\n";
            str += "\t]\n";
            index++;
        }
        for(E item : graph.allItems())
        {
            Node<E> node = graph.getNodeFor(item);
            Iterator succIt = node.succsOf();
            while(succIt.hasNext())
            {
                Node target = (Node)succIt.next();
                str += "\tedge \n\t[ \n";
                str += "\t\tsource "+map.get(node)+"\n";
                str += "\t\ttarget "+map.get(target)+"\n";
                //str += "\t\tlabel \"edge from node "+node+" to node "+target+"\"\n";
                str += "\t]\n";
            }
            index++;
        }
        str += "]\n";

        return str;
    }
}
