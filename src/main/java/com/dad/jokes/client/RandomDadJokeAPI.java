package com.dad.jokes.client;

import com.dad.jokes.model.RandomJoke;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

    public class RandomDadJokeAPI
    {
        public ArrayList<RandomJoke> readJokes()
        {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try
            {
                URL restAPIUrl = new URL("https://icanhazdadjoke.com");
                connection = (HttpURLConnection) restAPIUrl.openConnection();
                connection.setRequestMethod("GET");

                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder jsonData = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null)
                {
                    jsonData.append(line);
                }

                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                ArrayList<RandomJoke> randJoke =
                        objectMapper.readValue(jsonData.toString(), new TypeReference<ArrayList<RandomJoke>>(){});

                return randJoke;

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                IOUtils.closeQuietly(reader);
            }

            return null;
        }

        public static void main(String[] args)
        {
            RandomDadJokeAPI client = new RandomDadJokeAPI();

            ArrayList<RandomJoke> allJokes = client.readJokes();
            System.out.println(allJokes);
        }
}
