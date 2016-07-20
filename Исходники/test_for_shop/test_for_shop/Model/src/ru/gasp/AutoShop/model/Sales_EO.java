package ru.gasp.AutoShop.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Sales_EO.findAll", query = "select o from Sales_EO o") })
@Table(name = "SALES")
public class Sales_EO implements Serializable {
    private static final long serialVersionUID = 2606066424194922110L;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_END")
    private Date dataEnd;
    @Id
    @Column(name = "ID_SALES", nullable = false)
    private BigDecimal idSales;
    @Column(name = "KEY_WORD", unique = true)
    private String keyWord;
    @Column(name = "MIN_AMOUNT_TO_GET")
    private BigDecimal minAmountToGet;
    @Column(name = "VALUE_PERCENT")
    private BigDecimal valuePercent;
    @Column(name = "VALUE_RUB")
    private BigDecimal valueRub;
    @ManyToOne
    @JoinColumn(name = "ID_GROUP")
    private GoodGroup_EO goodGroup2;
    @ManyToOne
    @JoinColumn(name = "ID_GOOD")
    private Goods_EO goods_EO1;

    public Sales_EO() {
    }

    public Sales_EO(Date dataEnd, Goods_EO goods_EO1, GoodGroup_EO goodGroup2, BigDecimal idSales, String keyWord,
                    BigDecimal minAmountToGet, BigDecimal valuePercent, BigDecimal valueRub) {
        this.dataEnd = dataEnd;
        this.goods_EO1 = goods_EO1;
        this.goodGroup2 = goodGroup2;
        this.idSales = idSales;
        this.keyWord = keyWord;
        this.minAmountToGet = minAmountToGet;
        this.valuePercent = valuePercent;
        this.valueRub = valueRub;
    }

    public Date getDataEnd() {
        return dataEnd;
    }

    public void setDataEnd(Date dataEnd) {
        this.dataEnd = dataEnd;
    }


    public BigDecimal getIdSales() {
        return idSales;
    }

    public void setIdSales(BigDecimal idSales) {
        this.idSales = idSales;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public BigDecimal getMinAmountToGet() {
        return minAmountToGet;
    }

    public void setMinAmountToGet(BigDecimal minAmountToGet) {
        this.minAmountToGet = minAmountToGet;
    }

    public BigDecimal getValuePercent() {
        return valuePercent;
    }

    public void setValuePercent(BigDecimal valuePercent) {
        this.valuePercent = valuePercent;
    }

    public BigDecimal getValueRub() {
        return valueRub;
    }

    public void setValueRub(BigDecimal valueRub) {
        this.valueRub = valueRub;
    }

    public GoodGroup_EO getGoodGroup2() {
        return goodGroup2;
    }

    public void setGoodGroup2(GoodGroup_EO goodGroup2) {
        this.goodGroup2 = goodGroup2;
    }

    public Goods_EO getGoods_EO1() {
        return goods_EO1;
    }

    public void setGoods_EO1(Goods_EO goods_EO1) {
        this.goods_EO1 = goods_EO1;
    }
}
