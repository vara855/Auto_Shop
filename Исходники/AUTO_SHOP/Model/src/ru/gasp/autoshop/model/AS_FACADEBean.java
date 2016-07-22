package ru.gasp.autoshop.model;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "AS_FACADE", mappedName = "AUTO_SHOP-Model-AS_FACADE")
public class AS_FACADEBean implements AS_FACADE, AS_FACADELocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Model")
    private EntityManager em;

    public AS_FACADEBean() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    public Users mergeUsers(Users users) {
        return em.merge(users);
    }

    public void removeUsers(Users users) {
        users = em.find(Users.class, users.getIdUser());
        em.remove(users);
    }

    /** <code>select o from Users o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Users> getUsersFindAll() {
        return em.createNamedQuery("Users.findAll", Users.class).getResultList();
    }

    public Goods mergeGoods(Goods goods) {
        return em.merge(goods);
    }

    public void removeGoods(Goods goods) {
        goods = em.find(Goods.class, goods.getIdGood());
        em.remove(goods);
    }

    /** <code>select o from Goods o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Goods> getGoodsFindAll() {
        return em.createNamedQuery("Goods.findAll", Goods.class).getResultList();
    }

    public Orders mergeOrders(Orders orders) {
        return em.merge(orders);
    }

    public void removeOrders(Orders orders) {
        orders = em.find(Orders.class, orders.getIdOrder());
        em.remove(orders);
    }

    /** <code>select o from Orders o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrdersFindAll() {
        return em.createNamedQuery("Orders.findAll", Orders.class).getResultList();
    }

    public Sales mergeSales(Sales sales) {
        return em.merge(sales);
    }

    public void removeSales(Sales sales) {
        sales = em.find(Sales.class, sales.getIdSales());
        em.remove(sales);
    }

    /** <code>select o from Sales o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Sales> getSalesFindAll() {
        return em.createNamedQuery("Sales.findAll", Sales.class).getResultList();
    }

    public GoodGroup mergeGoodGroup(GoodGroup goodGroup) {
        return em.merge(goodGroup);
    }

    public void removeGoodGroup(GoodGroup goodGroup) {
        goodGroup = em.find(GoodGroup.class, goodGroup.getIdGroup());
        em.remove(goodGroup);
    }

    /** <code>select o from GoodGroup o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<GoodGroup> getGoodGroupFindAll() {
        return em.createNamedQuery("GoodGroup.findAll", GoodGroup.class).getResultList();
    }

    public GoodsInOrder mergeGoodsInOrder(GoodsInOrder goodsInOrder) {
        return em.merge(goodsInOrder);
    }

    public void removeGoodsInOrder(GoodsInOrder goodsInOrder) {
        goodsInOrder = em.find(GoodsInOrder.class, goodsInOrder.getIdGoodsInOrder());
        em.remove(goodsInOrder);
    }

    /** <code>select o from GoodsInOrder o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<GoodsInOrder> getGoodsInOrderFindAll() {
        return em.createNamedQuery("GoodsInOrder.findAll", GoodsInOrder.class).getResultList();
    }

    /** <code>select o from Goods o where o.name like :p_name</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Goods> getGoodsFindByName(String p_name) {
        return em.createNamedQuery("Goods.findByName", Goods.class)
                 .setParameter("p_name", p_name)
                 .getResultList();
    }

    /** <code>select o from Goods o where o.idGood = :p_id</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Goods> getGoodsGetById(BigDecimal p_id) {
        return em.createNamedQuery("Goods.getById", Goods.class)
                 .setParameter("p_id", p_id)
                 .getResultList();
    }

    /** <code>select o from Goods o where o.goodGroup = :p_idGroup</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Goods> getGoodsGetByIdGroup(GoodGroup p_idGroup) {
        return em.createNamedQuery("Goods.getByIdGroup", Goods.class)
                 .setParameter("p_idGroup", p_idGroup)
                 .getResultList();
    }

    /** <code>select o from GoodsInOrder o where o.curCost > :p_costMore</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<GoodsInOrder> getGoodsInOrderCostMoreThan(BigDecimal p_costMore) {
        return em.createNamedQuery("GoodsInOrder.costMoreThan", GoodsInOrder.class)
                 .setParameter("p_costMore", p_costMore)
                 .getResultList();
    }

    /** <code>select o from GoodsInOrder o where o.curCost < :p_costLess</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<GoodsInOrder> getGoodsInOrderCostLessThan(BigDecimal p_costLess) {
        return em.createNamedQuery("GoodsInOrder.costLessThan", GoodsInOrder.class)
                 .setParameter("p_costLess", p_costLess)
                 .getResultList();
    }

    /** <code>select o from GoodsInOrder o where o.curCost = :p_costExactly</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<GoodsInOrder> getGoodsInOrderCostExactly(BigDecimal p_costExactly) {
        return em.createNamedQuery("GoodsInOrder.costExactly", GoodsInOrder.class)
                 .setParameter("p_costExactly", p_costExactly)
                 .getResultList();
    }

    /** <code>select o from GoodsInOrder o where o.goodAmount > :p_goodAmountMore</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<GoodsInOrder> getGoodsInOrderGoodAmountMoreThan(BigDecimal p_goodAmountMore) {
        return em.createNamedQuery("GoodsInOrder.goodAmountMoreThan", GoodsInOrder.class)
                 .setParameter("p_goodAmountMore", p_goodAmountMore)
                 .getResultList();
    }

    /** <code>select o from GoodsInOrder o where o.goodAmount < :p_goodAmountLess</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<GoodsInOrder> getGoodsInOrderGoodAmountLessThan(BigDecimal p_goodAmountLess) {
        return em.createNamedQuery("GoodsInOrder.goodAmountLessThan", GoodsInOrder.class)
                 .setParameter("p_goodAmountLess", p_goodAmountLess)
                 .getResultList();
    }

    /** <code>select o from GoodsInOrder o  where o.goodAmount = :p_goodAmountExactly</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<GoodsInOrder> getGoodsInOrderGoodAmountExactly(BigDecimal p_goodAmountExactly) {
        return em.createNamedQuery("GoodsInOrder.goodAmountExactly", GoodsInOrder.class)
                 .setParameter("p_goodAmountExactly", p_goodAmountExactly)
                 .getResultList();
    }

    /** <code>select o from GoodsInOrder o where o.goods = :p_idGoodFk</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<GoodsInOrder> getGoodsInOrderGetByIdGood(Goods p_idGoodFk) {
        return em.createNamedQuery("GoodsInOrder.getByIdGood", GoodsInOrder.class)
                 .setParameter("p_idGoodFk", p_idGoodFk)
                 .getResultList();
    }

    /** <code>select o from GoodsInOrder o where o.orders = :p_idOrderFk</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<GoodsInOrder> getGoodsInOrderGetByIdOrder(Orders p_idOrderFk) {
        return em.createNamedQuery("GoodsInOrder.getByIdOrder", GoodsInOrder.class)
                 .setParameter("p_idOrderFk", p_idOrderFk)
                 .getResultList();
    }

    /** <code>select o from GoodsInOrder o where o.idGoodsInOrder = :p_idGoodsInOrder</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<GoodsInOrder> getGoodsInOrderGetByIdGoodsInOrder(BigDecimal p_idGoodsInOrder) {
        return em.createNamedQuery("GoodsInOrder.getByIdGoodsInOrder", GoodsInOrder.class)
                 .setParameter("p_idGoodsInOrder", p_idGoodsInOrder)
                 .getResultList();
    }

    /** <code>select o from GoodGroup o where o.idGroup = :p_idGoodGroup</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<GoodGroup> getGoodGroupGetByIdGroupGood(BigDecimal p_idGoodGroup) {
        return em.createNamedQuery("GoodGroup.getByIdGroupGood", GoodGroup.class)
                 .setParameter("p_idGoodGroup", p_idGoodGroup)
                 .getResultList();
    }

    /** <code>select o from GoodGroup o where o.groupGood like :p_groupGood</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<GoodGroup> getGoodGroupGetByGroupGood(String p_groupGood) {
        return em.createNamedQuery("GoodGroup.getByGroupGood", GoodGroup.class)
                 .setParameter("p_groupGood", p_groupGood)
                 .getResultList();
    }

    /** <code>select o from Orders o where o.idOrder = :p_idOrder</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrdersGetByIdOrder(BigDecimal p_idOrder) {
        return em.createNamedQuery("Orders.getByIdOrder", Orders.class)
                 .setParameter("p_idOrder", p_idOrder)
                 .getResultList();
    }

    /** <code>select o from Orders o where o.users = :p_idUser</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrdersGetByIdUser(Users p_idUser) {
        return em.createNamedQuery("Orders.getByIdUser", Orders.class)
                 .setParameter("p_idUser", p_idUser)
                 .getResultList();
    }

    /** <code>select o from Orders o where o.orderDate like :p_orderDate</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrdersGetByDate(Date p_orderDate) {
        return em.createNamedQuery("Orders.getByDate", Orders.class)
                 .setParameter("p_orderDate", p_orderDate)
                 .getResultList();
    }

    /** <code>select o from Orders o where o.curBonus > :p_curBonusMore</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrdersCurrentBonusMoreThan(BigDecimal p_curBonusMore) {
        return em.createNamedQuery("Orders.currentBonusMoreThan", Orders.class)
                 .setParameter("p_curBonusMore", p_curBonusMore)
                 .getResultList();
    }

    /** <code>select o from Orders o where o.curBonus < :p_curBonusLess</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrdersCurrentBonusLessThan(BigDecimal p_curBonusLess) {
        return em.createNamedQuery("Orders.currentBonusLessThan", Orders.class)
                 .setParameter("p_curBonusLess", p_curBonusLess)
                 .getResultList();
    }

    /** <code>select o from Orders o where o.curBonus = :p_curBonusExactly</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrdersCurrentBonusExactly(BigDecimal p_curBonusExactly) {
        return em.createNamedQuery("Orders.currentBonusExactly", Orders.class)
                 .setParameter("p_curBonusExactly", p_curBonusExactly)
                 .getResultList();
    }

    /** <code>select o from Orders o where o.curPersonalDiscount > :p_curPersonalDiscMore</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrdersCurrentPersonalDiscountMoreThan(BigDecimal p_curPersonalDiscMore) {
        return em.createNamedQuery("Orders.currentPersonalDiscountMoreThan", Orders.class)
                 .setParameter("p_curPersonalDiscMore", p_curPersonalDiscMore)
                 .getResultList();
    }

    /** <code>select o from Orders o where o.curPersonalDiscount < :p_curPersonalDiscLess</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrdersCurrentPersonalDiscountLessThan(BigDecimal p_curPersonalDiscLess) {
        return em.createNamedQuery("Orders.currentPersonalDiscountLessThan", Orders.class)
                 .setParameter("p_curPersonalDiscLess", p_curPersonalDiscLess)
                 .getResultList();
    }

    /** <code>select o from Orders o where o.curPersonalDiscount = :p_curPersonalDiscExactly</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrdersCurrentPersonalDiscountExactly(BigDecimal p_curPersonalDiscExactly) {
        return em.createNamedQuery("Orders.currentPersonalDiscountExactly", Orders.class)
                 .setParameter("p_curPersonalDiscExactly", p_curPersonalDiscExactly)
                 .getResultList();
    }

    /** <code>select o from Orders o where o.totalAmount > :p_totalAmountMore</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrdersTotalAmountMoreThan(BigDecimal p_totalAmountMore) {
        return em.createNamedQuery("Orders.totalAmountMoreThan", Orders.class)
                 .setParameter("p_totalAmountMore", p_totalAmountMore)
                 .getResultList();
    }

    /** <code>select o from Orders o where o.totalAmount < :p_totalAmountLess</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrdersTotalAmountLessThan(BigDecimal p_totalAmountLess) {
        return em.createNamedQuery("Orders.totalAmountLessThan", Orders.class)
                 .setParameter("p_totalAmountLess", p_totalAmountLess)
                 .getResultList();
    }

    /** <code>select o from Orders o where o.totalAmount = :p_totalAmountExactly</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrdersTotalAmountExactly(BigDecimal p_totalAmountExactly) {
        return em.createNamedQuery("Orders.totalAmountExactly", Orders.class)
                 .setParameter("p_totalAmountExactly", p_totalAmountExactly)
                 .getResultList();
    }

    /** <code>select o from Orders o where o.totalAmountWithSale > :p_totalAmountWithSaleMore</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrdersTotalAmountWithSaleMoreThan(BigDecimal p_totalAmountWithSaleMore) {
        return em.createNamedQuery("Orders.totalAmountWithSaleMoreThan", Orders.class)
                 .setParameter("p_totalAmountWithSaleMore", p_totalAmountWithSaleMore)
                 .getResultList();
    }

    /** <code>select o from Orders o where o.totalAmountWithSale < :p_totalAmountWithSaleLess</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrdersTotalAmountWithSaleLessThan(BigDecimal p_totalAmountWithSaleLess) {
        return em.createNamedQuery("Orders.totalAmountWithSaleLessThan", Orders.class)
                 .setParameter("p_totalAmountWithSaleLess", p_totalAmountWithSaleLess)
                 .getResultList();
    }

    /** <code>select o from Orders o where o.totalAmountWithSale = :p_totalAmountWithSaleExactly</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrdersTotalAmountWithSaleExactly(BigDecimal p_totalAmountWithSaleExactly) {
        return em.createNamedQuery("Orders.totalAmountWithSaleExactly", Orders.class)
                 .setParameter("p_totalAmountWithSaleExactly", p_totalAmountWithSaleExactly)
                 .getResultList();
    }

    /** <code>select o from Sales o where o.idSales = :p_idSales</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Sales> getSalesGetByIdSales(BigDecimal p_idSales) {
        return em.createNamedQuery("Sales.getByIdSales", Sales.class)
                 .setParameter("p_idSales", p_idSales)
                 .getResultList();
    }

    /** <code>select o from Sales o where o.goods1 = :p_idGood</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Sales> getSalesGetByIdGood(Goods p_idGood) {
        return em.createNamedQuery("Sales.getByIdGood", Sales.class)
                 .setParameter("p_idGood", p_idGood)
                 .getResultList();
    }

    /** <code>select o from Sales o where o.goodGroup2 = :p_idGroupGood</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Sales> getSalesGetByIdFroup(GoodGroup p_idGroupGood) {
        return em.createNamedQuery("Sales.getByIdFroup", Sales.class)
                 .setParameter("p_idGroupGood", p_idGroupGood)
                 .getResultList();
    }

    /** <code>select o from Sales o where o.valueRub > :p_valueRubMore and o.valueRub is not null</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Sales> getSalesValueRubMoreThan(BigDecimal p_valueRubMore) {
        return em.createNamedQuery("Sales.valueRubMoreThan", Sales.class)
                 .setParameter("p_valueRubMore", p_valueRubMore)
                 .getResultList();
    }

    /** <code>select o from Sales o where o.valueRub < :p_valueRubLess and o.valueRub is not null</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Sales> getSalesValueRubLessThan(BigDecimal p_valueRubLess) {
        return em.createNamedQuery("Sales.valueRubLessThan", Sales.class)
                 .setParameter("p_valueRubLess", p_valueRubLess)
                 .getResultList();
    }

    /** <code>select o from Sales o where o.valueRub = :p_valueRubExactly and o.valueRub is not null</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Sales> getSalesValueRubExactly(BigDecimal p_valueRubExactly) {
        return em.createNamedQuery("Sales.valueRubExactly", Sales.class)
                 .setParameter("p_valueRubExactly", p_valueRubExactly)
                 .getResultList();
    }

    /** <code>select o from Sales o where o.valuePercent > :p_valuePercentMore and o.valuePercent is not null</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Sales> getSalesValuePercentMoreThan(BigDecimal p_valuePercentMore) {
        return em.createNamedQuery("Sales.valuePercentMoreThan", Sales.class)
                 .setParameter("p_valuePercentMore", p_valuePercentMore)
                 .getResultList();
    }

    /** <code>select o from Sales o where o.valuePercent < :p_valuePercentLess and o.valuePercent is not null</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Sales> getSalesValuePercentLessThan(BigDecimal p_valuePercentLess) {
        return em.createNamedQuery("Sales.valuePercentLessThan", Sales.class)
                 .setParameter("p_valuePercentLess", p_valuePercentLess)
                 .getResultList();
    }

    /** <code>select o from Sales o where o.valuePercent = :p_valuerPercentExactly and o.valuePercent is not null</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Sales> getSalesValuePercentExactly(BigDecimal p_valuerPercentExactly) {
        return em.createNamedQuery("Sales.valuePercentExactly", Sales.class)
                 .setParameter("p_valuerPercentExactly", p_valuerPercentExactly)
                 .getResultList();
    }

    /** <code>select o from Sales o where o.dataEnd like :p_dataEnd</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Sales> getSalesDataEnd(Date p_dataEnd) {
        return em.createNamedQuery("Sales.dataEnd", Sales.class)
                 .setParameter("p_dataEnd", p_dataEnd)
                 .getResultList();
    }

    /** <code>select o from Sales o where o.minAmountToGet > :p_minAmountToGetMore</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Sales> getSalesMinAmountToGetMoreThan(BigDecimal p_minAmountToGetMore) {
        return em.createNamedQuery("Sales.minAmountToGetMoreThan", Sales.class)
                 .setParameter("p_minAmountToGetMore", p_minAmountToGetMore)
                 .getResultList();
    }

    /** <code>select o from Sales o where o.minAmountToGet < :p_minAmountToGetMore</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Sales> getSalesMinAmountToGetLessThan(BigDecimal p_minAmountToGetMore) {
        return em.createNamedQuery("Sales.minAmountToGetLessThan", Sales.class)
                 .setParameter("p_minAmountToGetMore", p_minAmountToGetMore)
                 .getResultList();
    }

    /** <code>select o from Sales o where o.minAmountToGet = :p_minAmountToGetExactly</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Sales> getSalesMinAmountToGetExactly(BigDecimal p_minAmountToGetExactly) {
        return em.createNamedQuery("Sales.minAmountToGetExactly", Sales.class)
                 .setParameter("p_minAmountToGetExactly", p_minAmountToGetExactly)
                 .getResultList();
    }

    /** <code>select o from Sales o where o.keyWord = :p_keyWord</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Sales> getSalesGetByKeyWord(String p_keyWord) {
        return em.createNamedQuery("Sales.getByKeyWord", Sales.class)
                 .setParameter("p_keyWord", p_keyWord)
                 .getResultList();
    }

    /** <code>select o from Users o where o.idUser = :p_idUser</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Users> getUsersGetByIdUser(BigDecimal p_idUser) {
        return em.createNamedQuery("Users.getByIdUser", Users.class)
                 .setParameter("p_idUser", p_idUser)
                 .getResultList();
    }

    /** <code>select o from Users o where o.login = :p_login</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Users> getUsersGetByLogin(String p_login) {
        return em.createNamedQuery("Users.getByLogin", Users.class)
                 .setParameter("p_login", p_login)
                 .getResultList();
    }

    /** <code>select o from Users o where o.name like :p_name</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Users> getUsersGetByName(String p_name) {
        return em.createNamedQuery("Users.getByName", Users.class)
                 .setParameter("p_name", p_name)
                 .getResultList();
    }

    /** <code>select o from Users o where o.surname like :p_surname</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Users> getUsersGetBySurname(String p_surname) {
        return em.createNamedQuery("Users.getBySurname", Users.class)
                 .setParameter("p_surname", p_surname)
                 .getResultList();
    }

    /** <code>select o from Users o where o.thirdName like :p_thirdName</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Users> getUsersGetByThirdName(String p_thirdName) {
        return em.createNamedQuery("Users.getByThirdName", Users.class)
                 .setParameter("p_thirdName", p_thirdName)
                 .getResultList();
    }

    /** <code>select o from Users o where o.telephone like :p_telephone</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Users> getUsersGetByTelephone(String p_telephone) {
        return em.createNamedQuery("Users.getByTelephone", Users.class)
                 .setParameter("p_telephone", p_telephone)
                 .getResultList();
    }

    /** <code>select o from Users o where o.bonus > :p_bonusMore</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Users> getUsersBonusMoreThan(BigDecimal p_bonusMore) {
        return em.createNamedQuery("Users.bonusMoreThan", Users.class)
                 .setParameter("p_bonusMore", p_bonusMore)
                 .getResultList();
    }

    /** <code>select o from Users o where o.bonus < :p_bonusLess</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Users> getUsersBonusLessThan(BigDecimal p_bonusLess) {
        return em.createNamedQuery("Users.bonusLessThan", Users.class)
                 .setParameter("p_bonusLess", p_bonusLess)
                 .getResultList();
    }

    /** <code>select o from Users o where o.bonus = :p_bonusExactly</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Users> getUsersBonusExactly(BigDecimal p_bonusExactly) {
        return em.createNamedQuery("Users.bonusExactly", Users.class)
                 .setParameter("p_bonusExactly", p_bonusExactly)
                 .getResultList();
    }

    /** <code>select o from Users o where o.personalDiscount > :p_personalDiscMore</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Users> getUsersPersonalDiscountMoreThan(BigDecimal p_personalDiscMore) {
        return em.createNamedQuery("Users.personalDiscountMoreThan", Users.class)
                 .setParameter("p_personalDiscMore", p_personalDiscMore)
                 .getResultList();
    }

    /** <code>select o from Users o where o.personalDiscount < :p_personalDiscLess</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Users> getUsersPersonalDiscountLessThan(BigDecimal p_personalDiscLess) {
        return em.createNamedQuery("Users.personalDiscountLessThan", Users.class)
                 .setParameter("p_personalDiscLess", p_personalDiscLess)
                 .getResultList();
    }

    /** <code>select o from Users o where o.personalDiscount = :p_personalDiscExactly</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Users> getUsersPersonalDiscountExactly(BigDecimal p_personalDiscExactly) {
        return em.createNamedQuery("Users.personalDiscountExactly", Users.class)
                 .setParameter("p_personalDiscExactly", p_personalDiscExactly)
                 .getResultList();
    }
}
