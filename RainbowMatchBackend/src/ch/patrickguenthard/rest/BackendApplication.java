package ch.patrickguenthard.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
 

public class BackendApplication  extends Application
{
    private Set<Object> singletons = new HashSet();
    private Set<Class<?>> empty = new HashSet();
 
    public BackendApplication () {
        this.singletons.add(new ExampleRest());
        this.singletons.add(new UserRestService());
        this.singletons.add(new ProfileRestService());
        this.singletons.add(new MatchRestService());
    }
 
    public Set<Class<?>> getClasses() {
        return this.empty;
    }
 
    public Set<Object> getSingletons() {
        return this.singletons;
    }
}

