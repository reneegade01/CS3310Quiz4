package cs3310quiz4problem2;

import java.util.ArrayList;
import java.util.HashMap;

/*
CS 3310 Section 2 
S. Renee Eller 
Quiz #4
*/ 

public class Project
    {
        private ArrayList<Project> children = new ArrayList<Project>();
        private HashMap<String, Project> map = new HashMap<String, Project>();
        public String name;
        private int dependencies = 0;
        
        public Project(String n)
        { 
            name = n; 
        }

    Project(Project node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
        
        public void addNeighbor(Project node)
        {
            if(!map.containsKey(node.getName()))
            {
                children.add(node);
                node.incrementDependencies();
            }
        }
        
        public void incrementDependencies() 
        {
            ++dependencies;
        }
        
        public void decrementDependencies()
        {
            --dependencies;
        }
        
        public String getName()
        {
            return name;
        }
        
        public ArrayList<Project> getChildren()
        {
            return children;
        }
        
        public int getNumberDependencies() 
        {
            return dependencies;
        }
    }