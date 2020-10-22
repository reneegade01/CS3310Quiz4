package cs3310quiz4problem2;

import java.util.ArrayList;

/*
S. Renee Eller
CS 3310 Section 2 
Quiz #4
 */

public class CS3310Quiz4Problem2
{

    public static void main(String[] args)
    {
        String[] variables = {"a", "b", "c", "d", "e", "f"}; 
        String[][] dependencies = { {"d", "c"}, {"f", "e"}, {"a", "d"}, {"c", "a"}, {"b", "c"}};
        Project[] buildOrder = findBuildOrder(variables, dependencies);
       
        for (int i = 0; i < buildOrder.length; i++)
        {
            System.out.println(buildOrder[i].getName() + " ");      
        }      
    }
    
    public static Project[] findBuildOrder(String[] projects, String[][] dependencies)
    {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }
    
    public static Graph buildGraph(String[] projects, String[][] dependencies)
    {
        Graph graph = new Graph();
        for (String project : projects)
        {
            graph.getOrCreateNode(project);    
        }
        for (String[] dependency : dependencies)
        {
            String dependency1 = dependency[0];
            String dependency2 = dependency[1];
            graph.addEdge(dependency1, dependency2);    
        }
        return graph;
    }
    
    public static Project[] orderProjects(ArrayList<Project> projects)
    {
        Project[] order = new Project[projects.size()];
        int endOfList = addNonDependent(order, projects, 0);
        int notYetProcessed = 0;
        while(notYetProcessed < order.length)
        {
            Project current = order[notYetProcessed];
            if (current == null)
            {
                return null; // circular dependency, there are no remaining projects with zero dependencies                
            }
            ArrayList<Project> children = current.getChildren(); // remove current as dependency
            for (Project child : children)
            {
                child.decrementDependencies();                
            }
            endOfList = addNonDependent(order, children, endOfList); // add children that have no one depending on them
            ++notYetProcessed;
        }
        return order;
    }
    
    // insert projects w/ 0 dependencies into the order array
    public static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) 
    {
        for(Project project : projects)
            if (project.getNumberDependencies() == 0)
                order[offset] = project; ++offset;
        return offset;
    }
}
