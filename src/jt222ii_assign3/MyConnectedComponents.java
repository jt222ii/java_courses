package jt222ii_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by jonastornfors on 2016-09-27.
 */
public class MyConnectedComponents<E> implements graphs.ConnectedComponents<E> {
    /**
     * Two nodes a and b are directly connected if their exist an edge (a,b)
     * or an edge (b,a). Two nodes a and k are connected if there exist a sequence
     * of nodes [a,b,c,d, ... j,k] such that [a,b], [b,c], [c,d], [d,e], ..., [j,k]
     * are all directly connected.
     * <p/>
     * Problem: find a partitioning of the graph nodes such that two nodes belongs to the
     * same partitioning if and only if they are connected.
     * </p>
     * The result is a collection of node collections.
     *
     * @author jonasl
     *
     */

    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg)
    {
        Collection<Collection<Node<E>>> col = new LinkedList<>();
        Set<Node<E>> visited = new HashSet<>();
        MyDFS<E> dfs = new MyDFS<>();
        Iterator<Node<E>> itr = dg.heads();
        while(itr.hasNext())
        {
            List<Node<E>> tmpCol = new LinkedList<>();
            Node<E> node = itr.next();
            for(Node<E> n : dfs.dfs(dg, node))
            {
                if(!visited.contains(n)) {
                    visited.add(n);
                    tmpCol.add(n);
                }
            }
            col.add(tmpCol);
        }
        return col;

        /*Iterator<Node<E>> dgIterator = dg.iterator();
        while(dgIterator.hasNext())
        {
            Collection<Node<E>> tmpCol = new LinkedList<>();
            Node<E> n = dgIterator.next();
            if(!visited.contains(n))
            {
                visited.add(n);
                tmpCol.add(n);
                Iterator<Node<E>> succIt = n.succsOf();
                Node<E> succNode;
                while(succIt.hasNext())
                {
                    succNode = succIt.next();
                    visited.add(succNode);
                    tmpCol.add(succNode);
                }
            }
            col.add(tmpCol);
        }*/

        /*for(E item: dg.allItems())
        {
            Node<E> tmp = dg.getNodeFor(item);
        }*/
        //return col;
    }
}
