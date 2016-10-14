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
        Collection<Collection<Node<E>>> toReturn = new HashSet<>();
        Map<Node<E>, Collection<Node<E>>> visited = new HashMap<>();
        Set<Node<E>> toVisit = new HashSet<>();
        MyDFS<E> dfs = new MyDFS<>();
        dg.iterator().forEachRemaining(toVisit::add);
        Iterator<Node<E>> itr = dg.heads();
        while(!toVisit.isEmpty() && itr.hasNext())
        {
            Node<E> head = itr.next();
            if(!visited.containsKey(head)) {
                List<Node<E>> toAdd = new ArrayList<>();
                boolean merge = false;
                Node<E> tmpNode = null;
                List<Node<E>> dfsList = dfs.dfs(dg, head);
                Iterator<Node<E>> iterator = dfsList.iterator();
                while(iterator.hasNext())
                {
                    Node<E> node = iterator.next();
                    if(!visited.containsKey(node)) {
                        toAdd.add(node);
                        visited.put(node, toAdd);
                    }
                    else
                    {
                        merge = true;
                        tmpNode = node;
                    }
                }
                if(merge)
                {
                    visited.get(tmpNode).addAll(toAdd);
                }
                else
                {
                    toReturn.add(toAdd);
                }
                toVisit.removeAll(dfsList);
            }
        }
        itr = toVisit.iterator();
        while(itr.hasNext())
        {
            Node<E> n = itr.next();
            if(!visited.containsKey(n))
            {
                List<Node<E>> dfsList = dfs.dfs(dg, n);
                dfsList.iterator().forEachRemaining(node -> visited.put(node, dfsList));
                toReturn.add(dfsList);
            }
            itr.remove();
        }
        System.out.println(toReturn);
        return toReturn;
    }

   /* @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        Set<Node<E>> visited = new HashSet<>();                                                                             //O(1)
        MyDFS<E> dfs = new MyDFS<>();                                                                                       //O(1)
        Collection<Collection<Node<E>>> toReturn = new HashSet<>();                                                         //O(1)
        LinkedList<HashSet<Node<E>>> collectionToReturn = new LinkedList<>();
        Iterator<Node<E>> nodesItr = dg.iterator();
        while (nodesItr.hasNext()) //iterate through each node in the collection of nodes.                                  //O(V)
        {
            Node<E> n = nodesItr.next(); //next root
            if(!visited.contains(n)) {                                                                                      //O(1)

                List<Node<E>> tmpList = dfs.dfs(dg, n); //add the result of the dfs                                         //O(V+E)

                HashSet<Node<E>> nodesToAdd = new HashSet<>(); //list of the nodes to add to the main list                  //O(1)
                boolean merge = false;                                                                                     //O(1)
                Node<E> tmpNode = null;
                for (Node<E> node : tmpList) //for each node in the temporary list we got from the dfs                      //O(V)
                {
                    if (!visited.contains(node))                                                                            //O(1)
                    {
                        visited.add(node); //add the node to the visited list                                               //O(1)
                        nodesToAdd.add(node);//add the node to the list that will be added to the main list                 //O(1)
                    }
                    else if (node != n) //If the node is not visited and is not the same as the root node                   //O(1)
                    {
                        tmpNode = node;                                                                                     //O(1)
                        merge = true;                                                                                       //O(1)
                    }
                }
                if(merge && tmpNode != null)
                {
                    //add all successors as well
                    for (Node<E> node : nodesToAdd)                                                                         //O(V)
                    {
                        node.succsOf().forEachRemaining(nodesToAdd::add);                                                   //O(E)
                    }
                    for(Collection<Node<E>> col : collectionToReturn) //for each collection in the main collection...       //O(V)
                    {
                        for(Node<E> node : nodesToAdd) //find the collection that already has the node                      //O(V)
                        {
                            if(col.contains(node))
                            {
                                col.addAll(nodesToAdd); //add all the nodes to that collection                              //O(V)
                            }
                        }
                    }
                    //Find and remove the left over collection so that ex: [1,2] merged with [3,4] becomes [1,2,3,4] and not [1,2][1,2,3,4] (Old code bugged with specific cases on this in my own testing)
                    Collection<Node<E>> tempCol = null;
                    for(Collection<Node<E>> col : collectionToReturn)                                                       //O(V)
                    {
                        if(col.equals(nodesToAdd) && col.size() == nodesToAdd.size())                                       //O(1)
                        {
                            tempCol = col;
                            break;
                        }
                    }
                    if(tempCol != null) {
                        collectionToReturn.remove(tempCol);                                                                 //linkedlist deletion O(1)
                    }

                }
                else if(!merge)//If no merge was made create a new collection and add it to the main collection
                {
                    HashSet<Node<E>> nodes = new HashSet<>();                                                               //O(1)
                    nodes.addAll(tmpList);                                                                                  //O(V)
                    collectionToReturn.add(nodes);                                                                          //O(1)
                }
            }
            visited.add(n);//set the root to be visited                                                                     //O(1)
        }
        toReturn.addAll(collectionToReturn);
        return toReturn;                                                                                                     //O(1)
    }*/
}


