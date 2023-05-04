
package facades;

import entity.Role;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class RoleFacade extends AbstractFacade<Role> {

    @PersistenceContext(unitName = "SPTV21_webBootsShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoleFacade() {
        super(Role.class);
    }

    public Role findRoleByRoleName(String roleName) {
        try {
            return (Role) em.createQuery("SELECT r FROM Role r WHERE r.roleName = :roleName")
                    .setParameter("roleName", roleName)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
