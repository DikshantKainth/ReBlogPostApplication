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
                                  //userId received to get particular post of user.
    public List<Post> getAllPosts(Integer userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
                                                            //Query Changed
        TypedQuery<Post> query = entityManager.createQuery("select p from Post p JOIN FETCH p.user puser WHERE puser.id=:userId", Post.class);

        //Added below line
        query.setParameter("userId",userId);

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
