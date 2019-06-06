package com.dad.jokes.model;

import javax.persistence.*;

@Entity
@Table(name="randomJokes")
public class RandomJoke {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jokeid;

    @Column(nullable = false)
    private String randomJoke;

    public RandomJoke(){ }

    public RandomJoke(String randomJoke)
    {
        this.randomJoke = randomJoke;
    }

    public long getJokeid()
    {
        return jokeid;
    }

    public void setJokeid(long jokeid)
    {
        this.jokeid = jokeid;
    }

    public String getRandomJoke()
    {
        return randomJoke;
    }

    public void setRandomJoke(String randomJoke)
    {
        this.randomJoke = randomJoke;
    }
}
