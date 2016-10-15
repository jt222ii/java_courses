package jt222ii;

import graphs.Node;

import java.util.*;

/**
 * Created by jonastornfors on 2016-09-27.
 */
public class MyGraph<E> implements graphs.DirectedGraph<E>{
    private Map<E, MyNode<E>> item2node;
    private Set<Node<E>> heads;
    private Set<Node<E>> tails;

    public MyGraph()
    {
        item2node = new HashMap<>();
        heads = new HashSet<>();
        tails = new HashSet<>();
    }

    /**
     * Adds a node representing <tt>item</tt> if not added before.
     * Exception is thrown if <tt>item</tt> is null. It returns the
     * node representing <tt>item</tt> (new or previously constructed).
     * @param item,
     * @return Node representing <tt>item</tt>
     */
    @Override
    public Node<E> addNodeFor(E item) {
        if(item == null)
        {
            throw new IllegalArgumentException("Item is null");
        }
        if(!item2node.containsKey(item)) {
            MyNode<E> node = new MyNode<>(item);
            tails.add(node);
            heads.add(node);
            item2node.put(item, node);
            return node;
        }
        else
        {
            return getNodeFor(item);
        }
    }

    /**
     * Returns the node representing <tt>item</tt>.
     * Exception is thrown if <tt>item</tt> is null or if no
     * node representing <tt>item</tt> is found.
     * @param item
     * @return Node representing <tt>item</tt>
     */
    @Override
    public Node<E> getNodeFor(E item) {
        if(item == null || !item2node.containsKey(item))
        {
            throw new IllegalArgumentException();
        }
        return item2node.get(item);
    }

    /**
     * Adds an edge between the nodes represented by <tt>from</tt>
     * and <tt>to</tt>  if not added before. The nodes representing
     * <tt>from</tt> and <tt>to</tt> are added if not added before.
     * Exception is thrown if <tt>from</tt> or <tt>to</tt> is null.
     * It returns <tt>true</tt> if edge not added before, otherwise <tt>false</tt>.
     * @param from, source node
     * @param to, target node
     * @return <tt>true</tt> if edge not added before, otherwise <tt>false</tt>.
     */
    @Override
    public boolean addEdgeFor(E from, E to) {
        if(from == null || to == null)
        {
            throw new RuntimeException("Received null as input");
        }
        MyNode<E> source = (MyNode<E>) addNodeFor(from);
        MyNode<E> target = (MyNode<E>) addNodeFor(to);
        if(source.hasSucc(target))
        {
            return false;
        }
        else
        {
            source.addSucc(target);
            target.addPred(source);
            tails.remove(source);
            heads.remove(target);
        }
        return true;
    }

    /**
     * Returns <tt>true</tt> if the node representing <tt>item</tt> is
     * contained in the graph, otherwise <tt>false</tt>.
     * Exception is thrown if <tt>item</tt> is null.
     * @param item, node to be checked.
     */
    @Override
    public boolean containsNodeFor(E item) {
        if(item == null)
        {
            throw new RuntimeException("Received null as input");
        }
        return item2node.containsKey(item);
    }

    /**
     * Returns the number of nodes in the graph.
     * @return number of nodes
     */
    @Override
    public int nodeCount() {
        return item2node.size();
    }

    /**
     * Returns an iterator over all nodes in the graph.
     * @return graph nodes iterator
     */
    @Override
    public Iterator<Node<E>> iterator() {
        return new item2nodeiterator();
    }

    private class item2nodeiterator implements Iterator<Node<E>>
    {
        int index = 0;
        Object[] nodeArray = item2node.keySet().toArray();
        @Override
        public boolean hasNext() {
            return index < item2node.size();
        }

        @Override
        public Node<E> next() {
            MyNode<E> node = item2node.get(nodeArray[index]);
            index++;
            return node;
        }
    }

    @Override
    public Iterator<Node<E>> heads() {
        //can also use heads.iterator() but I decided to create my own
        return new headsIterator();
    }
    @SuppressWarnings("unchecked cast")
    private class headsIterator implements Iterator<Node<E>>
    {
        int index = 0;
        Object[] nodeArray = heads.toArray();
        @Override
        public boolean hasNext() {
            return index < heads.size();
        }

        @Override
        public Node<E> next() {
            Node<E> node = (Node<E>)nodeArray[index];
            index++;
            return node;
        }
    }

    /**
     * The number of nodes with no in-edges.
     * @return number of head nodes.
     */
    @Override
    public int headCount() {
        return heads.size();
    }

