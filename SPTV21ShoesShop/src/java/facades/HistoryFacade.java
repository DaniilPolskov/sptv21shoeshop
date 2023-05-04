
package facades;

import entity.History;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class HistoryFacade extends AbstractFacade<History> {

    @PersistenceContext(unitName = "SPTV21_webBootsShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoryFacade() {
        super(History.class);
    }

    public List<History> findAllForUserByLogin(String login) {
        try {
            return em.createQuery("SELECT h FROM History h WHERE h.user.login=:login").setParameter("login", login).getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<History> findAllForMonth(int month) {
        try {
            return em.createQuery("SELECT h FROM History h WHERE EXTRACT(MONTH FROM h.purchaseDate) =:month").setParameter("month", month).getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
