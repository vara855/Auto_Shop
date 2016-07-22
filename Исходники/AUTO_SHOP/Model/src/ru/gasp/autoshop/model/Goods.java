package ru.gasp.autoshop.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "Goods.findAll", query = "select o from Goods o"), 
                @NamedQuery(name = "Goods.findByName", query = "select o from Goods o where o.name like :p_name"),
                @NamedQuery(name = "Goods.getById", query = "select o from Goods o where o.idGood = :p_id"),
                @NamedQuery(name = "Goods.getByIdGroup", query = "select o from Goods o where o.goodGroup = :p_idGroup")})
public class Goods implements Serializable {
    private static final long serialVersionUID = 1845620274466695474L;
    private BigDecimal cost;
    @Id
    @Column(name = "ID_GOOD", nullable = false)
    private BigDecimal idGood;
    private String name;
    @ManyToOne
    @JoinColumn(name = "ID_GROUP")
    private GoodGroup goodGroup;
    @OneToMany(mappedBy = "goods", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<GoodsInOrder> goodsInOrderList;
    @OneToMany(mappedBy = "goods1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Sales> salesList1;

    public Goods() {
    }

    public Goods(BigDecimal cost, BigDecimal idGood, GoodGroup goodGroup, String name) {
        this.cost = cost;
        this.idGood = idGood;
        this.goodGroup = goodGroup;
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getIdGood() {
        return idGood;
    }

    public void setIdGood(BigDecimal idGood) {
        this.idGood = idGood;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GoodGroup getGoodGroup() {
        return goodGroup;
    }

    public void setGoodGroup(GoodGroup goodGroup) {
        this.goodGroup = goodGroup;
    }

    public List<GoodsInOrder> getGoodsInOrderList() {
        return goodsInOrderList;
    }

    public void setGoodsInOrderList(List<GoodsInOrder> goodsInOrderList) {
        this.goodsInOrderList = goodsInOrderList;
    }

    public GoodsInOrder addGoodsInOrder(GoodsInOrder goodsInOrder) {
        getGoodsInOrderList().add(goodsInOrder);
        goodsInOrder.setGoods(this);
        return goodsInOrder;
    }

    public GoodsInOrder removeGoodsInOrder(GoodsInOrder goodsInOrder) {
        getGoodsInOrderList().remove(goodsInOrder);
        goodsInOrder.setGoods(null);
        return goodsInOrder;
    }

    public List<Sales> getSalesList1() {
        return salesList1;
    }

    public void setSalesList1(List<Sales> salesList1) {
        this.salesList1 = salesList1;
    }

    public Sales addSales(Sales sales) {
        getSalesList1().add(sales);
        sales.setGoods1(this);
        return sales;
    }

    public Sales removeSales(Sales sales) {
        getSalesList1().remove(sales);
        sales.setGoods1(null);
        return sales;
    }
}
