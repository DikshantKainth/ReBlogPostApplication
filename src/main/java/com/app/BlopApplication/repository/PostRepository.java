package com.app.BlopApplication.repository;

import com.app.BlopApplication.model.Post;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.List;

@RestController
public class PostRepository {

    PostRepository(){
        System.out.println("*** Repository Created ***");
    }
    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory entityManagerFactory;

    public List<Post> getAllPosts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Post> query = entityManager.createQuery("select p from Post p", Post.class);
        List<Post> result = query.getResultList();
        return result;
    }


    public void createPost(Post newPost){


        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction= entityManager.getTransaction();
        try{

            transaction.begin();
            entityManager.persist(newPost);
            transaction.commit();
        }
        catch(Exception e){

            System.out.println(e);
            transaction.rollback();
        }
    }


    public void deletePost(Integer postId){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction= entityManager.getTransaction();
        try{

            transaction.begin();
            Post post=entityManager.find(Post.class, postId);
            entityManager.remove(post);
            transaction.commit();
        }
        catch(Exception e){
            System.out.println(e);
            transaction.rollback();
        }
    }
}
