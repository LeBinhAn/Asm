package BTEC.Management.DataAccessObjects;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import BTEC.Management.Entities.AppUser;
import BTEC.Management.Entities.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
@Repository
@Transactional
public class AppUserDAO {
 
    @Autowired
    private EntityManager entityManager;
 
    public AppUser findUserAccount(String userName) {
        try {
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.userName = :userName ";
 
            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName", userName);
 
            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<AppUser> findTrainerOnly(Long roleId) {


        List<AppUser> users = new ArrayList<>();

        String sql = "Select ur.appUser.userId from " + UserRole.class.getName() + " ur " //
                + " where ur.appRole.roleId = :roleId ";
 
        Query query = this.entityManager.createQuery(sql, Long.class);
        query.setParameter("roleId", roleId);
        List<Long> result = query.getResultList();
        for(Long i: result)
        {
            System.out.print(i);
            System.out.println("\n");
        }
        for (Long id : result) {
            String sql2 = "Select e from " + AppUser.class.getName() + " e " //
            + " Where e.userId = :id ";

            Query query2 = entityManager.createQuery(sql2, AppUser.class);
            query2.setParameter("id", id);
            users.add((AppUser) query2.getSingleResult());
        }
        return users;
    }
}