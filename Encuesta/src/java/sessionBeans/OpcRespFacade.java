/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entidades.OpcResp;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SiperProg
 */
@Stateless
public class OpcRespFacade extends AbstractFacade<OpcResp> {

    @PersistenceContext(unitName = "EncuestaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OpcRespFacade() {
        super(OpcResp.class);
    }

    public List<OpcResp> findOpXPreg(Long treCodido) {
        List<OpcResp> opFiltrada = em.createQuery("SELECT o FROM OpcResp o WHERE o.treCodigo = :treCodigo").setParameter("treCodigo", treCodido).getResultList();
        return opFiltrada;
    }

}