    @Override
    public Iterator<Node<E>> tails() {
        //can also use tails.iterator() but I decided to create my own
        return new tailsIterator();
    }

    private class tailsIterator implements Iterator<Node<E>>
    {
        int index = 0;
        Object[] nodeArray = tails.toArray();

        @Override
        public boolean hasNext() {
            return index < tails.size();
        }

        @Override
        public Node<E> next() {
            Node<E> node = (Node<E>)nodeArray[index++];
            index++;
            return node;
        }
    }

    /**
     * The number of nodes with no out-edges.
     * @return number of head nodes.
     */
    @Override
    public int tailCount() {
        return tails.size();
    }

    @Override
    public List<E> allItems() {
        return new ArrayList<>(item2node.keySet());
    }

    /**
     * Returns the number of graph edges.
     * @return edge count
     */
    @Override
    public int edgeCount() {
        int count = 0;
        for(MyNode<E> node : item2node.values())
        {
            count += node.outDegree();
        }
        return count;
    }

    /**
     * Removes the node represented by <tt>item</item> and
     * all its connecting edges. Exception is thrown if <tt>item</tt>
     * is null  or if no node representing <tt>item</tt> is found.
     *
     * @param item, node to be removed.
     */
    @Override
    public void removeNodeFor(E item) {
        if(item == null || !containsNodeFor(item))
        {
            throw new RuntimeException("Input was null or item does not already exist!");
        }
        //remove from predecessor/successor
        MyNode<E> node = item2node.get(item);
        node.disconnect();
        if(node.isHead())
        {
            heads.remove(node);
        }
        if(node.isTail())
        {
            tails.remove(node);
        }
        item2node.remove(item);
    }

    /**
     * Returns <tt>true</tt> if an edge between the nodes represented
     * by <tt>from</tt> and <tt>to</tt> is added to the graph.
     * Exception is thrown if <tt>from</tt> or <tt>to</tt> is null.
     * @param from, source node item
     * @param to, target node item
     * @return <tt>true</tt> if edge in graph, otherwise <tt>false</tt>.
     */
    @Override
    public boolean containsEdgeFor(E from, E to) {
        if(from == null || to == null)
        {
            throw new RuntimeException("Received null as input");
        }
        if(item2node.containsKey(from) && item2node.containsKey(to)) {
            return item2node.get(from).hasSucc(item2node.get(to));
        }
        return false;

    }

    /**
     * Removes the edge between the nodes represented
     * by <tt>from</tt> and <tt>to</tt> if it exist.
     * Returns <tt>true</tt> if an edge between the nodes represented
     * by <tt>from</tt> and <tt>to</tt>  is found and successfully removed.
     * Exception is thrown if <tt>from</tt> or <tt>to</tt> is null.
     * @param from, source node item
     * @param to, target node item
     * @return <tt>true</tt> if edge in graph and successfully removed, otherwise <tt>false</tt>.
     */
    @Override
    public boolean removeEdgeFor(E from, E to) {
        if(from == null || to == null)
        {
            throw new RuntimeException("Received null as input");
        }
        if(!containsNodeFor(from) || !containsNodeFor(to))
        {
            return false;
        }

        MyNode<E> source = item2node.get(from);
        MyNode<E> target = item2node.get(to);

        if(source.hasSucc(target)) {
            source.removeSucc(target);
            target.removePred(source);
            if(source.outDegree() == 0)
            {
                tails.add(source);
            }
            if(target.inDegree() == 0)
            {
                heads.add(target);
            }
            return true;
        }
        return false;
    }

    /**
     * A textual representation of the graph content (nodes and edges) constructed
     * by applying <tt>toString()</tt> on the nodes.
     *
     */
    @Override
    public String toString()
    {

        String str = "graph [\n";
        for(MyNode<E> node : item2node.values())
        {
            str += "\tnode [\n";
            str += "\t\tid "+node+"\n";
            str += "\t\tlabel "+node+"\n";
            str += "\t]\n";
        }
        for(MyNode<E> node : item2node.values())
        {
            Iterator succIt = node.succsOf();
            while(succIt.hasNext())
            {
                Node target = (Node)succIt.next();
                str += "\tedge [ \n";
                str += "\t\tsource "+node+"\n";
                str += "\t\tsource "+target+"\n";
                str += "\t\tlabel \"edge from node "+node+" to node "+target+"\"\n";
                str += "\t]\n";
            }
        }
        str += "]\n";

        return str;
    }
}
