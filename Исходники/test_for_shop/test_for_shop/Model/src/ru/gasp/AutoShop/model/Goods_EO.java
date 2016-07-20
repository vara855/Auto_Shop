package ru.gasp.AutoShop.model;

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
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Goods_EO.findAll", query = "select o from Goods_EO o") })
@Table(name = "GOODS")
public class Goods_EO implements Serializable {
    private static final long serialVersionUID = 5713755569448762115L;
    private BigDecimal cost;
    @Id
    @Column(name = "ID_GOOD", nullable = false)
    private BigDecimal idGood;
    private String name;
    @ManyToOne
    @JoinColumn(name = "ID_GROUP")
    private GoodGroup_EO goodGroup;
    @OneToMany(mappedBy = "goods_EO", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<GoodsInOrder_EO> goodsInOrderList;
    @OneToMany(mappedBy = "goods_EO1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Sales_EO> salesList1;

    public Goods_EO() {
    }

    public Goods_EO(BigDecimal cost, BigDecimal idGood, GoodGroup_EO goodGroup, String name) {
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

    public GoodGroup_EO getGoodGroup() {
        return goodGroup;
    }

    public void setGoodGroup(GoodGroup_EO goodGroup) {
        this.goodGroup = goodGroup;
    }

    public List<GoodsInOrder_EO> getGoodsInOrderList() {
        return goodsInOrderList;
    }

    public void setGoodsInOrderList(List<GoodsInOrder_EO> goodsInOrderList) {
        this.goodsInOrderList = goodsInOrderList;
    }

    public GoodsInOrder_EO addGoodsInOrder_EO(GoodsInOrder_EO goodsInOrder_EO) {
        getGoodsInOrderList().add(goodsInOrder_EO);
        goodsInOrder_EO.setGoods_EO(this);
        return goodsInOrder_EO;
    }

    public GoodsInOrder_EO removeGoodsInOrder_EO(GoodsInOrder_EO goodsInOrder_EO) {
        getGoodsInOrderList().remove(goodsInOrder_EO);
        goodsInOrder_EO.setGoods_EO(null);
        return goodsInOrder_EO;
    }

    public List<Sales_EO> getSalesList1() {
        return salesList1;
    }

    public void setSalesList1(List<Sales_EO> salesList1) {
        this.salesList1 = salesList1;
    }

    public Sales_EO addSales_EO(Sales_EO sales_EO) {
        getSalesList1().add(sales_EO);
        sales_EO.setGoods_EO1(this);
        return sales_EO;
    }

    public Sales_EO removeSales_EO(Sales_EO sales_EO) {
        getSalesList1().remove(sales_EO);
        sales_EO.setGoods_EO1(null);
        return sales_EO;
    }
}
