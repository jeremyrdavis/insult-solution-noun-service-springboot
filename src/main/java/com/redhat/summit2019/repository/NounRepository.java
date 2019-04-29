package com.redhat.summit2019.repository;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import com.redhat.summit2019.model.Noun;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component("nounStore")
public class NounRepository {

    private List<Noun> nouns = new ArrayList<>();

    public NounRepository(){
        try {
            Resource resource = new ClassPathResource("nouns.txt");
            InputStream is = resource.getInputStream();
            if (is != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                reader.lines()
                        .forEach(noun -> nouns.add(new Noun(noun.trim())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Noun getRandomAdjective(){
        return nouns.get(new Random().nextInt(nouns.size()));
    }


}