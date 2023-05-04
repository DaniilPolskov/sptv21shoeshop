
package facades;

import entity.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "SPTV21_webBootsShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    public User findByLogin(String login){
        try {
            return (User) em.createQuery("SELECT u FROM User u WHERE u.login=:login").setParameter("login", login).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
