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
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        Set<Node<E>> visited = new HashSet<>();
        MyDFS<E> dfs = new MyDFS<>();
        Collection<Collection<Node<E>>> collectionToReturn = new HashSet<>();


        Iterator<Node<E>> nodesItr = dg.iterator();
        while (nodesItr.hasNext()) //iterate through each node in the collection of nodes.
        {
            Node<E> n = nodesItr.next(); //next root
            if(!visited.contains(n)) {

                List<Node<E>> tmpList = dfs.dfs(dg, n); //add the result of the dfs

                HashSet<Node<E>> nodesToAdd = new HashSet<>(); //list of the nodes to add to the main list

                boolean merged = false;
                for (Node<E> node : tmpList) //for each node in the temporary list we got from the dfs
                {
                    if (!visited.contains(node))
                    {
                        visited.add(node); //add the node to the visited list
                        nodesToAdd.add(node);//add the node to the list that will be added to the main list
                    }
                    else if (node != n) //If the node is not visited and is not the same as the root node
                    {
                        for(Collection<Node<E>> col : collectionToReturn) //for each collection in the main collection...
                        {
                            if(col.contains(node))//...see if the collection contains the new node
                            {
                                //If col contains node merge the collections.
                                merged = true;
                                for (Node<E> nodeToAdd : nodesToAdd)//foreach node in the nodesToAdd collection add the nodes that doesnt already exist in col to col
                                {
                                    if(!col.contains(nodeToAdd))
                                    {
                                        col.add(nodeToAdd);
                                    }
                                }
                                visited.addAll(nodesToAdd);//set all nodes that were added to be visited
                            }
                        }
                    }
                }
                if(!merged)//If no merge was made create a new collection and add it to the main collection
                {
                    HashSet<Node<E>> nodes = new HashSet<>();
                    nodes.addAll(tmpList);
                    visited.addAll(tmpList);
                    collectionToReturn.add(nodes);
                }
            }
            visited.add(n);//set the root to be visited
        }
        return collectionToReturn;
    }
}


