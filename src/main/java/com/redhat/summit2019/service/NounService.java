package com.redhat.summit2019.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.redhat.summit2019.model.Noun;
import com.redhat.summit2019.repository.NounRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("/noun")
@Component
public class NounService {

    @Autowired
    private NounRepository nounStore;
    
    @GET
    @Produces("application/json")
    public Noun adjective() {
        return nounStore.getRandomAdjective();
    }
}