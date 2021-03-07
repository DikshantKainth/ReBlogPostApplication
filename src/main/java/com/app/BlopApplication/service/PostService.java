package com.app.BlopApplication.service;


import com.app.BlopApplication.model.Post;
import com.app.BlopApplication.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {


    //---------------------------------------------------------------------------------------------------------------

    //Singleton
    //private static ArrayList<Post> POSTS=new ArrayList<>();

    /*private final String url="jdbc:postgresql://localhost:5432/technicalblog";
    private final String username="postgres";
    private final String password="$29052000";


    public Connection connect() throws SQLException{
        return DriverManager.getConnection(url,username,password);
    }*/

    //----------------------------------------------------------------------------------------------------------------

    //Using JPA -> Communicate | EntityManagerFactory->EntityManager

    @Autowired
    private PostRepository postRepository;
    public List<Post> getAllPosts(){

        return postRepository.getAllPosts();

        //------------------------------------------------------------------------------------------------------------

        //Using JDBC
        /*try{
            //Business logic for connecting the database.

            //Step1. Connect to database.
            Connection connection=connect();

            //Step2. Get / create the statement.
            Statement statement= connect().createStatement();

            //Step3. Execute the select query.
            ResultSet resultSet= statement.executeQuery("SELECT * FROM posts");

            //Step4. Loop into the resultSet and get the data.
            while(resultSet.next()){
                Post post1=new Post();
                post1.setTitle(resultSet.getString("title"));
                post1.setBody(resultSet.getString("body"));
                post1.setDate(resultSet.getDate("date"));
                POSTS.add(post1);
            }

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return POSTS;*/

        //-----------------------------------------------------------------------------------------------------------
    }

    public void createPost(Post newPost){


        postRepository.createPost(newPost);


        //----------------------------------------------------------------------------------------------------------
        //Using JDBC


        /*String query="INSERT INTO posts(title,body,date) VALUES(?,?,?)";
        try{
            //Step1. Connect to database.
            Connection connection=connect();

            //Step2. Prepare a statement.
            PreparedStatement preparedStatement= connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            //Step3. Fix the values from the views.
            preparedStatement.setString(1, newPost.getTitle());
            preparedStatement.setString(2, newPost.getBody());
            preparedStatement.setDate(3,new Date(newPost.getDate().getTime()));

            int updatedRows= preparedStatement.executeUpdate();

            if(updatedRows>0){
                System.out.println("Update working fine");
            }

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }*/

        //----------------------------------------------------------------------------------------------------------
    }

    public void deletePost(Integer postId){
        postRepository.deletePost(postId);
    }
}
