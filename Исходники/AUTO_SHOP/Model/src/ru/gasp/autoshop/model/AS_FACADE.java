package ru.gasp.autoshop.model;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface AS_FACADE {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    Users mergeUsers(Users users);

    void removeUsers(Users users);

    List<Users> getUsersFindAll();

    Goods mergeGoods(Goods goods);

    void removeGoods(Goods goods);

    List<Goods> getGoodsFindAll();

    Orders mergeOrders(Orders orders);

    void removeOrders(Orders orders);

    List<Orders> getOrdersFindAll();

    Sales mergeSales(Sales sales);

    void removeSales(Sales sales);

    List<Sales> getSalesFindAll();

    GoodGroup mergeGoodGroup(GoodGroup goodGroup);

    void removeGoodGroup(GoodGroup goodGroup);

    List<GoodGroup> getGoodGroupFindAll();

    GoodsInOrder mergeGoodsInOrder(GoodsInOrder goodsInOrder);

    void removeGoodsInOrder(GoodsInOrder goodsInOrder);

    List<GoodsInOrder> getGoodsInOrderFindAll();

    List<Goods> getGoodsFindByName(String p_name);

    List<Goods> getGoodsGetById(BigDecimal p_id);

    List<Goods> getGoodsGetByIdGroup(GoodGroup p_idGroup);

    List<GoodsInOrder> getGoodsInOrderCostMoreThan(BigDecimal p_costMore);

    List<GoodsInOrder> getGoodsInOrderCostLessThan(BigDecimal p_costLess);

    List<GoodsInOrder> getGoodsInOrderCostExactly(BigDecimal p_costExactly);

    List<GoodsInOrder> getGoodsInOrderGoodAmountMoreThan(BigDecimal p_goodAmountMore);

    List<GoodsInOrder> getGoodsInOrderGoodAmountLessThan(BigDecimal p_goodAmountLess);

    List<GoodsInOrder> getGoodsInOrderGoodAmountExactly(BigDecimal p_goodAmountExactly);

    List<GoodsInOrder> getGoodsInOrderGetByIdGood(Goods p_idGoodFk);

    List<GoodsInOrder> getGoodsInOrderGetByIdOrder(Orders p_idOrderFk);

    List<GoodsInOrder> getGoodsInOrderGetByIdGoodsInOrder(BigDecimal p_idGoodsInOrder);

    List<GoodGroup> getGoodGroupGetByIdGroupGood(BigDecimal p_idGoodGroup);

    List<GoodGroup> getGoodGroupGetByGroupGood(String p_groupGood);

    List<Orders> getOrdersGetByIdOrder(BigDecimal p_idOrder);

    List<Orders> getOrdersGetByIdUser(Users p_idUser);

    List<Orders> getOrdersGetByDate(Date p_orderDate);

    List<Orders> getOrdersCurrentBonusMoreThan(BigDecimal p_curBonusMore);

    List<Orders> getOrdersCurrentBonusLessThan(BigDecimal p_curBonusLess);

    List<Orders> getOrdersCurrentBonusExactly(BigDecimal p_curBonusExactly);

    List<Orders> getOrdersCurrentPersonalDiscountMoreThan(BigDecimal p_curPersonalDiscMore);

    List<Orders> getOrdersCurrentPersonalDiscountLessThan(BigDecimal p_curPersonalDiscLess);

    List<Orders> getOrdersCurrentPersonalDiscountExactly(BigDecimal p_curPersonalDiscExactly);

    List<Orders> getOrdersTotalAmountMoreThan(BigDecimal p_totalAmountMore);

    List<Orders> getOrdersTotalAmountLessThan(BigDecimal p_totalAmountLess);

    List<Orders> getOrdersTotalAmountExactly(BigDecimal p_totalAmountExactly);

    List<Orders> getOrdersTotalAmountWithSaleMoreThan(BigDecimal p_totalAmountWithSaleMore);

    List<Orders> getOrdersTotalAmountWithSaleLessThan(BigDecimal p_totalAmountWithSaleLess);

    List<Orders> getOrdersTotalAmountWithSaleExactly(BigDecimal p_totalAmountWithSaleExactly);

    List<Sales> getSalesGetByIdSales(BigDecimal p_idSales);

    List<Sales> getSalesGetByIdGood(Goods p_idGood);

    List<Sales> getSalesGetByIdFroup(GoodGroup p_idGroupGood);

    List<Sales> getSalesValueRubMoreThan(BigDecimal p_valueRubMore);

    List<Sales> getSalesValueRubLessThan(BigDecimal p_valueRubLess);

    List<Sales> getSalesValueRubExactly(BigDecimal p_valueRubExactly);

    List<Sales> getSalesValuePercentMoreThan(BigDecimal p_valuePercentMore);

    List<Sales> getSalesValuePercentLessThan(BigDecimal p_valuePercentLess);

    List<Sales> getSalesValuePercentExactly(BigDecimal p_valuerPercentExactly);

    List<Sales> getSalesDataEnd(Date p_dataEnd);

    List<Sales> getSalesMinAmountToGetMoreThan(BigDecimal p_minAmountToGetMore);

    List<Sales> getSalesMinAmountToGetLessThan(BigDecimal p_minAmountToGetMore);

    List<Sales> getSalesMinAmountToGetExactly(BigDecimal p_minAmountToGetExactly);

    List<Sales> getSalesGetByKeyWord(String p_keyWord);

    List<Users> getUsersGetByIdUser(BigDecimal p_idUser);

    List<Users> getUsersGetByLogin(String p_login);

    List<Users> getUsersGetByName(String p_name);

    List<Users> getUsersGetBySurname(String p_surname);

    List<Users> getUsersGetByThirdName(String p_thirdName);

    List<Users> getUsersGetByTelephone(String p_telephone);

    List<Users> getUsersBonusMoreThan(BigDecimal p_bonusMore);

    List<Users> getUsersBonusLessThan(BigDecimal p_bonusLess);

    List<Users> getUsersBonusExactly(BigDecimal p_bonusExactly);

    List<Users> getUsersPersonalDiscountMoreThan(BigDecimal p_personalDiscMore);

    List<Users> getUsersPersonalDiscountLessThan(BigDecimal p_personalDiscLess);

    List<Users> getUsersPersonalDiscountExactly(BigDecimal p_personalDiscExactly);
}
