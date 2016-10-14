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
        Set<Node<E>> visited = new HashSet<>();                                                                             //O(1)
        MyDFS<E> dfs = new MyDFS<>();                                                                                       //O(1)
        Collection<Collection<Node<E>>> collectionToReturn = new HashSet<>();                                               //O(1)


        Iterator<Node<E>> nodesItr = dg.iterator();
        while (nodesItr.hasNext()) //iterate through each node in the collection of nodes.                                  //O(V)
        {
            Node<E> n = nodesItr.next(); //next root
            if(!visited.contains(n)) {                                                                                      //O(1)

                List<Node<E>> tmpList = dfs.dfs(dg, n); //add the result of the dfs                                         //O(V+E)

                HashSet<Node<E>> nodesToAdd = new HashSet<>(); //list of the nodes to add to the main list                  //O(1)

                boolean merged = false;                                                                                     //O(1)
                for (Node<E> node : tmpList) //for each node in the temporary list we got from the dfs                      //O(V)
                {
                    if (!visited.contains(node))                                                                            //O(1)
                    {
                        visited.add(node); //add the node to the visited list                                               //O(1)
                        nodesToAdd.add(node);//add the node to the list that will be added to the main list                 //O(1)
                    }
                    else if (node != n) //If the node is not visited and is not the same as the root node                   //O(1)
                    {
                        for(Collection<Node<E>> col : collectionToReturn) //for each collection in the main collection...   //O(V)
                        {
                            if(col.contains(node))//...see if the collection contains the new node                          //O(1)
                            {
                                //If col contains node merge the collections.
                                merged = true;                                                                              //O(1)
                                //foreach node in the nodesToAdd collection add the nodes that doesnt already exist in col to col
                                for (Node<E> nodeToAdd : nodesToAdd)                                                        //O(V)
                                {
                                    if(!col.contains(nodeToAdd))                                                            //O(1)
                                    {
                                        col.add(nodeToAdd);                                                                 //O(1)
                                    }
                                }
                                visited.addAll(nodesToAdd);//set all nodes that were added to be visited                    //O(V)
                            }
                        }
                    }
                }
                if(!merged)//If no merge was made create a new collection and add it to the main collection
                {
                    HashSet<Node<E>> nodes = new HashSet<>();                                                               //O(1)
                    nodes.addAll(tmpList);                                                                                  //O(V)
                    visited.addAll(tmpList);                                                                                //O(V)
                    collectionToReturn.add(nodes);                                                                          //O(1)
                }
            }
            visited.add(n);//set the root to be visited                                                                     //O(1)
        }
        return collectionToReturn;                                                                                          //O(1)
    }
}


